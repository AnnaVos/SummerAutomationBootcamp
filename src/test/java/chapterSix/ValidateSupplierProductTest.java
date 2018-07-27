package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidateSupplierProductTest {

    @Test
    public void ValidateSupplierProductTest() {


        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        // suppliers: change select box to "AppleStore"
        driver.findElement(By.cssSelector("#suppliers_block_left > div > ul > li.first_item > a")).click();

        /* Select dropdown = new Select(driver.findElement(By.cssSelector("#search_query_top")));
        dropdown.selectByVisibleText("MacBook Air"); */

        List<WebElement> appleProducts = driver.findElements(By.cssSelector("#center_column"));
        List<String> productStringList = new ArrayList<String>();

    for (int i = 0 ; i<productStringList.lenght; i++)
        boolean productFound = false;
        for (WebElement e : appleProducts) {
            if (e.getAttribute("title").equals("MacBook Air")) {
                System.out.println("MacBook Air is found in List");
                productFound = true;
            } else {
                System.out.println("No MacBook Air found in List");
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.last-line.last-item-of-tablet-line.last-item-of-mobile-line.last-mobile-line > div > div.right-block > h5 > a")).isDisplayed());
        Assertions.assertThat(productFound).as("Product not found").isTrue();
        driver.quit();
    }
}



