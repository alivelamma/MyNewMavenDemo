package seleniumTest;

import java.io.IOException;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.Modules;

public class EightSetOfTests {
	
public static WebDriver driver;
	
	@Test(enabled = false)
	public static void addMoreOrganizations() throws InterruptedException, IOException {

		String browser = Modules.getInputDataFromPropertiesFile(
				"EightSetProperties.xls", "BROWSER");
		String url = Modules.getInputDataFromPropertiesFile(
				"EightSetProperties.xls", "URL");

		driver = Modules.launchBrowser(browser, url);
		Thread.sleep(10000);
		
		String expString = Modules.getInputDataFromPropertiesFile(
				"EightSetProperties.xls", "EXPDATA1");
		String actualText = driver.getTitle();
		Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);
		System.out.println(passFail + "test case passed");
		
		String username = Modules.getInputDataFromPropertiesFile("EightSetProperties.xls", "UNAME");
		String password = Modules.getInputDataFromPropertiesFile("EightSetProperties.xls", "PASS");
		//Modules.Login_toXero(driver, username, password);
		//html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
		Thread.sleep(3000);
		String actualTextToVerify2 = driver.findElement(By.xpath(".//*[@id='email']")).getText();
		
		System.out.println("###" + actualTextToVerify2 + "###");
		System.out.println("###" + username + "###");
		String passFail2 = Modules.verifyText(actualTextToVerify2, username);
		System.out.println(passFail2 + "test case passed");
		
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		Thread.sleep(3000);
		String actualTextToVerify3 = driver.findElement(By.xpath(".//*[@id='password']")).getText();
		System.out.println(actualTextToVerify3);
		String passFail3 = Modules.verifyText(actualTextToVerify3, username);
		System.out.println(passFail3 + "test case passed");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(3000);
		
		String expString4 = Modules.getInputDataFromPropertiesFile(
				"EightSetProperties.xls", "EXPDATA4");
		String actualText4 = driver.getTitle();
		Thread.sleep(2000);
		String passFail4 = Modules.verifyText(actualText4, expString4);
		System.out.println(passFail4 + " dashboard page verified");
		
		//clicking on self button on leftside corner of Xero dashboard page
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2")).click();
		
		//clicking on my Xero button
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a")).click();
		
		Thread.sleep(4000);
		//clicking on add organizations button
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		
		Thread.sleep(2000);
		//entering the name of the organization
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("self");
		
		Thread.sleep(2000);
		//entering US in organization paying taxes tab
		driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']")).sendKeys("US");
		
		//entering time zone as pst
		//x-boundlist-item x-boundlist-item-over
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		
		//selecting the timezone - method 1
		String text = "(UTC-08:00) Pacific Time (US & Canada)";
		WebElement el = driver.findElement(By.xpath("//div[@id = 'cmbTimeZone-boundlist']/descendant::li[text() = '" + text + "']"));
		el.click();
		
		//entering against what does your organizatin do
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Flight Training");
		Thread.sleep(2000);
		
		/*driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		String text1 = "Xero";
		WebElement el1 = driver.findElement(By.xpath("//div[@id = 'ext-gen1119']/descendant::li[text1() = '" + text1 + "']"));
		el1.click();
		System.out.println(text1);
		*/
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
		
		//clicking buy now button
		
		
		
		
		
		//Modules.closeBrowser(driver);
	}

}
