package chapterSix;

import browser.BrowserFactoryAdvanced;
import browser.BrowserFactoryBasic;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestShopScenario  {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

