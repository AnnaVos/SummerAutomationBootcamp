package chapterNine;

import chapterSix.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.util.concurrent.TimeUnit;

public class FillinContactFormTest extends TestShopScenario {

    @Test
    public void fillInForm() {
        // Open the contact page
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        String text = "Sign in.";
        Assertions.assertThat(text).as("No one is logged in.").contains(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one.");

        String texttext = "Your message has been successfully sent to our team.";
        Assertions.assertThat(texttext).as("Contact form is submitted").contains(driver.findElement(By.cssSelector("#center_column > p")).getText());
    }

}
