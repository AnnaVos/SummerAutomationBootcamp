package dataDriven;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.util.concurrent.TimeUnit;

    public class DataDrivenTest extends TestShopScenarioDataDriven {

        @Parameters({"subject", "email", "orderID", "message"})
        @Test
        public void fillInForm(String subject, String email, String orderID, String message) {

            //Homepage homepage = new HomePage (driver);
            //homepage.clickContactUS();

            // Open the contact page
            driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

            String text = "Sign in.";
            Assertions.assertThat(text).as("No one is logged in.").contains(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.fillInContactForm(subject, email, orderID, message);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           //if {
            //Assertions.assertThat(success).as("Contact form is submitted").contains(driver.findElement(By.cssSelector("#center_column > p")).getText());
        }

    }

