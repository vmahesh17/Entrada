package Entrada.MobileApp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TC1 extends Keywords {

	public static void CreatePIN_Login() throws IOException {

		try {
			App.Deviceselection("Real Device");
			System.out.println("test");
			wait("3");
			System.out.println("wait done for 30 secs");
			getText(Choose_PIN);
			System.out.println("Printing the text of Choose PIN" + "   " + getText(Choose_PIN));
			sendKeys(Choose_PIN, "1111");
			click(OK);
			getText(Confirm_PIN);
			System.out.println("Printing the text of Confirm PIN" + "   " + getText(Confirm_PIN));
			sendKeys(Confirm_PIN, "1111");
			click(OK);

			wait("2");
			sendKeys(User_ID, "a1@yopmail.com");
			driver.hideKeyboard();
			sendKeys(Password, "Entrada@1");
			longPress(Login);
			wait("2");

			click(env_Qa2);
			wait("2");
			click(Login);
			Thread.sleep(5000);

			click(schedule);
			wait("2");

			driver.runAppInBackground(5);

			driver.currentActivity();
			wait("2");
			waitForElement(EnterPIN);

			TC1.EnterPIN();
			/*
			 * // Capturing screenshot File scrFile =
			 * driver.getScreenshotAs(OutputType.FILE); String Datepattern = "DD_MM_YY";
			 * 
			 * SimpleDateFormat Date = new SimpleDateFormat(Datepattern); // String Filename
			 * = UUID.randomUUID().toString(); File targetfile = new
			 * File("target/Screenshots/" + Date + ".jpg"); FileUtils.copyFile(scrFile,
			 * targetfile);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void EnterPIN() throws MalformedURLException {
		
		// App.Deviceselection("Real Device");
		sendKeys(EnterPIN, "1111");
		click(OK);

	}

}
