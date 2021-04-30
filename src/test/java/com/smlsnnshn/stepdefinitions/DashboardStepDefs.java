package com.smlsnnshn.stepdefinitions;

import com.smlsnnshn.pages.BasePage;
import com.smlsnnshn.utilities.BrowserUtils;
import com.smlsnnshn.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardStepDefs {

    BasePage basePage = new BasePage();

    @When("The user click on {string}")
    public void the_user_click_on(String shortcut) {
        String path = "//span[@class='title-box'][contains(text(),'" + shortcut + "')]/..";
        basePage.waitUntilLoaderScreenDisappear();
        WebElement shortcutLink = Driver.get().findElement(By.xpath(path));
        BrowserUtils.waitForVisibility(shortcutLink,5);
        Driver.get().findElement(By.xpath(path)).click();
        System.out.println("You clicked on the " + shortcut + " shortcut");
    }

}
