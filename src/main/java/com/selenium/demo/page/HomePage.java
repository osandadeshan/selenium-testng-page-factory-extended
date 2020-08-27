package com.selenium.demo.page;

import base.PageProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static base.Enums.PageTitle.LOGIN_PAGE_TITLE;
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

public class HomePage {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='account']/span")
    private WebElement profileNameLabel;
    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage checkPageTitle() {
        assertEquals(new CommonPage(driver).getBrowserTabTitle(), MY_STORE_PAGE_TITLE.asString());
        return this;
    }

    public HomePage checkLoggedInUsername(String username) {
        assertEquals(getLoggedInUsername(), username);
        return PageProvider.geHomePage();
    }

    public void logout() {
        logoutLink.click();
        assertEquals(new CommonPage(driver).getBrowserTabTitle(), LOGIN_PAGE_TITLE.asString());
    }

    private String getLoggedInUsername() {
        return profileNameLabel.getText();
    }

}
