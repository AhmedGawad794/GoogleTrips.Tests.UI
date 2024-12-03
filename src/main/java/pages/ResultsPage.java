package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.ElementFinder;
import java.util.List;

public class ResultsPage {
    private WebDriver driver;
    private ElementFinder elementFinder;

    // flight locators
    private By flightPricesLabel = By.xpath("//span[contains(text(), 'Flight prices')]");
    private By fromField = By.xpath("//input[@placeholder='Enter an origin' and contains(@value, 'Cairo')]");
    private By toField = By.xpath("//input[@placeholder='Enter a destination' and contains(@value, 'Marsa Alam')]");

    // weather locators
    private By cityName = By.xpath("//div[@id='oFNiHe']//span[@class='BBwThe']");
    private By temperatureDegree = By.cssSelector("#wob_tm");
    private By precipitation = By.cssSelector("#wob_pp");
    private By humidity = By.cssSelector("#wob_hm");
    private By windSpeed = By.cssSelector("#wob_ws");
    private By dateTime = By.cssSelector("#wob_dts");

    // restaurant locators
    private By placesSection = By.xpath("//div[@data-hveid='CBoQAA']");
    private By restaurantsList = By.className("xxAJT");
    private By eachRestaurant = By.className("w7Dbne");
    private By morePlacesButton = By.xpath("//span[contains(text(), 'More places')]");

    // restaurant more places page locators
    private By ratingDropDown = By.xpath("//span[contains(text(),'Rating')]");
    private By firstRatingOption = By.xpath("//span[contains(text(), 'and up')]");
    private By restaurantsListSection = By.id("center_col");
    private By restaurantTitles = By.xpath("//a[contains(@class,'link a-no-hover-decoration')]//*[@role='heading']//span[@dir='rtl']");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.elementFinder = new ElementFinder(driver);
    }

    // flight methods
    public boolean isFromFieldCorrect(String origin) {
        String actualValue = elementFinder.findElement(fromField).getAttribute("value");
        return actualValue.contains(origin);
    }

    public boolean isToFieldCorrect(String destination) {
        String actualValue = elementFinder.findElement(toField).getAttribute("value");
        return actualValue.contains(destination);
    }
    // weather methods
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
    // Method to check if the Places section is displayed
    public boolean isPlacesSectionDisplayed() {
        return elementFinder.findElement(placesSection).isDisplayed();
    }

    // Method to retrieve the list of restaurants on the main page
    public List<WebElement> getRestaurantsList() {
        return elementFinder.findElements(restaurantsList);
    }

    // Click on "More Places" button
    public void clickMorePlaces() {
        elementFinder.click(morePlacesButton);
    }

    // Wait until the restaurants list section is updated on the new page
    public void waitForRestaurantsListUpdate() {
        elementFinder.waitUntilVisible(restaurantsListSection);
    }

    // Select the first rating option from the dropdown
    public void filterByRating() {
        elementFinder.click(ratingDropDown);
        elementFinder.click(firstRatingOption);
    }

    // Retrieve the titles of all restaurants in the list
    public List<String> getRestaurantTitles() {
        elementFinder.waitUntilVisible(restaurantsListSection);
        return elementFinder.getTexts(restaurantTitles);
    }

}
