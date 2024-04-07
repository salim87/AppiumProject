package org.mobileTest.saucelabs;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabTests {

    @Test
    public void init() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:com.saucelabs.mydemoapp.ios");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("appium:deviceName", "iPhone Simulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "oauth-salimdls-784b8");
        sauceOptions.setCapability("accessKey", "d8a22abd-593c-4470-afa5-19d88f47b628");
        sauceOptions.setCapability("build", "oauth-salimdls-784b8");
        sauceOptions.setCapability("name", "salim-test");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        IOSDriver driver = new IOSDriver(url, caps);
    }
}