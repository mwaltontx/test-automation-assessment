package com.mwaltontx.demo.pages;

import com.mwaltontx.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CreditCardsPage extends TestBase {
    @FindBy(xpath = "//div[@class='dfscontainer light-theme aem-GridColumn aem-GridColumn--default--12']")
    List<WebElement> creditCardProducts;

    public CreditCardsPage() {
        PageFactory.initElements(driver, this);
    }

    public void applySecuredCreditCard() {
        WebElement applyNow = getApplyNow(getSecuredCreditCard());

        // TODO: This click() works about 60% of the time from my machine
        // Would suggest running from other machines to see if similar experience before triaging further
        applyNow.click();
    }

    public WebElement getSecuredCreditCard() {
        return creditCardProducts.stream()
            .filter(item -> item.findElement(By.xpath(".//a[@class='cmp-button cmp-link-blue-font ']")).getText().contains("Secured Credit Card"))
            .collect(Collectors.toList())
            .get(0);
    }

    public WebElement getApplyNow(WebElement ccElement) {
        WebElement parentApplyNowContainer = ccElement.findElement(By.xpath(".//div[@class='cmp-container__column cmp-container__column-3 cmp-container-3']"));
        List<WebElement> applyNowContainerContents = parentApplyNowContainer.findElements(By.xpath("./child::*"));
        return applyNowContainerContents.stream()
            .filter(item -> item.findElement(By.xpath(".//a")).getText().contains("Apply Now"))
            .collect(Collectors.toList())
            .get(0);
    }
}
