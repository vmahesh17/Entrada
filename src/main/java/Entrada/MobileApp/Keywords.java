package Entrada.MobileApp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.TouchAction;

 

public class Keywords extends App implements Elements {
	public static String ElementWait = "5";
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

			Assert.fail();
		}
	}

	public static String sendKeys(String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.sendKeys(keysToSend);
			driver.hideKeyboard();
			// ATUReports.add("Type on " + values[0], keysToSend, true, values[0]);

		} catch (Exception e) {
			// ATUReports.add1("Unable to type on " + values[0], keysToSend, true,
			// values[0]);
			Assert.fail();
		}
		return keysToSend;
	}
	
	public static void longPress(String path) {
		String[] values = splitXpath(path);
		WebElement webElement = driver.findElement(By.xpath(values[1]));
		TouchAction action = new TouchAction(driver);
		action.longPress(webElement).release().perform();
	}

	public static void wait(String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time * 1000;
			Thread.sleep(seconds);
			// ATUReports.add("Waited", LogAs.PASSED, true,"Wait");
		} catch (InterruptedException e) {
			//ATUReports.add1("Unable to wait ", LogAs.FAILED, true, "Wait");
			Assert.fail();
		}
		}
	
	public static void waitForElement(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			int WaitElementSeconds1 = new Integer(ElementWait);
			WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			//ATUReports.add("Wait for the Element " + values[0], LogAs.PASSED, true, values[0]);
		} catch (Exception e) {
			//ATUReports.add1("Element Not Found - " + values[0], LogAs.FAILED, true, values[0]);
			Assert.fail();
			
		}
		
	}

	public static String getText(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = new String(webElement.getText().getBytes("UTF-8"));
			return text;

		} catch (Exception e) {

			Assert.fail();
			return null;
		}
		
		
	}
}
