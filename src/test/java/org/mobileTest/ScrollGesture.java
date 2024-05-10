package org.mobileTest;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollGesture extends BaseClass{

    @Test
    public void swipeGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

       // swipeDown();


    }
}
