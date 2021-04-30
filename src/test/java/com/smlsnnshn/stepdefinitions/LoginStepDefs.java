package com.smlsnnshn.stepdefinitions;

import com.smlsnnshn.pages.BasePage;
import com.smlsnnshn.pages.LoginPage;
import com.smlsnnshn.utilities.BrowserUtils;
import com.smlsnnshn.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Given("The user should be login as a {string}")
    public void the_user_should_be_login_as_a(String userType) {
        switch (userType) {
            case "Driver":
                login(ConfigurationReader.get("driverUsername"), ConfigurationReader.get("driverPassword"));
                System.out.println("You logged in as a " + userType);
                break;
            case "Store Manager":
                login(ConfigurationReader.get("salesmanagerUsername"), ConfigurationReader.get("salesmanagerPassword"));
                System.out.println("You logged in as a " + userType);
                break;
            case "Sales Manager":
                login(ConfigurationReader.get("storemanagerUsername"), ConfigurationReader.get("storemanagerPassword"));
                System.out.println("You logged in as a " + userType);
                break;
            default:
                System.out.println("No user type matching - 'Driver', 'Store Manager', 'Sales Manager'");
        }
    }

    @Then("the user should be able to login with valid credentials {string} {string}")
    public void the_user_should_be_able_to_login_with_valid_credentials(String username, String password) {
        login(username, password);
        BrowserUtils.waitForVisibility(basePage.modulesBar, 5);
        Assert.assertTrue("Verify login is successful", basePage.modulesBar.isDisplayed());
        System.out.println("Verified that user can login with valid credentials");
    }

    @Then("the user should NOT be able to login with invalid credentials {string} {string}")
    public void the_user_should_NOT_be_able_to_login_with_invalid_credentials(String username, String password) {
        login(username, password);
        BrowserUtils.waitForVisibility(loginPage.invalidEntryMessage, 5);
        Assert.assertTrue("Verify login is not successful", loginPage.invalidEntryMessage.isDisplayed());
        System.out.println("Verified that user cannot login with invalid credentials");
    }

    @Then("the user should NOT be able to login with blank credentials {string} {string}")
    public void the_user_should_NOT_be_able_to_login_with_blank_credentials(String username, String password) {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = "";
        if (username.contains("blank")) {
            username = "";
            login(username, password);
            actualMessage = loginPage.usernameInput.getAttribute("validationMessage");
        }
        if (password.contains("blank")) {
            password = "";
            login(username, password);
            actualMessage = loginPage.passwordInput.getAttribute("validationMessage");
        }
        Assert.assertEquals("Verify login is not successful", expectedMessage, actualMessage);
        System.out.println("Verified that user cannot login with invalid credentials and error message is correct");
    }

    public void login(String username, String password) {
        BrowserUtils.waitForClickability(loginPage.usernameInput, 5);
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

}
