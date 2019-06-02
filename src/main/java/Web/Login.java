package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class Login extends Keywords implements Elements {

	@Test
	public static void main(String args[]) throws InterruptedException {

		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\MobileApp\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();
		driver.get(Url);
		Thread.sleep(5000); // Let the user actually see something!
		driver.findElement(By.name("q")).sendKeys("Python");
		//sendKeys(Search_Box, "Selenium checking on Web");
		click(Button1);
	}

}
