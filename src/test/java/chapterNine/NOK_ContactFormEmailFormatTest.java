package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.util.concurrent.TimeUnit;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    @Test
    public void nokContactFormEmailFormat() {
        // check if no one is logged in
        String text = "Sign in.";
        Assertions.assertThat(text).as("No one is logged in.").contains(driver.findElement(By.cssSelector
                ("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        // Open the contact page
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        ContactUsPage contactUsPageFail = new ContactUsPage(driver);
        contactUsPageFail.fillInContactForm("Customer service", "nope", "4321234", "Help!");

        String textError = "Invalid email address.";
        Assertions.assertThat(textError).as("No one is logged in.").contains(driver.findElement(By.cssSelector
                ("#center_column > div > ol > li")).getText());

        String alert = driver.findElement(By.className("alert")).getText();
        Assertions.assertThat(alert).as("Error message displayed").contains("Invalid email address.");

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys("nope@correct.com");
        driver.findElement(By.cssSelector("#submitMessage")).click();

        //ContactUsPage emailFormatCorrect = new ContactUsPage(driver);
        //emailFormatCorrect.fillInContactForm("Customer service", "nope@correct.com", "4321234", "Help!");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String submitText = "Your message has been successfully sent to our team.";
        Assertions.assertThat(submitText).as("Contact form is submitted").contains(driver.findElement(By.cssSelector("#center_column > p")).getText());

        //assertThat(driver.findElement(By.cssSelector("#center_column > p"))).isDisplayed();
    }


}
