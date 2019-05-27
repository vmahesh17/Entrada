package Entrada.MobileApp;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

@Test
public class TC1 extends Keywords {
	
	public static void LoginApp() {

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

			sendKeys(User_ID, "a1@yopmail.com");
			sendKeys(Password, "10");
			longPress(Login);
			click(env_Qa2);
			click(Login);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
