package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    private WebDriver driver;

    private By searchBox = By.name("q");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    public void pressEnter() {
        driver.findElement(searchBox).submit();
    }
}
