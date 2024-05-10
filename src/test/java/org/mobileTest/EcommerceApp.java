package org.mobileTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EcommerceApp extends BaseClass{

    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
                .sendKeys("Salim Iqbal");

        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

        driver.findElement(By.id("android:id/text1")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"))
                .click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        //System.out.println(toastMessages);

        /*WebElement toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
        ((JavascriptExecutor) driver).executeScript("mobile: isToastVisible ", ImmutableMap.of(
                "elementId", ((RemoteWebElement) toastMessage).getId(),
                "text", "Please enter your name",
                "isRegexp", false

        ));*/

       /* WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Toast)[1]")));
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
        Assert.assertEquals(toastMessage,"Please enter your name");*/


    }
}
