package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FillCartTest {

    @Test
    public void CartIsEmpty() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        if (driver.findElement(By.cssSelector("#header > div:nth-child(2) > div > div > div:nth-child(4) > div > a > span.ajax_cart_no_product")).isDisplayed()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Cart is not empty");
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div:nth-child(2) > div > div > div:nth-child(4) > div > a > span.ajax_cart_no_product")).isDisplayed());
        driver.quit();
    }

    @Test
    public void AddToCart() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
        driver.findElement(By.cssSelector("#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.left-block > div > a > img")).click();
        driver.findElement(By.cssSelector("#add_to_cart")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > span > span.ajax_cart_product_txt"))));

        if (driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > span > span.ajax_cart_product_txt")).isDisplayed()) {
            System.out.println("There is 1 item in shopping cart");
        } else {
            System.out.println("There is not 1 item in shopping cart");
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > span > span.ajax_cart_product_txt")).isDisplayed());
        driver.quit();

            }
}

