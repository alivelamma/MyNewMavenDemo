package seleniumTest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import utility.Modules;

public class ThirdSetOfTests {

	public static WebDriver driver;

	@Test(enabled = false)
	public static void testAllTabs() throws InterruptedException, IOException {

		String browser = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "BROWSER");
		String url = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "URL");

		driver = Modules.launchBrowser(browser, url);
		Thread.sleep(10000);
		driver = Modules.Login_toXero(driver, "sunitha_pen@yahoo.com",
				"ptanmayee1");

		driver.findElement(By.xpath(".//*[@id='Dashboard']")).click();

		String expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA1");
		String actualText = driver.getTitle();
		Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);

		 driver.findElement(By.xpath(".//*[@id='Accounts']")).click();
		// driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[1]/a]")).click();
		
		Thread.sleep(5000);

		expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA2");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);

		driver.findElement(By.xpath(".//*[@id='Reports']")).click();

		Thread.sleep(5000);

		expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA3");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='Contacts']")).click();
		Thread.sleep(5000);
		
		

		expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA4");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);

		driver.findElement(By.xpath(".//*[@id='Settings']")).click();
		Thread.sleep(5000);
		
		Thread.sleep(5000);

		expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA5");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);
		
		
		//clicking on the plus button
		driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
		Thread.sleep(5000);
		
		
		Thread.sleep(5000);

		expString = Modules.getInputDataFromPropertiesFile(
				"ThirdSetProperties.xls", "EXPDATA6");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);
		
		
		//clicking on the folder button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		
		expString = Modules.getInputDataFromPropertiesFile("ThirdSetProperties.xls", "EXPDATA7");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);
		
		//clicking on the Notifications button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(5000);
		
		//have to vefify notifications box
		
		expString = Modules.getInputDataFromPropertiesFile("ThirdSetProperties.xls", "EXPDATA8");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		passFail = Modules.verifyText(actualText, expString);
		
		//clicking on the search button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
		Thread.sleep(5000);
		
		//have to verify search box
		
		//clicking on the help button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")).click();
		Thread.sleep(5000);
		
		//have to verify help dropdown
		
		

	}

}
