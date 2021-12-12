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
 * Time            : 11:22 AM
 * Description     :
 **/

public class LoginBlock extends BasePage {

    @FindBy(how = How.ID, using = "email")
    private WebElement TXT_BOX_EMAIL;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement TXT_BOX_PASSWORD;

    @FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
    private WebElement BTN_SIGN_IN;

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    public LoginBlock setEmail(String email) {
        TXT_BOX_EMAIL.sendKeys(email);
        return this;
    }

    public LoginBlock setPassword(String password) {
        TXT_BOX_PASSWORD.sendKeys(password);
        return this;
    }

    public LoginBlock clickOnSignInButton() {
        BTN_SIGN_IN.click();
        return this;
    }
}
