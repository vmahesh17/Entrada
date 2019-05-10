package Entrada.MobileApp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Keywords extends App implements Elements {

	


	public  String[] splitXpath(String path) {
		String[] a = path.split(">");
		return a;
	}
	
	public  void click(String path) {
		String[] values = splitXpath(path);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();
			//ATUReports.add("Click on " + values[0], LogAs.PASSED, true, values[0]);
		} catch (Exception e) {
			//ATUReports.add1("Unable to click on " + values[0], LogAs.FAILED, true, values[0]);
			Assert.fail();
		}
	}
}
	

