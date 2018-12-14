package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * IOS Browser Sauce Labs Test.
 */
public class IOSBrowserSaucelabsTest extends BaseTest{
  public static final String USERNAME = "YOUR_USERNAME";
  public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
  public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
  public static IOSDriver<?> mobiledriver;

  @BeforeTest
  public void beforeTest( ) throws MalformedURLException 
  {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.3");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Simulator");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.8.1");
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new IOSDriver<>(new URL(URL), capabilities);

  }

  @AfterTest
  public void afterTest( ) 
  {
    mobiledriver.quit();
  }

  @Test
  public static void launchBrowser(){
    mobiledriver.get("http://appium.io/");
    Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
    Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}