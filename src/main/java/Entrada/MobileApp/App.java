package Entrada.MobileApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class App {

	// Capabilities setting here

	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;

	public static void Deviceselection(String Device) throws MalformedURLException {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		File f = new File("src");
		File fs = new File(f, "appiumbuild1125.apk");

		if (Device.equals("Emulator")) {

			// cap.setCapability("deviceName", "98897a433352455332"); SAMSUNG S8
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "Nexus 6P");
			cap.setCapability("app", fs.getAbsolutePath());
			cap.setCapability("appPackage", "com.entradahealth.entrada.android");
			cap.setCapability("appActivity",
					"com.entradahealth.entrada.android.app.personal.activities.user_select.UserSelectActivity");
			cap.setCapability("borwserName", "Chrome");
			cap.setCapability("fullReset", "false");
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			// System.out.println(driver.getPageSource());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}

		else if (Device.equals("Real Device")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//0619826e2298e95f
			cap.setCapability("deviceName", "0619826e2298e95f");
			cap.setCapability("platformname", "Android");
			cap.setCapability("platformVersion", "6.0.1");
			cap.setCapability("app", fs.getAbsolutePath());
			cap.setCapability("appPackage", "com.entradahealth.entrada.android");
			cap.setCapability("appActivity",
					"com.entradahealth.entrada.android.app.personal.activities.user_select.UserSelectActivity");
			cap.setCapability("borwserName", "Chrome");
			cap.setCapability("fullReset", "false");		
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			// System.out.println(driver.getPageSource());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}

	}

}
