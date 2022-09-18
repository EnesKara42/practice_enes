package com.bin.step_def;

import com.bin.pages.selectorsPage;
import com.bin.utilities.ConfigurationReader;
import com.bin.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdown_def {
    selectorsPage selectorsPage=new selectorsPage();
    @When("User select a dropdown option {string}")
    public void user_select_a_dropdown_option(String car_name) throws InterruptedException {
        Driver.get().get( ConfigurationReader.get("url"));

        Select dropdown=new Select(selectorsPage.dropdown);
        dropdown.selectByValue(car_name);
        Thread.sleep(5000);
        WebElement selected=dropdown.getFirstSelectedOption();
        String actualResult= selected.getAttribute("value");
        System.out.println("actualResult = " + actualResult);
    }

}
