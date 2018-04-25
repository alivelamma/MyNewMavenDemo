package seleniumTest;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentXeroReport {
	
	public static void extent(){

		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest logger;
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentXeroReport/ExtentXeroReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Tek Arch");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Divyashree");
		
		htmlReporter.config().setDocumentTitle("extent reports");
		htmlReporter.config().setReportName("functional testing reports");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		logger = extent.createTest("Pass Test");
		logger.log(Status.INFO, "started report for pass test");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

		logger = extent.createTest("Fail Test");
		logger.log(Status.FAIL, "Test Case (failTest) Status is passed");
		logger.log(Status.FAIL, MarkupHelper.createLabel("Fail Test" + " - Test Case Failed", ExtentColor.RED));
		
		
		logger = extent.createTest("Skip Test");
			logger.log(Status.SKIP, MarkupHelper.createLabel("Fail Test" + " - Test Case Skipped", ExtentColor.ORANGE));	
		
		
		extent.flush();
		System.out.println("extent code completed");
	}
}



