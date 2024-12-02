package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import resources.BrowserType;

public class GoogleSearchTest extends BaseTest{
    @DataProvider(name = "browsers")
    public Object[][] browsers() {
        return new Object[][] {
                { BrowserType.FIREFOX },
                { BrowserType.CHROME },
                { BrowserType.EDGE }
        };
    }
    @Test(dataProvider = "browsers")
    public void verifyFlightSearchResults(BrowserType browserType) {
        setUp(browserType);
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        String query = "flights from Cairo to Marsa Alam";
        googleSearchPage.enterSearchQuery(query);
        googleSearchPage.pressEnter();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Cairo to Marsa Alam"), "Expected search results were not displayed.");
    }
}
