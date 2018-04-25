package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.ExtentManager;
import utility.Modules;

public class FifthSetOfTests {
	public static WebDriver driver;
	static ExtentReports rep = ExtentManager.getInstance();
	static ExtentTest test;
	
	@Test(enabled=false)
	public static void createAccount() throws Exception{
		
		SecondSetOfTests.signUpToXDC();//test case failed as selenium cannot automate captcha.
	  
		Modules.closeBrowser(driver);
	}

}
