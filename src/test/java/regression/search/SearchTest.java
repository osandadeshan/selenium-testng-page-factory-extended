package regression.search;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regression.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static regression.Features.SEARCH;
import static test_data.LoginTestData.USER_EMAIL;
import static test_data.LoginTestData.USER_PASSWORD;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 12/12/2021
 * Time            : 1:18 PM
 * Description     :
 **/

public class SearchTest extends BaseTest {

    @BeforeMethod
    public void searchBeforeMethod() {
        fragments().getLoginFragment()
                .login(USER_EMAIL, USER_PASSWORD);
        fragments().getSearchFragment()
                .searchItem("T-shirt");
    }

    @Category(SEARCH)
    @Test(description = "Verify that there is only 1 search result for the keyword 'T-shirt'")
    public void testSearchResultCount() {
        assertEquals(
                pages().getSearchResultsPage()
                        .getSearchResultsCount(),
                1
        );
    }

    @Category(SEARCH)
    @Test(description = "Verify the search result name and price for the keyword 'T-shirt'")
    public void testSearchResult() {
        assertTrue(
                pages().getSearchResultsPage()
                        .getSearchResultBlock()
                        .getSearchResultItemName()
                        .contains("Faded Short Sleeve T-shirts")
        );

        assertEquals(
                pages().getSearchResultsPage()
                        .getSearchResultBlock()
                        .getSearchResultItemPrice(),
                "$16.51"
        );
    }
}
