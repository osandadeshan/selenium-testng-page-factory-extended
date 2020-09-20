package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 11:56 AM
 * Description     :
 **/

public class HomePage extends Base {

    protected final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='account']/span")
    private WebElement profileNameLabel;
    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickOnLogoutLink() {
        logoutLink.click();
    }

    public String getLoggedInUsername() {
        return profileNameLabel.getText();
    }

}
