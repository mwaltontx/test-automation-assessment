package com.mwaltontx.demo;

import com.mwaltontx.demo.base.TestBase;
import com.mwaltontx.demo.pages.HomePage;
import com.mwaltontx.demo.pages.CreditCardsPage;
import com.mwaltontx.demo.pages.SecuredCreditCardLandingPage;
import com.mwaltontx.demo.pages.SecuredCreditCardApplicationPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class CreditCardTests extends TestBase {

    @Test
    public void startBrowserTest() {
        HomePage homePage = new HomePage();
        homePage.go();

        homePage.clickCreditCards();

        CreditCardsPage creditCardsPage = new CreditCardsPage();
        creditCardsPage.applySecuredCreditCard();

        SecuredCreditCardLandingPage securedCreditCardLandingPage = new SecuredCreditCardLandingPage();
        securedCreditCardLandingPage.skipStep();

        // Local testing prevented me from accessing the page after "skip this step"
        // It redirected to https://www.discovercard.com/apply/acquisitions/tech_diff.html
        // So I had to uncomment the following to get past it
        driver.get("https://www.discovercard.com/application/website/apply?adpt=mn&srcCde=KXPA&ICMPGN=ALL_CC_SECURED_APPLY_NOW_BTN&_gl=1*iq4rox*_ga*MTA4OTEzMTg4Ny4xNzE0Njg5Nzg2*_ga_3MJNPV4VSE*MTcxNDY4OTc4NS4xLjEuMTcxNDY4OTkxNS41Ni4wLjA.");

        SecuredCreditCardApplicationPage securedCreditCardApplicationPage = new SecuredCreditCardApplicationPage();
        assert(securedCreditCardApplicationPage.getApr() > 20);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
