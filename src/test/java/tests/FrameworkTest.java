package tests;

import org.testng.annotations.Test;

public class FrameworkTest extends BaseTest {

    @Test
    public void testBrowserLaunch() {
        // This test will simply launch the browser and navigate to Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        // Verify that the page title matches "Google"
        assert actualTitle.equals(expectedTitle) : "Page title is incorrect. Expected: " + expectedTitle + ", but got: " + actualTitle;

        // Print confirmation to the console
        System.out.println("Test Passed! Browser launched and navigated to Google.");
    }
}
