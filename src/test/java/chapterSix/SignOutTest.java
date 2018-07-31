package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignOutTest extends TestShopScenario {

    @Test
    public void logInSuccesFull() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna.tester@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkom123!");
        driver.findElement(By.id("SubmitLogin")).click();

        String text = "MY ACCOUNT";
        Assertions.assertThat(text).as("Text on member page is correct").contains(driver.findElement(By.cssSelector("#center_column > h1")).getText());

        }

    @Test
    public void logOutSuccesFull() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna.tester@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkom123!");
        driver.findElement(By.id("SubmitLogin")).click();

        driver.findElement(By.className("logout")).click();

        String text = "Sign in";
        Assertions.assertThat(text).as("Check if the sign in element is present").contains(driver.findElement
                (By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        Assertions.assertThat(driver.findElement(By.cssSelector(".login")).getText()).as
                ("Check if the sign in element is present").isEqualTo("Sign in");

        String className = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_" +
                "user_info > a")).getAttribute("class");

        Assertions.assertThat(className).as("Check if the sign in element is present").isEqualTo("login");


    }

}


