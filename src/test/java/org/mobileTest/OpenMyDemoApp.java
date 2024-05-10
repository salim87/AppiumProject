package org.mobileTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class OpenMyDemoApp {

    AndroidDriver driver=null;
    AppiumDriverLocalService service;
    @Test
    public void openApp() throws MalformedURLException, URISyntaxException {

      //Run the server automatially
         service= new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/salim/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
         service.start();

         UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Pixel 4");
      //  options.setApp(System.getProperty("user.dir") + "/src/test/resources/MyDemo.apk");
     //   options.setApp(System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk");

        driver= new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();
        service.stop();

    }

}
