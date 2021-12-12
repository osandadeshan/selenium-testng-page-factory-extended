package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.blocks.LoginBlock;

import static base.PageTitle.LOGIN_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 12:01 PM
 * Description     :
 **/

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginBlock getLoginBlock() {
        return PageFactory.initElements(driver, LoginBlock.class);
    }

    public LoginPage checkLoginPageTitle() {
        assertEquals(driver.getTitle(), LOGIN_PAGE_TITLE.getTitle());
        return this;
    }
}
