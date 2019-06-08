package Entrada.MobileApp;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidKeyCode;

@Test
public class TC3 extends Keywords {
	public static void testcase3() throws IOException {
		// TODO Auto-generated method stub
		
		wait("2");
//		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		/*driver.closeApp();
		driver.launchApp();
		*/
//		TC1.EnterPIN();

		// Job Creation

		System.out.println("Executed successfully");
		// waitForElement(JoblistTitle);
		String S = getText(JoblistTitle);

		Assert.assertEquals(S, "Job List", "PASSED");

	}

}
