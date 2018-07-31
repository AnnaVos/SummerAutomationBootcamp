package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdjustPersonalInfoTest {
    @Test
    public void AdjustPersonalInfo() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        // log in:
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna.tester@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Welkom123!");
        driver.findElement(By.id("SubmitLogin")).click();

        // go to my personal info:
        driver.findElement(By.cssSelector(".icon-user")).click();

        // check and update name:
        WebElement getName = driver.findElement(By.cssSelector("#firstname"));
        {
System.out.println("Name is " + getName.getAttribute("value"));

            if (getName.getAttribute("value").equals("Anna")) {
                driver.findElement(By.cssSelector("#firstname")).clear();
                driver.findElement(By.cssSelector("#firstname")).sendKeys("Marietje");
            }
            else if (getName.getAttribute("value").equals("Marietje")) {
                driver.findElement(By.cssSelector("#firstname")).clear();
                driver.findElement(By.cssSelector("#firstname")).sendKeys("Anna");
            }
            else {
                driver.findElement(By.cssSelector("#firstname")).clear();
                driver.findElement(By.cssSelector("#firstname")).sendKeys("Anna");
            }


        }

        // fill password and click Save:
        driver.findElement(By.cssSelector("#old_passwd")).sendKeys("Welkom123!");
        driver.findElement(By.cssSelector("#center_column > div > form > fieldset > div:nth-child(11) > button")).click();

        // check if message "Your personal information has been successfully updated" is displayed:
        Assert.assertTrue(driver.findElement(By.cssSelector("#center_column > div > p")).isDisplayed());

        driver.quit();

    }
}
