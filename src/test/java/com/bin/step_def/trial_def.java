package com.bin.step_def;

import com.bin.pages.selectorsPage;
import com.bin.utilities.ConfigurationReader;
import com.bin.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class trial_def {
    selectorsPage selectorsPage=new selectorsPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();

    @When("Practice page")
    public void practicePage() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("attribute changes")
    public void attributeChanges() {

        js.executeScript("arguments[0].setAttribute('placeholder','deli oglan');", selectorsPage.EnterEmail);

    }

    @When("change the html structure")
    public void changeTheHtmlStructure() throws InterruptedException {
        /**
         * Disabled bir elementi enabled yapma ve içine bir şeyler yazdırma
         */
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterFirstName);
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterLastName);
        Thread.sleep(3000);
        selectorsPage.EnterFirstName.sendKeys("sarıların");
        selectorsPage.EnterLastName.sendKeys("sülo");
    }


}
