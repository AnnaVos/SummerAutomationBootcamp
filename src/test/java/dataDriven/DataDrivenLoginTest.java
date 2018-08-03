package dataDriven;

import com.opencsv.CSVReader;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DataDrivenLoginTest extends TestShopScenarioDataDriven {

    String CSV_Data = "C:\\Users\\Gebruiker\\IdeaProjects\\bootcampmaven\\src\\test\\java\\dataDriven\\DataCommaSeparated.csv";


    @Test
    public void fillInLoginPage(String CSV_Data) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_Data));
        String [] csvCell;
        //while loop will be executed till the last line In CSV. subject, email, orderID, message
        while ((csvCell = reader.readNext()) != null) {
            String Subject = csvCell[0];
            String Email = csvCell[1];
            String OrderID = csvCell[2];
            String Message = csvCell[3];
            driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(Subject);
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
            driver.findElement(By.xpath("//*[@id=\"id_order\"]")).sendKeys(OrderID);
            driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(Message);
            driver.findElement(By.xpath("//*[@id=\"submitMessage\"]")).click();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInLoginPage(Subject, Email, OrderID, Message);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String infoAccount = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(infoAccount).as("Welcome message contains").contains("Welcome to your account.");


    }

    @DataProvider(name = "getData")
    public static Object[][] dataProviderForSecurityinference() {


    }
}
