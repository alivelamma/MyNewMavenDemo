package seleniumTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import utility.Modules;

public class TenthSetOfTests {

	public static WebDriver driver;

	@Test(enabled = false)
	public static void purchasesFromAccounts() throws InterruptedException, IOException {

		String browser = Modules.getInputDataFromPropertiesFile(
				"TenthSetProperties.xls", "BROWSER");
		String url = Modules.getInputDataFromPropertiesFile(
				"TenthSetProperties.xls", "URL");

		driver = Modules.launchBrowser(browser, url);
		Thread.sleep(10000);
		driver = Modules.Login_toXero(driver, "sunitha_pen@yahoo.com",
				"ptanmayee1");

		String expString = Modules.getInputDataFromPropertiesFile(
				"TenthSetProperties.xls", "EXPDATA1");
		String actualText = driver.getTitle();
		Thread.sleep(2000);
		String passFail = Modules.verifyText(actualText, expString);

		
		// driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[1]/a]")).click();
		
		Thread.sleep(5000);

		expString = Modules.getInputDataFromPropertiesFile(
				"TenthSetProperties.xls", "EXPDATA2");
		actualText = driver.getTitle();
		Thread.sleep(2000);
		System.out.println("click login");
		
		//clicking on the accounts button
			driver.findElement(By.xpath(".//*[@id='Accounts']")).click();
				
			//clicking on purchases button
			Thread.sleep(5000);
			
			String[] options = new String[] {"Bank Accounts", "Sales","Purchases","Checks", "Inventory", "Expense Claims", "Fixed Asserts"}; 
			List<String> expList = new ArrayList<String>(Arrays.asList(options));
			
			List<WebElement> list = driver.findElements(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[2]/div/ul/li"));//xpath for multiple elements
			ArrayList<String> actData = new ArrayList<String>(); 
			for(WebElement ele : list){
				actData.add(ele.getText()); 
			} System.out.println(actData);
				  
				  if(expList.equals(actData)) System.out.println("usermenu verified"); else
				  System.out.println("usermenu not verified");
				  
				  //clicking on paid button
				  driver.findElement(By.xpath(".//*[@id='ext-gen1018']/div[3]/div/div/div[4]/div[1]/ul/li[2]")).click();
				  driver.close();
			
	}
}
