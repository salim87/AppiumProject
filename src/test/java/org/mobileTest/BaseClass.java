package org.mobileTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
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
        options.setDeviceName("SalimMobile");
        options.setApp( "C:\\Users\\salim\\workspace\\Appium\\src\\test\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
       // driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }


    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
