package com.mwaltontx.demo.pages;

import com.mwaltontx.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecuredCreditCardLandingPage extends TestBase {
    @FindBy(xpath = "//*[@id='adaptive-skip-this-step']")
    WebElement skipStepLink;


    public SecuredCreditCardLandingPage() {
        PageFactory.initElements(driver, this);
    }

    public void skipStep() {
        skipStepLink.click();
    }
}

