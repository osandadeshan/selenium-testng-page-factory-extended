package test.login;

import base.Base;
import extended_pages.ExtendedLoginPage;
import fragments.LoginFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    private ExtendedLoginPage loginPage;

    @BeforeMethod
    public void before() {
        loginFragment = new LoginFragment();
        loginPage = pages().getLoginPage();
    }

    @Test
    public void verifyValidUserLogin() {
        loginFragment
                .login("osanda@mailinator.com", "1qaz2wsx@")
                .checkHomePageTitle()
                .checkLoggedInUsername("Osanda Nimalarathna");
        loginFragment
                .logout();
    }

    @Test
    public void verifyInvalidUserLogin() {
        loginPage
                .setEmail("osanda@mailinator.com")
                .setPassword("1qaz2wsx")
                .clickOnSignInButton();
        loginPage
                .checkLoginPageTitle();
    }

}
