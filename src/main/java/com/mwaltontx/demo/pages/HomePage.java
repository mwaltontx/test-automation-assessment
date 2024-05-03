package com.mwaltontx.demo.pages;

import com.mwaltontx.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends TestBase {
    @FindBy(xpath = "//ul[@class='carousel__track']")
    WebElement parentHelpList;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void go() {
        driver.get("https://www.discover.com/");
    }

    public void clickCreditCards() {
        getCreditCardsHelpLink().click();
    }

    public WebElement getCreditCardsHelpLink() {
        return getHelpLink("Credit Cards");
    }

    public WebElement getHelpLink(String text) {
        List<WebElement> helpList = parentHelpList.findElements(By.xpath("./child::*"));
        return helpList.stream()
            .filter(item -> item.getText().equals(text))
            .collect(Collectors.toList())
            .get(0);
    }
}
