package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.blocks.SearchResultBlock;

import java.util.List;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 12/12/2021
 * Time            : 1:29 PM
 * Description     :
 **/

public class SearchResultsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='left-block']//div[@class='product-image-container']")
    private List<WebElement> SEARCH_RESULTS_LIST;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultBlock getSearchResultBlock() {
        return PageFactory.initElements(driver, SearchResultBlock.class);
    }

    public int getSearchResultsCount() {
        return getElements(SEARCH_RESULTS_LIST).size();
    }
}
