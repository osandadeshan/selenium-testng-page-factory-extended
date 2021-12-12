package pages;

import base.BaseUiComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/19/2021
 * Time            : 8:47 AM
 * Description     :
 **/

public class BasePage extends BaseUiComponent {

    public final WebDriver driver;
    public final int DEFAULT_TIMEOUT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void click(WebElement webElement) {
        waitUntilElementClickable(webElement);
        webElement.click();
    }

    public WebElement getElement(WebElement webElement) {
        waitUntilElementVisible(webElement);
        return webElement;
    }

    public List<WebElement> getElements(List<WebElement> webElements) {
        for (WebElement element : webElements) {
            waitUntilElementVisible(element);
        }
        return webElements;
    }

    public void sendKeys(WebElement webElement, String text) {
        waitUntilElementVisible(webElement);
        webElement.sendKeys(text);
    }
}
