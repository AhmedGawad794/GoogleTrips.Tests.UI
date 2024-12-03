package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.ElementFinder;

public class GoogleSearchPage {
    private WebDriver driver;
    private ElementFinder elementFinder;
    private By searchBox = By.name("q");
    private By englishButton = By.xpath("//div[@id='SIvCob']//a");
    private By searchButton = By.xpath("//input[@name='btnK']");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        elementFinder = new ElementFinder(driver);
    }
    public void changeLanguageToEnglish(){
        elementFinder.findElement(englishButton).click();
    }
    public void enterSearchQuery(String searchQuery) {
        elementFinder.sendKeys(searchBox, searchQuery);
    }

    public ResultsPage pressEnter() {
        elementFinder.findElement(searchButton).submit();
        return new ResultsPage(driver);
    }
}
