package homeWork;

import browser.BrowserFactoryBasic;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class loginAsUserAnna extends BrowserFactoryBasic {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactoryBasic.getDriver("ie");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // go to test shop:
        driver.get("https://techblog.polteq.com/testshop/index.php");

        // log in:
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna@vos.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}


