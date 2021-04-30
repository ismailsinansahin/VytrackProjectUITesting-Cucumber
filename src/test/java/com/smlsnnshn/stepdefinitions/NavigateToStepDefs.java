package com.smlsnnshn.stepdefinitions;

import com.smlsnnshn.pages.BasePage;
import com.smlsnnshn.utilities.BrowserUtils;
import com.smlsnnshn.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class NavigateToStepDefs {

    BasePage basePage = new BasePage();

    @Given("The user should be able to navigate to {string} {string}")
    public void the_user_should_be_able_to_navigate_to(String moduleName, String tabName) {
        String modulePath = "//span[@class='title title-level-1'][contains(text(),'" + moduleName + "')]";
        String tabPath = "//span[.='" + tabName + "']";
        try{
            BrowserUtils.waitForClickability(By.xpath(modulePath),5);
            Driver.get().findElement(By.xpath(modulePath)).click();
        }
        catch(Exception e){
            BrowserUtils.clickWithWait(By.xpath(modulePath),5);
        }
        try{
            BrowserUtils.waitForClickability(By.xpath(tabPath),5);
            Driver.get().findElement(By.xpath(tabPath)).click();
        }
        catch(Exception e){
            BrowserUtils.clickWithWait(By.xpath(tabPath),5);
        }
        System.out.println("You navigated to " + moduleName + " module " + tabName + " tab");
    }

    @Then("The user should be on the {string} {string} {string}")
    public void the_user_should_be_on_the(String moduleName, String tabName, String title) {
        BrowserUtils.waitForVisibility(basePage.dashboardTitle,5);
        System.out.println(title);
        System.out.println(basePage.dashboardTitle.getText());
        Assert.assertEquals("Verify that the browser in the correct page",
                            title, basePage.dashboardTitle.getText());
        System.out.println("You verified that you were on the " + moduleName + " module " + tabName + " tab");
    }

}
