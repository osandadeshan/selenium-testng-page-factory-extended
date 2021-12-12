package pages.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 12/12/2021
 * Time            : 1:21 PM
 * Description     :
 **/

public class NavigationBlock extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@class='account']/span")
    private WebElement LBL_PROFILE_NAME;

    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement LINK_LOGOUT;

    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogoutLink() {
        LINK_LOGOUT.click();
    }

    public NavigationBlock checkLoggedInUsername(String username) {
        assertEquals(LBL_PROFILE_NAME.getText(), username);
        return this;
    }
}
