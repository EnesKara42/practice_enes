package com.bin.pages;

import com.bin.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectorsPage {
    public selectorsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//select[@name='cars']")
    public WebElement dropdown;
}
