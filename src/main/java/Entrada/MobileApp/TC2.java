package Entrada.MobileApp;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TC2 extends Keywords {

	// Create Job
	public static void Joblist() throws IOException {

		ExtentHtmlReporter reports = new ExtentHtmlReporter(
				"C:\\Users\\Admin\\eclipse-workspace\\MobileApp\\Extent_Reports\\Report1.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reports);

		ExtentTest logger = extent.createTest("Verifying TC2");

		//TC1.EnterPIN();

		// logger.log(Status.INFO, "Logged into app");

		// service.stop();

		logger.log(Status.WARNING, "Appium server has been stopped");

		wait("3");
		getText(JoblistTitle);
	}
}