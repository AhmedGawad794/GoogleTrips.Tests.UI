package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.ElementFinder;

public class ResultsPage {
    private WebDriver driver;
    private ElementFinder elementFinder;
    private By flightPricesLabel = By.xpath("//span[contains(text(), 'Flight prices')]");
    private By fromField = By.xpath("//input[@placeholder='Enter an origin' and contains(@value, 'Cairo')]");
    private By toField = By.xpath("//input[@placeholder='Enter a destination' and contains(@value, 'Marsa Alam')]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.elementFinder = new ElementFinder(driver);
    }
    public boolean isFromFieldCorrect(String origin) {
        String actualValue = elementFinder.findElement(fromField).getAttribute("value");
        return actualValue.contains(origin);
    }

    public boolean isToFieldCorrect(String destination) {
        String actualValue = elementFinder.findElement(toField).getAttribute("value");
        return actualValue.contains(destination);
    }
}
