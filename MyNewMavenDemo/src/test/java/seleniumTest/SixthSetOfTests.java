package seleniumTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.Modules;

public class SixthSetOfTests {
	
	public static WebDriver driver;
	
	@Test(enabled=false)
	public static void UploadImage() throws InterruptedException, IOException {

		String browser = Modules.getInputDataFromPropertiesFile(
				"SixthSetProperties.xls", "BROWSER");
		String url = Modules.getInputDataFromPropertiesFile(
				"SixthSetProperties.xls", "URL");

		driver = Modules.launchBrowser(browser, url);
		Thread.sleep(10000);
		
		String expString = Modules.getInputDataFromPropertiesFile(
				"SixthSetProperties.xls", "EXPDATA1");
		String actualText = driver.getTitle();
		Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);
		System.out.println(passFail + "test case passed");
		
		
		String username = Modules.getInputDataFromPropertiesFile("SixthSetProperties.xls", "UNAME");
		String password = Modules.getInputDataFromPropertiesFile("SixthSetProperties.xls", "PASS");
		driver = Modules.Login_toXero(driver, username, password);
		
		String expString1 = Modules.getInputDataFromPropertiesFile(
				"SixthSetProperties.xls", "EXPDATA2");
		String actualText1 = driver.getTitle();
		Thread.sleep(2000);
		String passFail1 = Modules.verifyText(actualText1, expString1);
		
		Modules.ProfileButton(driver);
		
		String expString2 = Modules.getInputDataFromPropertiesFile(
				"SixthSetProperties.xls", "EXPDATA3");
		
		String actualText2 = driver.getTitle();
		Thread.sleep(2000);
		String passFail2 = Modules.verifyText(actualText2, expString);
		System.out.println(passFail2 + "test case passed");
		
		
		// Modules.closeBrowser(driver);
	}

}
