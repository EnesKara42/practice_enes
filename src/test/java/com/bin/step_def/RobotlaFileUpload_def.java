package com.bin.step_def;

import com.bin.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotlaFileUpload_def {
    @When("User tried to file upload , should be able to upload file with robot")
    public void userTriedToFileUploadShouldBeAbleToUploadFileWithRobot() throws AWTException, InterruptedException {

        /**
         * robotla file upload etme
         */
        Robot rb = new Robot();
        Driver.get().get("https://translate.google.com/?hl=tr&sl=tr&tl=en&op=docs");

        Driver.get().findElement(By.xpath("//span[contains(.,'ü kabul et')]")).click();
        Thread.sleep(3000);
        WebElement gozat=Driver.get().findElement(By.xpath("//label[contains(.,'göz atın')]"));
        gozat.click();
        Thread.sleep(3000);
        StringSelection str = new StringSelection("C:\\Users\\enes\\Desktop\\BİLİM\\interwiew sorular.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        Driver.get().findElement(By.xpath("(//span[contains(.,'Çevir')])[5]")).click();
        Thread.sleep(6000);
        Driver.get().findElement(By.xpath("//span[contains(.,'Çeviriyi indir')]")).click();

    }

}
