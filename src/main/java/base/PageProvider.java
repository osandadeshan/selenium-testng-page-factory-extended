package base;

import extended_pages.ExtendedHomePage;
import extended_pages.ExtendedLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name    : selenium-testng-page-factory-demo
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

    public ExtendedLoginPage getLoginPage() {
        return PageFactory.initElements(driver, ExtendedLoginPage.class);
    }

    public ExtendedHomePage geHomePage() {
        return PageFactory.initElements(driver, ExtendedHomePage.class);
    }

}