package com.mwaltontx.demo.pages;

import com.mwaltontx.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SecuredCreditCardApplicationPage extends TestBase {
    @FindBy(xpath = "//div[@class='terms-and-conditions-rates-box']")
    WebElement parentRateContainer;


    public SecuredCreditCardApplicationPage() {
        PageFactory.initElements(driver, this);
    }

    public Float getApr() {
        return Float.parseFloat(getAprContents().findElement(By.xpath(".//p[@class='apr-value purchase-rate-apr apr-value-big']"))
            .getText()
            .replace("%",""));
    }

    public WebElement getAprContents() {
        return getRatesAndInterestContents("Annual Percentage Rate (APR) for Purchases");
    }

    public WebElement getRatesAndInterestContents(String keyword) {
        List<WebElement> rateContents = parentRateContainer.findElements(By.xpath("./child::*"));
        return rateContents.stream()
            .filter(item -> item.getText().contains("Annual Percentage Rate (APR) for Purchases"))
            .collect(Collectors.toList())
            .get(0);
    }
}

