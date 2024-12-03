package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFinder {
    private WebDriver driver;

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    // Generic method to find element
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Send text to an element
    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // Click on an element
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Submit a form
    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    // Retrieve the text of an element
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Switch to the last window
    public void switchToLastWindow() {
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().size() - 1].toString());
    }
}