package Entrada.MobileApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class App 
{
   
	// Capabilities setting here 

	public static AndroidDriver<AndroidElement> driver;
	
	public void Capabilities() throws MalformedURLException {
	
	DesiredCapabilities cap =new DesiredCapabilities();
	cap.setCapability("deviceName", "98897a433352455332");
	cap.setCapability("platformname", "Android");
	
	cap.setCapability("platformVersion", "9");
	cap.setCapability("appPackage", "com.android.chrome");
	cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	cap.setCapability("fullReset","false");
    
    
    AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap );
  //System.out.println(driver.getPageSource());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    
}


	
}