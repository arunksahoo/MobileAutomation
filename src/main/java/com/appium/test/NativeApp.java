package com.appium.test;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeApp extends BaseTest {
	public static AndroidDriver<?> mobiledriver;
	  @Test
	  public void beforeTest( ) throws MalformedURLException {
		  
		File appDir = new File(System.getProperty("user.dir") + "/ApplicationFolder");
		File app = new File(appDir, "ApiDemos-debug.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    capabilities.setCapability("newCommandTimeout", 2000);
	    mobiledriver = new AndroidDriver<>(getServiceUrl(), capabilities);
	  }

	  @AfterTest
	  public void afterTest( ) {
	    mobiledriver.quit();
	  }

}
