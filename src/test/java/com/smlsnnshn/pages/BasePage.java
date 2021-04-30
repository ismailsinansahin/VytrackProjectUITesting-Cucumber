package com.smlsnnshn.pages;

import com.smlsnnshn.utilities.BrowserUtils;
import com.smlsnnshn.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public BasePage(){ PageFactory.initElements(Driver.get(),this); };

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(id = "main-menu")
    public WebElement modulesBar;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboardTitle;

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     *
     * @param moduleName
     * @param tabName
     */
    public void navigateToModule(String moduleName, String tabName) {
        String moduleLocator = "//span[normalize-space()='" + moduleName + "' and contains(@class, 'title title-level-1')]";
        String tabLocator = "//span[normalize-space()='" + tabName + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickability(By.xpath(moduleLocator), 5);
            WebElement moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
            new Actions(Driver.get()).moveToElement(moduleElement).pause(200).doubleClick(moduleElement).build().perform();
        }
        catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(moduleLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(tabLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(tabLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(tabLocator)));
            Driver.get().findElement(By.xpath(tabLocator)).click();
        }
        catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(tabLocator)),  5);
        }
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled by try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
