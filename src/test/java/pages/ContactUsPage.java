package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

                private final WebDriver driver;

               /* private By subjectField = By.className("selector hover focus"))); */

                private By emailTextField = By.cssSelector("#email");

                private By orderIdTextField = By.cssSelector("input#id_order");

                private By messageTextField = By.cssSelector("textarea#message");

                private By sendButton = By.cssSelector("button#submitMessage");

                private By invalidEmailElement = By.cssSelector(".alert.alert-danger>ol>li");

                public ContactUsPage(WebDriver driver){
                    this.driver = driver;
                }

                public void fillInContactForm (String subject, String email, String orderID, String message){

                    Select dropdown = new Select (driver.findElement(By.cssSelector("#id_contact")));
                    dropdown.selectByVisibleText(subject);
                    driver.findElement(emailTextField).sendKeys(email);
                    driver.findElement(orderIdTextField).sendKeys(orderID);
                    driver.findElement(messageTextField).sendKeys(message);
                    driver.findElement(sendButton).click();

    }


}
