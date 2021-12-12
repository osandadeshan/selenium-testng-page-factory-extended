package fragments;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:09 PM
 * Description     :
 **/

public class LoginFragment extends BasePage {

    public LoginFragment(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password) {
        pages().getLoginPage()
                .getLoginBlock()
                .setEmail(email)
                .setPassword(password)
                .clickOnSignInButton();
        return pages().getHomePage();
    }

    public LoginPage logout() {
        pages().getHomePage()
                .getNavigationBlock()
                .clickOnLogoutLink();
        return pages().getLoginPage();
    }
}
