package com.smlsnnshn.pages;

import com.smlsnnshn.utilities.BrowserUtils;
import com.smlsnnshn.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(css = " .alert.alert-error")
    public WebElement invalidEntryMessage;

}
