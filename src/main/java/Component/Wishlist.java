package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends Base{

    private static final By wishlistLinkLocator = By.cssSelector("p[class=\"content\"] a");
    private static final By priceLocator = By.cssSelector("span[class=\"product-unit-price\"]");

    public Wishlist(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addRandomProducts() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
        List<WebElement> products = driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
        for (WebElement product : products){
            Thread.sleep(1000);
            click(waitUntilElementToBeClickable(product));
        }
    }
    public void goToWishlist(){
        click(waitUntilElementToBeClickable(wishlistLinkLocator));
    }

    List<Double> doublePrices = new ArrayList<Double>();
    int i = 0;
    public List<Double> compareWishlistProducts() throws InterruptedException {
        waitUntilElementToBeVisible(priceLocator);
        List<WebElement> prices = driver.findElements(By.cssSelector("span[class=\"product-unit-price\"]"));
        for (WebElement price : prices){
            String price1 = price.getText();
            Double productPrice = Double.parseDouble(price1.replaceAll("[^\\d.]",""));
            doublePrices.add(productPrice);
            System.out.println("Product "+(i+1)+" price: " + doublePrices.get(i));
            i++;
            waitUntilElementToBeVisible(priceLocator);
        }
        double max = 0;
        for (double doublePrice : doublePrices){
            if (doublePrice > max) max = doublePrice;
        }
        System.out.println("Product with high price: " + max);
        return doublePrices;
    }
}
