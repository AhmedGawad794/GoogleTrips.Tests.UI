package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.GoogleSearchPage;
import resources.BrowserType;
import resources.Urls;

public class BaseTest {
    protected WebDriver driver;
    protected GoogleSearchPage googleSearchPage;
    //@BeforeMethod
    public void setUp(BrowserType browserType) {
        String driverPath = System.getProperty("user.dir") + Urls.DriversDirectory;
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
                /*WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(firefoxOptions);
                break;*/
            case EDGE:
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserType);
        }
        driver.manage().window().maximize();
        driver.get(Urls.GoogleHomePage);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.changeLanguageToEnglish();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
