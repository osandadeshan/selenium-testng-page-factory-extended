package pages.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.BasePage;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 12/12/2021
 * Time            : 1:30 PM
 * Description     :
 **/

public class SearchResultBlock extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='right-block']//h5//a")
    private WebElement LBL_SEARCH_RESULT_NAME;

    @FindBy(how = How.XPATH, using = "//div[@class='right-block']//span[@itemprop='price']")
    private WebElement LBL_SEARCH_RESULT_PRICE;

    public SearchResultBlock(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultItemName() {
        return getElement(LBL_SEARCH_RESULT_NAME).getText();
    }

    public String getSearchResultItemPrice() {
        return getElement(LBL_SEARCH_RESULT_PRICE).getText();
    }
}
