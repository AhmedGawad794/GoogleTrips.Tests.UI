package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultsPage;
import resources.BrowserType;

public class GoogleSearchTest extends BaseTest{
    //String query = "flights from Cairo to Marsa Alam";
    String origin = "Cairo";
    String destination = "Marsa Alam";
    String query = "flights from " + origin + " to " + destination;
    @DataProvider(name = "browsers")
    public Object[][] browsers() {
        return new Object[][] {
                //{ BrowserType.FIREFOX },
                { BrowserType.CHROME },
                { BrowserType.EDGE }
        };
    }
    @Test(dataProvider = "browsers")
    public void verifyFlightSearchResults(BrowserType browserType) {
        setUp(browserType);

        googleSearchPage.enterSearchQuery(query);
        ResultsPage resultsPage = googleSearchPage.pressEnter();
        //Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Cairo to Marsa Alam"), "Expected search results were not displayed.");
        Assert.assertTrue(resultsPage.isFromFieldCorrect(origin), "'From' field does not match: " + origin);
        Assert.assertTrue(resultsPage.isToFieldCorrect(destination), "'To' field does not match: " + destination);
    }
}
