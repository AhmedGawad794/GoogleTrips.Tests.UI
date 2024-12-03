package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.ResultsPage;

public class WeatherTest extends BaseTest {
    private final String destination = "Marsa Alam";
    private final String query = "what is the weather in " + destination;

    @Test
    public void verifyWeatherDetails() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchQuery(query);
        googleSearchPage.pressEnter();

        ResultsPage resultsPage = new ResultsPage(driver);

        Assert.assertEquals(resultsPage.getCityName(), destination, "City name does not match.");
        Assert.assertFalse(resultsPage.getTemperatureDegree().isEmpty(), "Temperature is not displayed.");
        Assert.assertFalse(resultsPage.getPrecipitation().isEmpty(), "Precipitation is not displayed.");
        Assert.assertFalse(resultsPage.getHumidity().isEmpty(), "Humidity is not displayed.");
        Assert.assertFalse(resultsPage.getWindSpeed().isEmpty(), "Wind speed is not displayed.");
        Assert.assertFalse(resultsPage.getDateTime().isEmpty(), "Date and time are not displayed.");
    }
}
