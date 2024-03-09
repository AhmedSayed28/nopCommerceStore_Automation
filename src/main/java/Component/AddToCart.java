package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCart extends Base {

    private static final By electronicsLocator = By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/electronics\"]");
    private static final By cellPhoneLocator = By.cssSelector("div[class=\"item-grid\"] img[src=\"https://demo.nopcommerce.com/images/thumbs/0000007_cell-phones_450.jpeg\"]");
    private static final By cartLinkLocator = By.cssSelector("p[class=\"content\"] a");
    private static final By updateCartBtnLocator = By.cssSelector("button[class=\"button-2 update-cart-button\"]");
    private static final By cartTotalPriceLocator = By.cssSelector("span[class=\"value-summary\"] strong");



    public AddToCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addProductsToCart() throws InterruptedException {
        click(waitUntilElementToBeClickable(electronicsLocator));
        click(waitUntilElementToBeClickable(cellPhoneLocator));
        Thread.sleep(1000);
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]"));
        for (WebElement button : addToCartButtons){
            click(waitUntilElementToBeClickable(button));
            Thread.sleep(1000);
        }
        click(waitUntilElementToBeClickable(cartLinkLocator));
    }
    public void updateQty(int quantity) throws InterruptedException {
        List<WebElement> quantityInputLocator = driver.findElements(By.cssSelector("input[aria-label=\"Qty.\"]"));
        for (WebElement quantityInputElement : quantityInputLocator){
            setTextElement(quantityInputElement,String.valueOf(quantity));
        }
        click(waitUntilElementToBeClickable(updateCartBtnLocator));
    }
    public void printProductTotalPrice(){
        List<WebElement> productTotalPriceLocator = driver.findElements(By.cssSelector("span[class=\"product-subtotal\"]"));
        int i = 0;
        for (WebElement productTotalPrice : productTotalPriceLocator){
            String totalPrice = productTotalPrice.getText();
            i++;
            System.out.println("Product "+i+" Total Price: " + totalPrice);
        }
        System.out.println("ـــــــــــــــــــــــــــــــــ");
    }

    public double calcTotalPrice(){
        List<WebElement> productTotalPriceLocator = driver.findElements(By.cssSelector("span[class=\"product-subtotal\"]"));
        double sum = 0;
        for (WebElement productTotalPrice : productTotalPriceLocator){
            String totalPrice = productTotalPrice.getText();
            double doubleTotalPrice = Double.parseDouble(totalPrice.replaceAll("[^\\d.]",""));
            sum += doubleTotalPrice;
        }
        return sum;
    }
    public double getTotalPrice(){
        String total = driver.findElement(cartTotalPriceLocator).getText();
        double totalPrice = Double.parseDouble(total.replaceAll("[^\\d.]",""));
        return totalPrice;
    }
}
