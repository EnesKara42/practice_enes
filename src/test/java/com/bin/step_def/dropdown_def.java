package com.bin.step_def;

import com.bin.pages.selectorsPage;
import com.bin.utilities.BrowserUtils;
import com.bin.utilities.ConfigurationReader;
import com.bin.utilities.Driver;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class dropdown_def {
    selectorsPage selectorsPage = new selectorsPage();
    Actions actions = new Actions(Driver.get());
    Shadow shadow = new Shadow(Driver.get());
    JavascriptExecutor jsDriver = (JavascriptExecutor) Driver.get();

    @When("User select a dropdown option {string}")
    public void user_select_a_dropdown_option(String car_name) throws InterruptedException, IOException {
        Driver.get().get(ConfigurationReader.get("url"));

        Select dropdown = new Select(selectorsPage.dropdown);
        dropdown.selectByValue(car_name);
        Thread.sleep(5000);
        WebElement selected = dropdown.getFirstSelectedOption();
        String actualResult = selected.getAttribute("value");
        System.out.println("actualResult = " + actualResult);
        String expedtedResult = car_name;
        selectorsPage.date.sendKeys("09091995");

        /**
         * Shadow elementleri handle etme yöntemi
         * ilk önce benim shadow element iframe in içinde olduğu için iframe e geçiş yaptım
         * #shadow-root yazısının üstündeki elementi locate ettim
         * searchContext kodunu yapıştır
         * işlem yapmak istediğin elementi locate et css ile ama
         * yapmak istediğin işlemi yap
         * en son frameden çık
         */

        Driver.get().switchTo().frame(Driver.get().findElement(By.xpath("//*[@id=\"pact\"]")));

        WebElement root1 = Driver.get().findElement(By.xpath("//*[@id=\"snacktime\"]"));
        SearchContext shadowRoot = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", root1);
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("input[id=tea]"));
        shadowElement.sendKeys("enes");
        Driver.get().switchTo().parentFrame();

        /**
         * iframe içinde iframe olunca aiağıdaki gibi yapman gerek
         */
        Driver.get().switchTo().frame("pact1");
        Driver.get().switchTo().frame("pact2");

        selectorsPage.CurrentCrashName.sendKeys("enes");
        Driver.get().switchTo().defaultContent();

        Thread.sleep(3000);

        /**
         * intercepted click exception çözümü
         */
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", selectorsPage.jordanMathews);

        /**
         * screenshot of web element
         */
        File srcFile = selectorsPage.date.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile, new File("./target/test-classes/enes.png"));

        Assert.assertEquals(expedtedResult, actualResult);

    }

}
