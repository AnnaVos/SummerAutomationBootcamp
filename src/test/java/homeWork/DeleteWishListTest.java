package homeWork;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeleteWishListTest extends loginAsUserAnna {

    @Test
    public void DeleteNoPainNoGainFromListTwo() {

        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Open the wish list page
        driver.findElement(By.cssSelector("#wishlist_block > div > div.lnk > a")).click();

        // Wait until table is visible
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"block-history\"]/table"))));

        String beforeXpath = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[";
        String afterXpath = "]/td[1]";

        boolean itemDeleted = false;

        for (int i = 1; i < 6; i++) {
            String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println(name);
            if (name.contains("No Pain No Gain")) { // i=5

                // click delete button
                driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[" + i + "]/td[7]/a[1]/i[1]")).click();

                // accept alert message
                Alert alert = driver.switchTo().alert();
                alert.accept();

                itemDeleted = true;

                System.out.println("Item deleted.");
            } else {
                System.out.println("Item NOT deleted.");
            }
        }
        Assertions.assertThat(itemDeleted).as("item not deleted.").isTrue();

        driver.findElement(By.cssSelector("#name")).sendKeys("No Pain No Gain");
        driver.findElement(By.cssSelector("#submitWishlist")).click();
    }
}
