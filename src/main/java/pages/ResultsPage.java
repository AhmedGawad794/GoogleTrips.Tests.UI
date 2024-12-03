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
    private By cityName = By.xpath("//div[@id='oFNiHe']//span[@class='BBwThe']");
    private By temperatureDegree = By.cssSelector("#wob_tm");
    private By precipitation = By.cssSelector("#wob_pp");
    private By humidity = By.cssSelector("#wob_hm");
    private By windSpeed = By.cssSelector("#wob_ws");
    private By dateTime = By.cssSelector("#wob_dts");

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

    public String getCityName() {
        return elementFinder.getText(cityName);
    }

    public String getTemperatureDegree() {
        return elementFinder.getText(temperatureDegree);
    }

    public String getPrecipitation() {
        return elementFinder.getText(precipitation);
    }

    public String getHumidity() {
        return elementFinder.getText(humidity);
    }

    public String getWindSpeed() {
        return elementFinder.getText(windSpeed);
    }

    public String getDateTime() {
        return elementFinder.getText(dateTime);
    }
}
