package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmptyCartTest extends TestShopScenario {

    @Test
    public void EmptyCart() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // add item to cart:
        driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
        driver.findElement(By.cssSelector("#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.left-block > div > a > img")).click();
        driver.findElement(By.cssSelector("#add_to_cart")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > span > span.ajax_cart_product_txt"))));

        //Proceed to checkout (cart)
        driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")).click();
        //empty cart by quantity down by one
        driver.findElement(By.cssSelector("#cart_quantity_down_2_2_0_0")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class=\'alert alert-warning\']"))));

        if (driver.findElement(By.cssSelector("[class=\'alert alert-warning\']")).isDisplayed()) {
            System.out.println("Your shopping cart is empty");
        } else {
            System.out.println("Your shopping cart is NOT empty");
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'alert alert-warning\']")).isDisplayed());




    }
}
