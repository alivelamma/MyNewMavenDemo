package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.ExtentManager;
import utility.Modules;

public class FirstSetOfTests {
	static WebDriver driver;
	static ExtentReports rep = ExtentManager.getInstance();
	static ExtentTest test;	


	@Test(enabled=false)
	public static void launchApp() throws Exception {
	
		test = rep.startTest("launchApp");
		test.log(LogStatus.INFO, "Going to run the test launchApp");
		
		String browser = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls", "URL");
		test.log(LogStatus.INFO, "got the browser and url");

		driver = Modules.launchBrowser(browser, url);
		driver = Modules.Login_toXero(driver);
		test.log(LogStatus.INFO, "Logged into browser");

		String applicationTitle=driver.getTitle();
		String expString = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","EXPDATA1");
		String passFail = Modules.verifyText(applicationTitle, expString);
		
		if(passFail.contains("pass"))
			test.log(LogStatus.PASS, "launchApp test is pass");
		else
			test.log(LogStatus.FAIL, "launchApp test Failed");
		
		Modules.XLUpdate(1, passFail);
		Modules.closeBrowser(driver);
	}

	
	@Test(enabled=false)
	public static void incorrectPassword() throws Exception {
		
		String browser = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls", "URL");
		
		driver = Modules.launchBrowser(browser, url);
		driver = Modules.Login_toXero(driver, "User@gmail.com", "pwd");

		String expString = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","EXPDATA2");
		String actualText = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		String passFail = Modules.verifyText(actualText, expString);
		
		Modules.XLUpdate(2, passFail);
		Modules.closeBrowser(driver);

	}
	

	@Test(enabled=false)
	public static void incorrectEmail() throws Exception {
		
		String browser = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls", "URL");
		
		driver = Modules.launchBrowser(browser, url);
		driver = Modules.Login_toXero(driver, "User@gmail.com", "pwd");
		
		String expString = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","EXPDATA2");
		String actualText = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		String passFail = Modules.verifyText(actualText, expString);
		
		Modules.XLUpdate(3, passFail);
		Modules.closeBrowser(driver);
	}
	
	
	@Test(enabled=false)
	public static void forgotPassword() throws Exception{
		
		String browser = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls", "URL");
		
		driver = Modules.launchBrowser(browser, url);
		
		driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a")).click(); Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("sunitha_pen@yahoo.com"); Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='submitButton']/a/span")).click(); Thread.sleep(2000);


		String expString = Modules.getInputDataFromPropertiesFile("FirstSetProperties.xls","EXPDATA3");
		String actualText = driver.findElement(By.xpath(".//*[@id='contentTop']/div/p[1]")).getText();
		String passFail = Modules.verifyText(actualText, expString);
		
		Modules.XLUpdate(4, passFail);
		Modules.closeBrowser(driver);
	}
	
	
	@AfterMethod
	public void quit() {
		rep.endTest(test);
		rep.flush();
	}


	public static void main(String args[]) throws InterruptedException {

		//launchApp();
		//incorrectPassword();
		//incorrectEmail();

	}

}
