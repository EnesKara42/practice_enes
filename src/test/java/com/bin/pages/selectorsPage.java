package com.bin.pages;

import com.bin.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectorsPage {
    public selectorsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@name='cars']")
    public WebElement dropdown;

    @FindBy(xpath = "//input[@type='date']")
    public WebElement date;

    @FindBy(xpath= "//input[@id='ohrmList_chkSelectRecord_14']")
    public WebElement jordanMathews;

    @FindBy(xpath = "//input[@id='jex']")
    public WebElement CurrentCrashName;

    @FindBy(xpath = "//*[@id='pact2']")
    public WebElement iFrame;

    @FindBy(xpath = "//input[@id='tea']")
    public WebElement root1;

    @FindBy(xpath = "//input[@id='userId']")
    public WebElement EnterEmail;

    @FindBy(xpath ="//input[contains(@placeholder,'First Enter')]" )
    public WebElement EnterFirstName;

    @FindBy(xpath ="//input[contains(@placeholder,'Last')]" )
    public WebElement EnterLastName;
}
