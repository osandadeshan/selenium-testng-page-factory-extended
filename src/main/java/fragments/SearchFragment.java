package fragments;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.SearchResultsPage;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:09 PM
 * Description     :
 **/

public class SearchFragment extends BasePage {

    public SearchFragment(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchItem(String itemName) {
        pages().getHomePage()
                .inputSearchItemName(itemName)
                .clickOnSearchButton();
        return pages().getSearchResultsPage();
    }
}
