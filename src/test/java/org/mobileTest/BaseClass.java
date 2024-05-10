package org.mobileTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseClass {
    AppiumDriverLocalService service;
    AndroidDriver driver;
    @BeforeClass
    public void startTest() throws URISyntaxException, MalformedURLException {

      //  File app = new File("src/test/resources/ApiDemos-debug.apk");
       // System.out.println(app.exists());
        //start the appium server
         service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/salim/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("nightwatch-android-11");
       // options.setApp( System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk");
        options.setApp( System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
       // driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    public void longPressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
        ));
    }

    boolean canScrollMore;
    public void swipeDown(){
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while(canScrollMore);
    }

    public void swipeLeft(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
