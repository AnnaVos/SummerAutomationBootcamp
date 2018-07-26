package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignOutTest {

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

        String text = "MY ACCOUNT";
        Assertions.assertThat(text).as("Text on member page is correct").contains(driver.findElement(By.cssSelector("#center_column > h1")).getText());

        driver.quit();
    }

    @Test
    public void logOutSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna.tester@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkom123!");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(3) > a")).click();

        String text = "Sign in";
        Assertions.assertThat(text).as("User is logged out").contains(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        driver.quit();
    }

}


// #center_column > h1
// #header > div.nav > div > div > nav > div:nth-child(3) > a
