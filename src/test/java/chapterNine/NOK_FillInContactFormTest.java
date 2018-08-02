package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import static org.openqa.selenium.By.className;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void nokFillInLoginPage() {
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

    }
}
