package regression;

import base.BaseUiComponent;
import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.DriverFactory;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static test_data.EnvironmentTestData.APPLICATION_URL;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/19/2021
 * Time            : 8:45 AM
 * Description     :
 **/

@Listeners(TestAnalyzeReportListener.class)
public class BaseTest extends BaseUiComponent {

    protected WebDriver driver;

    @BeforeMethod
    public void spinUpDriver() {
        DriverHolder.setDriver(DriverFactory.getNewDriverInstance(System.getProperty("browser.type")));
        BaseUiComponent.setDriver(driver);
        driver = getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(APPLICATION_URL);
    }

    @AfterMethod
    public void killDriver() {
        driver.quit();
    }
}
