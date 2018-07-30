package homeWorkAddition;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestDeleteWishListFaster extends loginUser {

    @Test
    public void DeleteNoPainNoGainFromListTwo() {

        // create a wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Open the wish list page
        driver.findElement(By.cssSelector("#wishlist_block > div > div.lnk > a")).click();

        // Wait until table is visible
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"block-history\"]/table"))));

        boolean itemDeleted = false;

        // if column 2 contains text "No Pain No Gain", navigate to delete button
        driver.findElement(By.xpath("//a[contains(text(), \"No Pain No Gain\")]//parent::td//following-sibling::td//" +
                "following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td//" +
                "following-sibling::td//a//i[@class='icon-remove']")).click();

        // accept alert message
        Alert alert = driver.switchTo().alert();
        alert.accept();

        itemDeleted = true;

        System.out.println("Item deleted.");



        Assertions.assertThat(itemDeleted).as("item not deleted.").isTrue();


        // add item to wish list
        driver.findElement(By.cssSelector("#name")).sendKeys("No Pain No Gain");
        driver.findElement(By.cssSelector("#submitWishlist")).click();


    }
}
