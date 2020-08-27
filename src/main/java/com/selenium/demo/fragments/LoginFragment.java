package com.selenium.demo.fragments;

import base.Base;
import com.selenium.demo.page.HomePage;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:09 PM
 * Description     :
 **/

public class LoginFragment extends Base {

    private final HomePage homePage;

    public LoginFragment() {
        homePage = pages().geHomePage();
    }

    public HomePage login(String email, String password) {
        pages().getLoginPage()
                .setEmail(email)
                .setPassword(password)
                .clickOnSignInButton();
        return homePage;
    }

}
