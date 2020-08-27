package com.selenium.demo.test.login;

import base.Base;
import com.selenium.demo.fragments.CommonFragment;
import com.selenium.demo.fragments.LoginFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Enums.PageTitle.LOGIN_PAGE_TITLE;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 12:02 PM
 * Description     :
 **/

public class LoginTest extends Base {

    private LoginFragment loginFragment;
    private CommonFragment commonFragment;

    @BeforeMethod
    public void before() {
        loginFragment = new LoginFragment(driver);
        commonFragment = new CommonFragment(driver);
    }

    @Test
    public void verifyValidUserLogin() {
        loginFragment
                .login("osanda@mailinator.com", "1qaz2wsx@")
                .checkLoggedInUsername("Osanda Nimalarathna")
                .logout();
    }

    @Test
    public void verifyInvalidUserLogin() {
        loginFragment
                .login("osanda@mailinator.com", "1qaz2wsx");
        commonFragment
                .checkPageTitle(LOGIN_PAGE_TITLE.asString());
    }

}
