package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestShopScenario {

    @Test
    public void fillInLoginPage() {

        String text = "Sign in.";
        Assertions.assertThat(text).as("No one is logged in.").contains(driver.findElement(By.cssSelector
                ("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInLoginPage("bootcamper@feelthepain.com", "1qazxsw2");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String infoAccount = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(infoAccount).as("Welcome message contains").contains("Welcome to your account.");

        //WebElement user = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a > span"));
        //Assertions.assertThat(user).as("User is").contains("Seargent Slaughter").getText();
    }
}
