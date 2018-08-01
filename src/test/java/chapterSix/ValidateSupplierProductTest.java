package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:techblog.polteq.com/testshop");

        // suppliers: change select box to "AppleStore"
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='supplier_list']")));
        dropdown.selectByVisibleText("AppleStore");

        List<WebElement> supplierProducts = driver.findElements(By.cssSelector("h5[itemprop='name']>a"));

        boolean macBookFound = false;
        for (int i = 0 ; i<supplierProducts.size(); i++) {
            if (supplierProducts.get(i).getText().equals("MacBook Air")) {
                System.out.println("MacBook Air is found in List");
                macBookFound = true;
            } else {
                System.out.println("No MacBook Air found in List");
            }
        }
        Assertions.assertThat(macBookFound).as ("Check if MacBook Air is in the list").isTrue();

        driver.quit();
    }
}



