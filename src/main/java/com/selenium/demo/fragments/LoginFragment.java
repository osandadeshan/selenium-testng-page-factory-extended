package com.selenium.demo.fragments;

import base.Base;
import com.selenium.demo.page.CommonPage;
import com.selenium.demo.page.HomePage;
import com.selenium.demo.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static base.Enums.PageTitle.LOGIN_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:09 PM
 * Description     :
 **/

public class LoginFragment extends Base {

    private final LoginPage loginPage;
    private final HomePage homePage;
    private final CommonPage commonPage;

    public LoginFragment(WebDriver driver) {
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage login(String email, String password) {
        assertEquals(commonPage.getBrowserTabTitle(), LOGIN_PAGE_TITLE.asString());
        pages().getLoginPage()
                .setEmail(email)
                .setPassword(password)
                .clickOnSignInButton();
        return homePage;
    }

}
