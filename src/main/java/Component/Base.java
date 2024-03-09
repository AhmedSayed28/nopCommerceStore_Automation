package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {

    protected static WebDriver driver;
    WebDriverWait wait;

    public Base(WebDriver driver){
        Base.driver = driver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }
    protected void setTextElement(WebElement textBox, String value){
        textBox.clear();
        textBox.sendKeys(value);
    }
    protected WebElement waitUntilElementToBeVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitUntilElementToBeVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected WebElement waitUntilElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected WebElement waitUntilElementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected void click(WebElement element){
        for (int i = 0; i < 10; i++) {
            try {
                element.click();
                break;
            }catch (ElementClickInterceptedException e){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


}
