package homeWork;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DeleteWishListTest {



    @Test
    public void DeleteNoPainNoGainFromList() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        // create a wait:
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // go to test shop:
        driver.get("https:techblog.polteq.com/testshop");

        // log in:
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("anna@vos.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        // Open the wish list page
        driver.findElement(By.cssSelector("#wishlist_block > div > div.lnk > a")).click();

        // Wait until table is visible
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"block-history\"]/table"))));

        //To locate table
        WebElement myTable = driver.findElement(By.xpath("//*[@id=\"block-history\"]/table"));
        //To locate rows of table
        List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));
        //To calculate number of rows in table
        int rows_count = rows_table.size();

             //Loop will execute until the last row of the table
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns(cells) In that specific row
            int columns_count = Columns_row.size();
            //System.out.println("This is Row " + row + " and has " + columns_count + " colums.");

            //Loop will execute till the last cell of that specific row
            for (int column = 0; column < columns_count; column++) {
                //To retrieve text from cells
                String celText = Columns_row.get(column).getText();
                // System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + celtext);

                if (celText.equals("No Pain No Gain")) {

                    //delete from wish list
                    driver.findElement(By.xpath("//*[@id=\"wishlist_1128\"]/td[7]/a/i")).click();
                    //switch to pup up browser
                    Set<String> set1=driver.getWindowHandles();
                    Iterator<String> win1=set1.iterator();
                    String parent=win1.next();
                    String child=win1.next();
                    driver.switchTo().window(child);

                    // click OK
                    Alert alert = driver.switchTo().alert();
                    alert.accept();

                    //switch back to parent browser
                    //driver.switchTo().window(parent);

                    System.out.println("Deleted item 'No Pain No Gain!");
                }
                else {
                    System.out.println("Did NOT delete item 'No Pain No Gain.");
                }

            }
            System.out.println("-----------------------------------------------------------------------");

                 }

        }

        }

