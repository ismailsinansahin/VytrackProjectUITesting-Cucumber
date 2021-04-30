package com.smlsnnshn.stepdefinitions;

import com.smlsnnshn.pages.BasePage;
import com.smlsnnshn.pages.CalendarEventsPage;
import com.smlsnnshn.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalendarEventsStepDefs {

    BasePage basePage = new BasePage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("The user should be able to see the default page number as {string}")
    public void the_user_should_be_able_to_see_the_default_page_number_as(String defaultPageNumber) {
        BrowserUtils.waitFor(2);
        basePage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.pageNumber,10);
        Assert.assertEquals("Verify that the page number is 1",
                             defaultPageNumber, calendarEventsPage.pageNumber.getAttribute("value").trim());
        System.out.println("You verified that page number is " + defaultPageNumber);
    }

    @Then("The user should be able to see the default view per page number as {string}")
    public void the_user_should_be_able_to_see_the_default_view_per_page_number_as(String viewPerPageNumber) {
        BrowserUtils.waitFor(2);
        basePage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.viewPerPageDefault,10);
        Assert.assertTrue("Verifying default view per page number is 25",
                           calendarEventsPage.viewPerPageDefault.getText().contains(viewPerPageNumber));
        System.out.println("You verified that default view per page number is " + viewPerPageNumber);
    }




}
