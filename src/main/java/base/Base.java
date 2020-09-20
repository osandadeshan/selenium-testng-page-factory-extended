package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.driver.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/3/2019
 * Time            : 6:14 PM
 * Description     :
 **/

public class Base {

    private static final String fileSeparator = File.separator;
    private static final String rootDirectory = System.getProperty("user.dir");
    private static WebDriver driver;
    private ExtentReports extent;

    private static String takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = rootDirectory + fileSeparator + "screenshots" + fileSeparator +
                screenshotName + " - " + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    @BeforeTest
    public void extentReportSetup() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(rootDirectory + fileSeparator + "reports" + fileSeparator +
                "html-report" + fileSeparator + "execution-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Test Execution Report - My Store");
        htmlReporter.config().setReportName("Test Execution Report - My Store");
        htmlReporter.config().setTheme(Theme.DARK);

        extent.setSystemInfo("Application Name", "My Store");
        extent.setSystemInfo("Test Developer", "Osanda Deshan");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Operating System", "Windows 10 - 64 Bit");
    }

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterMethod
    public void generateReportDataAndCloseAllDrivers(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
                test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.RED));
                try {
                    test.fail("Screenshot at the failed moment is below " +
                            test.addScreenCaptureFromPath(takeScreenshot(driver, result.getName())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ITestResult.SKIP:
                test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.GREY));
                break;
            case ITestResult.SUCCESS:
                test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
                break;
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    protected PageProvider pages() {
        return new PageProvider(driver);
    }

}
