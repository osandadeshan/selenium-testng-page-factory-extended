package fragments;

import base.Base;
import extended_pages.ExtendedHomePage;
import extended_pages.ExtendedLoginPage;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:09 PM
 * Description     :
 **/

public class LoginFragment extends Base {

    private final ExtendedLoginPage loginPage;
    private final ExtendedHomePage homePage;

    public LoginFragment() {
        loginPage = pages().getLoginPage();
        homePage = pages().geHomePage();
    }

    public ExtendedHomePage login(String email, String password) {
        pages().getLoginPage()
                .setEmail(email)
                .setPassword(password)
                .clickOnSignInButton();
        return homePage;
    }

    public ExtendedLoginPage logout() {
        homePage.ClickOnLogoutLink();
        return loginPage;
    }

}
