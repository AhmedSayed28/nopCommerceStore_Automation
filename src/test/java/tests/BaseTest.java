package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    private static Logger log = Logger.getLogger(BaseTest.class.getName());
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/cell-phones");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
