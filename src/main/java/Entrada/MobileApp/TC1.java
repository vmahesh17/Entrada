package Entrada.MobileApp;

import java.io.File;
import java.io.IOException;

import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.testng.annotations.Test;

@Test
public class TC1 extends Keywords {

	public static void LoginApp() throws IOException {

		try {
			App.Deviceselection("Emulator");
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

			// directly hitting on Login and check whether its enabled or disabled
			wait("2");
			sendKeys(User_ID, "a1@yopmail.com");
			driver.hideKeyboard();
			sendKeys(Password, "Entrada@1");
			longPress(Login);
			wait("2");

			click(env_Qa2);
			click(Login);
			wait("4");

			// Capturing screenshot
			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			String Filename = UUID.randomUUID().toString();
			File targetfile = new File("target/Screenshots/" + Filename + ".jpg");
			FileUtils.copyFile(scrFile, targetfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
