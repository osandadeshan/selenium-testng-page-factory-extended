package com.selenium.demo.page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static base.Enums.PageTitle.MY_STORE_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 11:56 AM
 * Description     :
 **/

public class HomePage extends Base {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='account']/span")
    private WebElement profileNameLabel;
    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage checkHomePageTitle() {
        assertEquals(driver.getTitle(), MY_STORE_PAGE_TITLE.asString());
        return this;
    }

    public HomePage checkLoggedInUsername(String username) {
        assertEquals(getLoggedInUsername(), username);
        return this;
    }

    public void logout() {
        logoutLink.click();
    }

    private String getLoggedInUsername() {
        return profileNameLabel.getText();
    }

}
