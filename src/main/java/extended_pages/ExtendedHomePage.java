package extended_pages;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static base.Enums.PageTitle.MY_STORE_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 9/15/2020
 * Time            : 10:42 PM
 * Description     :
 **/

public class ExtendedHomePage extends HomePage {

    public ExtendedHomePage(WebDriver driver) {
        super(driver);
    }

    public ExtendedHomePage checkHomePageTitle() {
        assertEquals(driver.getTitle(), MY_STORE_PAGE_TITLE.asString());
        return this;
    }

    public ExtendedHomePage checkLoggedInUsername(String username) {
        assertEquals(getLoggedInUsername(), username);
        return this;
    }

}
