package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.blocks.NavigationBlock;

import static base.PageTitle.MY_STORE_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 11:56 AM
 * Description     :
 **/

public class HomePage extends BasePage {

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement TXT_SEARCH;

    @FindBy(how = How.CSS, using = "button[name='submit_search']")
    private WebElement BTN_SEARCH;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NavigationBlock getNavigationBlock() {
        return PageFactory.initElements(driver, NavigationBlock.class);
    }

    public HomePage checkHomePageTitle() {
        assertEquals(driver.getTitle(), MY_STORE_PAGE_TITLE.getTitle());
        return this;
    }

    public HomePage inputSearchItemName(String itemName) {
        sendKeys(TXT_SEARCH, itemName);
        return this;
    }

    public HomePage clickOnSearchButton() {
        click(BTN_SEARCH);
        return this;
    }
}
