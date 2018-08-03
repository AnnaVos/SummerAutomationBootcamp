package dataDriven;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDrivenLoginTestTwo extends TestShopScenarioDataDriven {

    @DataProvider(name = "Authentication")
    public Iterator<Object[]> provider() throws InterruptedException, IOException {
        List<Object[]> testCases = new ArrayList<>();
        String[] data = null;
        String line;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Gebruiker\\IdeaProjects\\" +
                    "bootcampmaven\\src\\test\\java\\dataDriven\\DataCommaSeparated.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while ((line = br.readLine()) != null) {
            data = line.split(",");
            testCases.add(data);
        }

        return testCases.iterator();
    }

    @Test(dataProvider = "Authentication")
    public void fillInForm(String subject, String email, String orderID, String message) {
        // Open the contact page
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        String text = "Sign in.";
        Assertions.assertThat(text).as("No one is logged in.").contains(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).getText());

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm(subject, email, orderID, message);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String texttext = "Your message has been successfully sent to our team.";
        Assertions.assertThat(texttext).as("Contact form is submitted").contains(driver.findElement(By.cssSelector("#center_column > p")).getText());
    }
}

