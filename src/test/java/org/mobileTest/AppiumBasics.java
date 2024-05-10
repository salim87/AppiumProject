package org.mobileTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseClass{

    @Test
    public void wifiSettings(){

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"))
                .click();

        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"))
                .click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Tas wifi");
        driver.findElement(By.id("android:id/button1")).click();

    }
}
