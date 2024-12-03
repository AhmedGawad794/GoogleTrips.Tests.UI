package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
    private WebDriver driver;
    private By flightPricesLabel = By.xpath("//span[contains(text(), 'Flight prices')]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }
}
