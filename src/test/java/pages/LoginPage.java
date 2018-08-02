package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    private final WebDriver driver;

   private By login = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private By emailAddress = By.cssSelector("#email");

    private By passwordIs = By.cssSelector("#passwd");

    private By signInButton = By.cssSelector("#SubmitLogin > span");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillInLoginPage (String email, String password){

        driver.findElement(login).click();
        driver.findElement(emailAddress).sendKeys(email);
        driver.findElement(passwordIs).sendKeys(password);
        driver.findElement(signInButton).click();
}
}
