package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFinder {
    private WebDriver driver;

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement byName(String name) {
        return driver.findElement(By.name(name));
    }

    public void sendByName(String name, String text) {
        driver.findElement(By.name(name)).sendKeys(text);
    }

    public void submitByName(String name) {
        driver.findElement(By.name(name)).submit();
    }

    public WebElement byId(String id) {
        return driver.findElement(By.id(id));
    }

    public void sendById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public WebElement byClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public void sendByClassName(String className, String text) {
        driver.findElement(By.className(className)).sendKeys(text);
    }

    public WebElement byXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public void sendByXPath(String xPath, String text) {
        driver.findElement(By.xpath(xPath)).sendKeys(text);
    }

    public void byXPathAndClick(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public WebElement byPartialLinkText(String partialLink) {
        return driver.findElement(By.partialLinkText(partialLink));
    }

    public void byPartialLinkAndClick(String partialLink) {
        driver.findElement(By.partialLinkText(partialLink)).click();
    }
}
