package regression;

import base.BaseUiComponent;
import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.DriverFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static org.openqa.selenium.remote.BrowserType.CHROME;
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
        spinUpDriverAndNavigateToUrl(System.getProperty("browser.type"), APPLICATION_URL);
        BaseUiComponent.setDriver(driver);
    }

    @AfterMethod
    public void killDriver() {
        driver.quit();
    }

    @AfterSuite
    public void openExecutionReport() {
        try {
            Optional<Path> lastFilePath = Files.list(Paths.get("./reports/html-reports"))
                    .filter(f -> !Files.isDirectory(f))
                    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));
            lastFilePath.ifPresent(path -> spinUpDriverAndNavigateToUrl(CHROME, path.toAbsolutePath().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void spinUpDriverAndNavigateToUrl(String browserName, String url) {
        DriverHolder.setDriver(DriverFactory.getNewDriverInstance(browserName));
        driver = getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
}
