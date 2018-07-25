package moveWebsiteExercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;
// import org.testng.assert;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {

    @Test
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna.tester@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkom123!");
        driver.findElement(By.id("SubmitLogin")).click();



    /* @Test
        public void assertMyAccountContains(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver(); */

        String infoAccount = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(infoAccount).as("Welcome message contains").contains("Welcome to your account.");

        WebElement header = driver.findElement (By.className("account"));
        Assertions.assertThat("header").as("Header is equal to").isEqualTo("Anna Tester");



    }
// driver.quit();
    }

