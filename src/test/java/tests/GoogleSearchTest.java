package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultsPage;
import resources.BrowserType;

public class GoogleSearchTest extends BaseTest{
    private final String origin = "Cairo";
    private final String destination = "Marsa Alam";
    private final String query = "flights from " + origin + " to " + destination;
    /*@DataProvider(name = "browsers")
    public Object[][] browsers() {
        return new Object[][] {
                //{ BrowserType.FIREFOX },
                { BrowserType.CHROME },
                { BrowserType.EDGE }
        };
    }*/
    @Test
    public void verifyFlightSearchResults() {

        googleSearchPage.enterSearchQuery(query);
        ResultsPage resultsPage = googleSearchPage.pressEnter();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Cairo to Marsa Alam"), "Expected search results were not displayed.");
        Assert.assertTrue(resultsPage.isFromFieldCorrect(origin), "'From' field does not match: " + origin);
        Assert.assertTrue(resultsPage.isToFieldCorrect(destination), "'To' field does not match: " + destination);
    }
}
