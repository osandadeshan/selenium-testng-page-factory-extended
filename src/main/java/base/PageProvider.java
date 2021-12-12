package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/26/2020
 * Time            : 8:50 AM
 * Description     :
 **/

public class PageProvider {

    private final WebDriver driver;

    public PageProvider(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public HomePage getHomePage() {
        return PageFactory.initElements(driver, HomePage.class);
    }

    public SearchResultsPage getSearchResultsPage() {
        return PageFactory.initElements(driver, SearchResultsPage.class);
    }
}