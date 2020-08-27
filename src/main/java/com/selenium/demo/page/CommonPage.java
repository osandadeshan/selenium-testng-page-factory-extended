package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/3/2019
 * Time            : 8:11 PM
 * Description     :
 **/

public class CommonPage {

    private final WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowserTabTitle() {
        return driver.getTitle();
    }

}
