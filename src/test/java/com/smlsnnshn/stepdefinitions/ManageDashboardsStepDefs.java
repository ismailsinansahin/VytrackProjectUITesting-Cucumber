package com.smlsnnshn.stepdefinitions;

import com.smlsnnshn.pages.BasePage;
import com.smlsnnshn.pages.ManageDashboardsPage;
import com.smlsnnshn.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ManageDashboardsStepDefs {

    @Then("The user should be able to see the {string} as a page name")
    public void theUserShouldBeAbleToSeeTheCorrectPageName(String pageName) {
        new BasePage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(new ManageDashboardsPage().pageName,10);
        Assert.assertEquals("Verify that the page name is correct",
                            pageName, new ManageDashboardsPage().pageName.getText());
        System.out.println("You verified that the page name is correct");
    }

}
