package com.game.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class Base {
	
	public static AndroidDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	public static String stepName;
	public static String reportTime;
	
	
	public void setUp() {
		
		try {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		service = AppiumDriverLocalService.buildService(builder);
		service.clearOutPutStreams();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/src/main/resources/app-stage-debug.apk");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"S8VBYV4IB769JUGP");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability("appPackage", "com.game.rummy777.stage");
		capabilities.setCapability("appActivity", "com.game.rummy777.ui.splash.SplashActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		
		
		driver = new AndroidDriver<MobileElement>(builder, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Driver created....");
		
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}

	public void tearDown() {
		try {
			service.stop();
		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	

}
