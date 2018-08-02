package browserDriven;

import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestShopScenarioBrowserDriven {
    protected WebDriver driver;

    @Parameters ("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser) {

        driver = BrowserFactoryAdvanced.getDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
