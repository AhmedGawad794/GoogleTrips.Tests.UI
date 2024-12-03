package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.GoogleSearchPage;
import resources.Urls;

public class BaseTest {
    protected WebDriver driver;
    protected GoogleSearchPage googleSearchPage;
    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        String driverPath = System.getProperty("user.dir") + Urls.DriversDirectory;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(Urls.GoogleHomePage);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.changeLanguageToEnglish();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
