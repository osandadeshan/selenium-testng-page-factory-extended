package com.selenium.demo.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 10:28 AM
 * Description     :
 **/

public class DriverFactory {

    private static final String BROWSER = System.getenv("browser");
    private static final String WINDOW_WIDTH = System.getenv("window_width");
    private static final String WINDOW_HEIGHT = System.getenv("window_height");
    private static final String HEADLESS = "--headless";
    private static final String CHROME = "chrome";
    private static final String HEADLESS_CHROME = "headless-chrome";
    private static final String FIREFOX = "firefox";
    private static final String HEADLESS_FIREFOX = "headless-firefox";
    private static final String IE = "ie";
    private static final String EDGE = "edge";
    private static final String SAFARI = "safari";
    private static final String WINDOW_SIZE = "--window-size=" + WINDOW_WIDTH + "x" + WINDOW_HEIGHT;

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required BROWSER can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html

    public static WebDriver getDriver() {
        if (BROWSER == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        switch (BROWSER.toLowerCase())
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case HEADLESS_CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(HEADLESS);
                chromeOptions.addArguments(WINDOW_SIZE);
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case HEADLESS_FIREFOX:
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions(HEADLESS);
                firefoxBinary.addCommandLineOptions(WINDOW_SIZE);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

}
