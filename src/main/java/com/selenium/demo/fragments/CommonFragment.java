package com.selenium.demo.fragments;

import com.selenium.demo.page.CommonPage;
import com.selenium.demo.page.HomePage;
import com.selenium.demo.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/26/2020
 * Time            : 8:23 AM
 * Description     :
 **/


public class CommonFragment {

    private final CommonPage commonPage;

    public CommonFragment(WebDriver driver) {
        commonPage = PageFactory.initElements(driver, CommonPage.class);
    }

    public void checkPageTitle(String expectedPageTitle) {
        assertEquals(commonPage.getBrowserTabTitle(), expectedPageTitle);
    }

}
