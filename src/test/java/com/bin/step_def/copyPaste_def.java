package com.bin.step_def;

import com.bin.utilities.Driver;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Robot;

public class copyPaste_def {
    Actions actions = new Actions(Driver.get());
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();





    @When("User hold ctrl and press c button")
    public void user_hold_ctrl_and_press_c_button() {
        Driver.get().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        /**
         copy-paste nasıl yapılır buradan öğrenebilirsin
         **/
        WebElement inputText = Driver.get().findElement(By.name("my-text"));
        WebElement textarea = Driver.get().findElement(By.name("my-textarea"));

        Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;

        actions.sendKeys(inputText, "hello world").keyDown(modifier)
                .sendKeys(inputText, "a").sendKeys(inputText, "c")
                .sendKeys(textarea, "v").build().perform();
        Assert.assertEquals(inputText.getAttribute("value"), textarea.getAttribute("value"));

    }

    @When("User hold the mouse curser and release it")
    public void userHoldTheMouseCurserAndReleaseIt() {

         /**
         *Seçtiğimiz webelementteki attributeları değiştirme
          */


        WebElement canvas = Driver.get().findElement(By.xpath("//input[@type='range']"));
        js.executeScript("arguments[0].setAttribute('value','2');", canvas);

    }

    @When("User tried to file upload , should be able to upload file")
    public void userTriedToFileUploadShouldBeAbleToUploadFile() throws IOException, InterruptedException, AWTException {
        /**
         * dosya upload etme
         */
        String initUrl =  Driver.get().getCurrentUrl();

        WebElement inputFile = Driver.get().findElement(By.name("my-file"));
        Thread.sleep(3000);
        String filename = "C:/Users/enes/Desktop/yabancı diziler.txt";
        System.out.println("filename = " + filename);
        Thread.sleep(3000);

        inputFile.sendKeys(filename);
        Thread.sleep(3000);
        Driver.get().findElement(By.tagName("form")).submit();
        Assert.assertNotEquals(Driver.get().getCurrentUrl(),initUrl);




    }


}
