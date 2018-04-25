package seleniumTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.ExtentManager;
import utility.Modules;

public class SecondSetOfTests {
	public static WebDriver driver;
	static ExtentReports rep = ExtentManager.getInstance();
	static ExtentTest test;	
	
	
	@Test(enabled=false)
	public static void signUpToXDC() throws Exception{
		test = rep.startTest("signUpToXDC");
		test.log(LogStatus.INFO, "Going to run the test signUpToXDC");
		
		String browser = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls", "URL");
		test.log(LogStatus.INFO, "got the browser and url");
		
	    driver = Modules.launchBrowser(browser, url);
	    test.log(LogStatus.INFO, "browser launched");
	    
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//html/body/div[6]/main/div[1]/div/div/form/div[1]/h2

		String expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA1");
		String actualText = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
		String passFail = Modules.verifyText(actualText, expString);
		if(passFail.contains("pass"))
			test.log(LogStatus.PASS, expString + " is verified successfully");
		else
			test.log(LogStatus.FAIL, expString + " is NOT verified successfully");
		
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")).sendKeys("sunitha");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input")).sendKeys("Pentapati");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")).sendKeys("sunitha_pen@yahoo.com");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input")).sendKeys("4082394284");
		//html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select
		WebElement  selectCountry = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select"));
		Select select = new Select(selectCountry);
		select.selectByVisibleText("United States");
		Thread.sleep(20000);

		
		//policy terms clicking
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click();
		Thread.sleep(1000);
		//get started clicking
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/button")).click();

		//Sunitha, an email is on its way
		
		expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA2");
		Thread.sleep(3000);
		actualText = driver.findElement(By.xpath("html/body/main/div/div/div/div[1]/div/div/div[2]/h1")).getText();
		passFail = Modules.verifyText(actualText, expString);
		if(passFail.contains("pass"))
			test.log(LogStatus.PASS, expString + " is verified successfully");
		else
			test.log(LogStatus.FAIL, expString + " is NOT verified successfully");
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/main/div/div/div/div[1]/div/div/a")).click(); Thread.sleep(10000);
		passFail = Modules.verifyChildWindowTitle(driver, "Yahoo");
		if(passFail.contains("pass"))
			test.log(LogStatus.PASS, "Yahoo is verified successfully");
		else
			test.log(LogStatus.FAIL, "Yahoo is NOT verified successfully");		
		
		Modules.XLUpdate(5, passFail);
		Modules.closeBrowser(driver);
		
	}
	
	
	@Test(enabled=false)
	public static void errorMessage() throws Exception{
		
		String browser = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls", "URL");
		driver = Modules.launchBrowser(browser, url);
 
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click(); Thread.sleep(2000);
		
		//html/body/div[6]/main/div[1]/div/div/form/div[1]/h2

		String expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA1");
		String actualText = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText(); Thread.sleep(20000);
		String passFail = Modules.verifyText(actualText, expString);
		
		//policy terms clicking
		//driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click(); Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/button")).click(); Thread.sleep(2000);
		System.out.println("sdf");
		
		expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA3");
		actualText = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-1']")).getText(); Thread.sleep(1000);
		passFail = Modules.verifyText(actualText, expString);
		
		
		expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA4");
		actualText = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-2']")).getText(); Thread.sleep(1000);
		passFail = Modules.verifyText(actualText, expString);
		
		
		expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA5");
		actualText = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-3']")).getText(); Thread.sleep(1000);
		passFail = Modules.verifyText(actualText, expString);
		
		
		String expString4 = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA6");
		String actualText4 = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-4']")).getText(); Thread.sleep(1000);
		passFail = Modules.verifyText(actualText4, expString4);
		//html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label
		
		String expString5 = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA7");
		String actualText5 = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label")).getText(); Thread.sleep(1000);
		passFail = Modules.verifyText(actualText5, expString5);
		
		Modules.XLUpdate(6, passFail);
		Modules.closeBrowser(driver);
	}
	
	@Test(enabled=false)
	public static void verifyTermsAndPolicies() throws Exception{
		
		String browser = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","BROWSER");
		String url = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls", "URL");
		
		driver = Modules.launchBrowser(browser, url);
 
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click(); Thread.sleep(2000);
		
		//html/body/div[6]/main/div[1]/div/div/form/div[1]/h2

		String expString = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA1");
		String actualText = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText(); Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);
		//"glf-copyright row"
		//.//*[@id='glf']/div[2]/div
		//List<WebElement> ele = driver.findElement(By.class)
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[1]")).click(); Thread.sleep(2000);
		Modules.verifyChildWindowTitle(driver, "Terms");
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[2]")).click(); Thread.sleep(2000);
		Modules.verifyChildWindowTitle(driver, "Privacy");
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[3]")).click(); Thread.sleep(2000);
		Modules.verifyChildWindowTitle(driver, "Offer details");
		
		driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a")).click(); Thread.sleep(5000);
		String expString1 = Modules.getInputDataFromPropertiesFile("SecondSetProperties.xls","EXPDATA8");
		String applicationTitle=driver.getTitle();
		passFail = Modules.verifyText(applicationTitle, expString1);
		
		Modules.XLUpdate(7, passFail);
		Modules.closeBrowser(driver);
		
	}

	@AfterMethod
	public void quit() {
		rep.endTest(test);
		rep.flush();
	}
}
