package base;

import util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/3/2019
 * Time            : 6:14 PM
 * Description     :
 **/

public class Base {

    protected static WebDriver driver;

    @BeforeMethod
    public static void initializeDriver() {
        driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterMethod
    public static void closeAllDrivers() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected PageProvider pages() {
        return new PageProvider(driver);
    }

}
