package regression.login;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regression.BaseTest;

import static regression.Features.SIGN_OUT;
import static test_data.LoginTestData.USER_EMAIL;
import static test_data.LoginTestData.USER_PASSWORD;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 12:02 PM
 * Description     :
 **/

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void searchBeforeMethod() {
        fragments().getLoginFragment()
                .login(USER_EMAIL, USER_PASSWORD);
    }

    @Category(SIGN_OUT)
    @Test(description = "Verify that a logged in user can logout from the application")
    public void testValidUserLogin() {
        fragments().getLoginFragment()
                .logout();
    }
}
