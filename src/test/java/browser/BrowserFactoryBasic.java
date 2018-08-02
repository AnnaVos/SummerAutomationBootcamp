package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactoryBasic {

    public static WebDriver getDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox":
                return createFirefoxBrowser();
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                return createChromeBrowser();
            case "edge":
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            default:
                return createChromeBrowser();
        }
        return driver;
    }

    private static WebDriver createChromeBrowser() {
        // Chrome options are chrome specific, find them on https://peter.sh/experiments/chromium-command-line-switches/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        options.setCapability("chrome switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxBrowser () {
            // Firefox options are firefox specific, find them on https://peter.sh/experiments/chromium-command-line-switches/
            FirefoxOptions optionss = new FirefoxOptions();
            optionss.addArguments("start-maximized");
            optionss.addArguments("ignore-certificate-errors");
            optionss.addArguments("disable-infobars");
            optionss.setCapability("chrome switches", "--verbose");
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver(optionss);
        }
    }
