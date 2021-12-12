package base;

import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 12/12/2021
 * Time            : 12:47 PM
 * Description     :
 **/

public class BaseUiComponent {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BaseUiComponent.driver = driver;
    }

    protected PageProvider pages() {
        return new PageProvider(driver);
    }

    protected FragmentsProvider fragments() {
        return new FragmentsProvider(driver);
    }
}
