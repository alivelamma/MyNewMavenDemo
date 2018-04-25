package seleniumTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.Modules;

public class FourthSetOfTests {
	
	public static WebDriver driver;

	@Test(enabled = false)
	public static void logOutTest() throws InterruptedException, IOException {

		String browser = Modules.getInputDataFromPropertiesFile(
				"FourthSetProperties.xls", "BROWSER");
		String url = Modules.getInputDataFromPropertiesFile(
				"FourthSetProperties.xls", "URL");

		driver = Modules.launchBrowser(browser, url);
		Thread.sleep(10000);
		
		String expString = Modules.getInputDataFromPropertiesFile(
				"FourthSetProperties.xls", "EXPDATA1");
		String actualText = driver.getTitle();
		Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);
		System.out.println(passFail + "test case passed");
		
		
		driver = Modules.Login_toXero(driver, "sunitha_pen@yahoo.com",
				"ptanmayee1");
		
		String expString1 = Modules.getInputDataFromPropertiesFile(
				"FourthSetProperties.xls", "EXPDATA2");
		String actualText1 = driver.getTitle();
		Thread.sleep(2000);
		String passFail1 = Modules.verifyText(actualText1, expString1);
		
		//calling reusable method from Modules for logging out of Xero
		 driver = Modules.logOut_fromXero(driver);
		
		String expString2 = Modules.getInputDataFromPropertiesFile(
				"FourthSetProperties.xls", "EXPDATA3");
		String actualText2 = driver.getTitle();
		String passFail2 = Modules.verifyText(actualText2, expString2);
		Thread.sleep(10000); 
		 
		 Modules.closeBrowser(driver);
	}

}
