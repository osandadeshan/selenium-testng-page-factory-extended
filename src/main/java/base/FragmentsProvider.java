package base;

import fragments.LoginFragment;
import fragments.SearchFragment;
import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/19/2021
 * Time            : 8:50 AM
 * Description     :
 **/

public class FragmentsProvider {

    private final WebDriver driver;

    public FragmentsProvider(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFragment getLoginFragment() {
        return new LoginFragment(driver);
    }

    public SearchFragment getSearchFragment() {
        return new SearchFragment(driver);
    }
}
