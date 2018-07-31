package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmptyCartTestTwo extends TestShopScenario {

    @Test
    public void EmptyCart() throws InterruptedException {
        // create a wait:
        WebDriverWait myWaitVar = new WebDriverWait(driver, 10);

        // check if cart is empty:
        if (driver.findElement(By.cssSelector("[class=\'ajax_cart_no_product\']")).isDisplayed()) {
            System.out.println("Your shopping cart is empty");
        } else {
            System.out.println("Your shopping cart is NOT empty");
        }

        // add item to cart:
        driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
        driver.findElement(By.cssSelector("#product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-" +
                "line.last-item-of-tablet-line.last-mobile-line > div > div.left-block > div > a > img")).click();
        driver.findElement(By.cssSelector("#add_to_cart")).click();

        // continue shopping
        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']"))).click();

        // check if cart number is 1
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_quantity")).getText()).as(
                "Check if number is 1").isEqualTo("1");

        // click the cart button
        // overlay is blocking the cart button (!!! .click(); is missing !!!)
        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart>a"))).click();


        // overlay menu needs time to appear
        Thread.sleep(1000);
        driver.findElement(By.className("icon-trash")).click();

        // after clicking the trash icon the site needs time to delete the webtable and show the empty cart message
        String emptyCartMessage = myWaitVar.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".alert.alert-warning"))).getText();

        Assertions.assertThat(emptyCartMessage).as("Validate if the empty cart message appears").isEqualTo
                ("Your shopping cart is empty.");

        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).as
                ("Check if empty element is visible").isTrue();
    }
}


