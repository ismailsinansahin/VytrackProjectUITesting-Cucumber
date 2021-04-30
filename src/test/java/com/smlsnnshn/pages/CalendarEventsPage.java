package com.smlsnnshn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement optionsLink;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement viewPerPageDefault;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]//span[@class='caret']")
    public WebElement viewPerPageButton;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement totalOfRecordsMessage;

    @FindBy(xpath = "//a[@data-grid-pagination-direction='next']")
    public WebElement nextPageArrow;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement viewPerPage100;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rowsNumber;

    @FindBy(xpath = "(//label[contains(text(),'of')])[1]")
    public WebElement maxPageMessage;

    @FindBy(className = "fa-repeat")
    public WebElement refreshButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']//input")
    public WebElement selectAllBox;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEventButton;

}
