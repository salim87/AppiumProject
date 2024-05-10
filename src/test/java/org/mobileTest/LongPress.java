package org.mobileTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseClass{

    @Test
    public void longPress(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists"))
                .click();

        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

       longPressAction(element);

       String menu= driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']"))
               .getText();

        Assert.assertEquals("Sample menu", menu);

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']"))
                .isDisplayed());


    }
}
