package com.smlsnnshn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageDashboardsPage extends BasePage{

    @FindBy (xpath = "//div[@id='breadcrumb']/ul/li")
    public WebElement pageName;

}
