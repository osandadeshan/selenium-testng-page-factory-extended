package regression.login;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.annotations.Test;
import regression.BaseTest;

import static regression.Features.SIGN_IN;
import static test_data.LoginTestData.*;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 12:02 PM
 * Description     :
 **/

public class LoginTest extends BaseTest {

    @Category(SIGN_IN)
    @Test(description = "Verify that a valid user can login to the application")
    public void testValidUserLogin() {
        fragments().getLoginFragment()
                .login(USER_EMAIL, USER_PASSWORD)
                .checkHomePageTitle()
                .getNavigationBlock()
                .checkLoggedInUsername(FULL_USER_NAME);
    }

    @Category(SIGN_IN)
    @Test(description = "Verify that an invalid user cannot login to the application")
    public void testInvalidUserLogin() {
        fragments().getLoginFragment()
                .login(USER_EMAIL, "123456");
        pages().getLoginPage()
                .checkLoginPageTitle();
    }
}
