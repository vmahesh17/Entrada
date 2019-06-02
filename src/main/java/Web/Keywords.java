package Web;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Keywords   {
	public static WebDriver driver;
	
	public static String[] splitXpath(String path) {
		String[] a = path.split(">");
		return a;
	}

	public static void click(String path) {
		String[] values = splitXpath(path);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();

		} catch (Exception e) {

			//Assert.fail();
		}
	}

	public static String sendKeys(String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.sendKeys(keysToSend);
			//driver.hideKeyboard();
			// ATUReports.add("Type on " + values[0], keysToSend, true, values[0]);

		} catch (Exception e) {
			// ATUReports.add1("Unable to type on " + values[0], keysToSend, true,
			// values[0]);
			Assert.fail();
		}
		return keysToSend;
	}
}


