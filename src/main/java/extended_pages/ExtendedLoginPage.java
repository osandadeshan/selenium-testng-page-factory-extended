package extended_pages;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static base.Enums.PageTitle.LOGIN_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 9/15/2020
 * Time            : 11:44 PM
 * Description     :
 **/

public class ExtendedLoginPage extends LoginPage {

    public ExtendedLoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage checkLoginPageTitle() {
        assertEquals(driver.getTitle(), LOGIN_PAGE_TITLE.asString());
        return this;
    }

}
