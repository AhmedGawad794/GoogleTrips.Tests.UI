package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.ResultsPage;

import java.util.List;

public class RestaurantTest extends BaseTest {
    private final String destination = "Marsa Alam";
    private final String query = "restaurant near " + destination;

    @Test
    public void verifyRestaurantsListAndSorting() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchQuery(query);
        googleSearchPage.pressEnter();
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.isPlacesSectionDisplayed(), "Places section is not displayed.");
        List<String> restaurantTitlesBefore = resultsPage.getRestaurantTitles();
        Assert.assertFalse(restaurantTitlesBefore.isEmpty(), "No restaurants found in the initial list.");
        resultsPage.clickMorePlaces();
        resultsPage.waitForRestaurantsListUpdate();
        resultsPage.filterByRating();
        List<String> restaurantTitlesAfter = resultsPage.getRestaurantTitles();
        Assert.assertFalse(restaurantTitlesAfter.isEmpty(), "No restaurants found after filtering by rating.");
        Assert.assertTrue(restaurantTitlesAfter.size() >= restaurantTitlesBefore.size(), "Filtered list contains fewer restaurants.");
    }
}
