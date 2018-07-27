package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

        private final WebDriver driver;

       /*  WebElement dropDownListBox = driver.findElement(By.id("#id_contact"));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Customer service");

    Select droplist = new Select(driver.findElement(By.cssSelector("#id_contact")));
    droplist.selectByVisibleText("Customer service"); */

        private By subjectField = By.cssSelector("#id_contact");

        private By emailTextField = By.cssSelector("#email");

        private By orderIdTextField = By.cssSelector("input#id_order");

        private By messageTextField = By.cssSelector("textarea#message");

        private By sendButton = By.cssSelector("button#submitMessage");

        private By invalidEmailElement = By.cssSelector(".alert.alert-danger>ol>li");

        public ContactUsPage(WebDriver driver){
            this.driver = driver;
        }

        public void fillInContactForm (String subject, String email, String orderID, String message){
            driver.findElement(subjectField).isSelected(subject);
            driver.findElement(emailTextField).sendKeys(email);
            driver.findElement(orderIdTextField).sendKeys(orderID);
            driver.findElement(messageTextField).sendKeys(message);
            driver.findElement(sendButton).click();
    }


}
