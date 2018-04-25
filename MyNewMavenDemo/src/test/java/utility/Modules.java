package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.FirstSetOfTests;


public class Modules {
	public static HSSFWorkbook wb;
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String name, String url) throws InterruptedException{
		System.out.println("Launching Browser");
		
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:/chari/binaries/geckodriver-v0.15.0-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","C:/chari/binaries/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("IE")){
			System.out.println("IE entered");
			System.setProperty("webdriver.ie.driver","C:/chari/binaries/IEDriverServer_x64_3.11.1/IEDriverServer.exe");
			driver=new ChromeDriver();
		}
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(5000);
		
		return driver;
	}
	
	/*public static WebDriver loginPageVerify(WebDriver driver, String title) throws InterruptedException{
		String applicationTitle = driver.getTitle();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("sunitha_pen@yahoo.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("ptanmayee1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		
		if(applicationTitle.contains("title")){
			System.out.println("login is successfully");
		}else{
			System.out.println("login is not successfully");
		}
		return driver;
	}*/

	public static void closeBrowser(WebDriver driver){
		try{
			driver.quit();
		}
		catch(Exception e){
			
		}
	}
	
	public static WebDriver Login_toXero(WebDriver driver) throws InterruptedException{
		System.out.println("Inside Login_toXero - one parameter");
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("sunitha_pen@yahoo.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("ptanmayee1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		return driver;
	}
	
	public static WebDriver Login_toXero(WebDriver driver,String id,String password) throws InterruptedException{
		System.out.println("Inside Login_toXero - three parameter");
		
		//clicking on login button
		//driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(id);
		
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		return driver;
	}
	
	public static WebDriver logOut_fromXero(WebDriver driver) throws InterruptedException{
		
		//clicking on the username button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a")).click();
		
		//clicking on logout button
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a")).click();
		System.out.println("logged out successfully");
		return driver;
	}
	
	public static WebDriver ProfileButton(WebDriver driver) throws InterruptedException, IOException{
		
		//clicking on the username button
		
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a")).click();
		
		//clicking on profile button
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[1]/a")).click();
		System.out.println("clicked on profile button successfully");
		Thread.sleep(5000);
		
		//clicking on upload image button
		driver.findElement(By.xpath(".//*[@id='button-1041-btnInnerEl']")).click();
		Thread.sleep(5000);
		
		//clicking on browse button
		//driver.findElement(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']")).click();
		//driver.findElement(By.xpath(".//*[@id='filefield-1174-browseButtonWrap']")).click();
		//Thread.sleep(5000);
		
		//chari
		//WebElement El = driver.findElement(By.id("filefield-1174-button-fileInputEl"));
		//El.sendKeys("c:\\temp\\Capture.jpg");
		
		
		
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath(".//*[@id='filefield-1174-browseButtonWrap']")).click();
//		
//		Alert salert = driver.switchTo().alert();
//		String atext = salert.getText();
//		System.out.println("Alert text is " + atext);
//		salert.accept();
		
		//driver.findElement(By.xpath(".//*[@id='filefield-1174-browseButtonWrap']")).click(); Thread.sleep(2000);
		//driver.switchTo().activeElement().sendKeys("c:\\temp\\Capture.jpg");
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//techbeamers.com
		//String filepath = "C:/temp/Capture.jpg";
		//driver.get(filepath);
		//WebElement fileInput = driver.findElement(By.name("uploadfile"));
		//fileInput.sendKeys(filepath);
		
		//techbeamers.com
		
		String workingDir = System.getProperty("user.dir");
		String autoitscriptpath = workingDir + "\\File_Upload_selenium_webdriver.au";
		String filepath = workingDir + "\\Capture.jpg";
		
		Thread.sleep(2000);
		driver.findElement(By.id("filefield-1174-button")).click();
		Runtime.getRuntime().exec("cmd.exe /c Start AutoIt3.exe " + autoitscriptpath + " \"" + filepath + "\"");	
		Thread.sleep(5000);
		
		//clicking on the upload image button after uploading the image
		driver.findElement(By.xpath(".//*[@id='button-1178-btnWrap']")).click();
		Thread.sleep(5000);
		
		return driver;
		
		
			
	
}
		
		

		 
		/*String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				
				//clicking on browse button
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']")).click();
				Thread.sleep(5000);
				
				 //WebElement UploadImg = driver.findElement(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']"));
				 //Thread.sleep(5000);
				 
				 //UploadImg.click();
				
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		 
		 
		 
		 
		 
		  
		  driver.switchTo().alert().sendKeys("C:/Users/lpaidakula/Pictures");
		
		return driver;
	}*/
	
	public static String[][] readXlSheet(String link,String sheetName) throws IOException{
		System.out.println("Inside readXlSheet");
		
		FileInputStream fio=new FileInputStream(new File(link));
		wb=new HSSFWorkbook(fio);
		HSSFSheet sheet=wb.getSheet(sheetName);
		int trow=sheet.getLastRowNum()+1;
		int tcol=sheet.getRow(0).getLastCellNum();
		String[][] s = new String[trow][tcol];
		//System.out.println("total rows="+trow+" and total column="+tcol);
		for(int i=0;i<trow;i++){
			for(int j=0;j<tcol;j++){
				//System.out.println("row # = " + i + "        column # = " + j);
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC)
					s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
				else
					s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return s;
	}
	
//	public static WebDriver selectItemFromUserMenu(WebDriver driver,String name){
//		driver.findElement(By.xpath("//*[@id='userNav-arrow']")).click();
//		List<WebElement> list=driver.findElements(By.xpath("//*[@id='userNav-menuItems']/a"));
//		for(WebElement ele:list){
//			if(ele.getText().equalsIgnoreCase(name))
//				ele.click();
//		}
//		return driver;
//	}
	
	public static String CaptureScreen(WebDriver driver,String name) throws IOException{
		System.out.println("Inside CaptureScreen");
		
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest="./Screenshots/"+name+".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
	}
	
	public static void FillBackGroundColor(int inpRow, String passFail) throws Exception{
		System.out.println("Inside FillBackGroundColor");
		
		String cur_dir = System.getProperty("user.dir");
		String suitePath = cur_dir + "/src/test/java/utility/XeroTestSuite.xls";
		
		FileInputStream fileInputStream = new FileInputStream(suitePath);
        HSSFWorkbook my_workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet my_sheet = my_workbook.getSheet("Sheet1");
        
        /* Create a row in the sheet */
        Row row = my_sheet.getRow(inpRow);
        /* Create a cell */
        Cell cell = row.getCell(3);
        
        
        /* Get access to HSSFCellStyle */
        HSSFCellStyle my_style = my_workbook.createCellStyle();
        /* We will now specify a background cell color */
        my_style.setFillPattern(HSSFCellStyle.THICK_BACKWARD_DIAG );
        //my_style.setFillForegroundColor(new HSSFColor.BLUE().getIndex());
        if(passFail.contains("pass"))
        {
        	my_style.setFillBackgroundColor(new HSSFColor.GREEN().getIndex());
        	cell.setCellValue("pass");
        }
        else
        {
        	my_style.setFillBackgroundColor(new HSSFColor.RED().getIndex());
        	cell.setCellValue("fail");
        }
        
 
        //cell.setCellValue("This text will be in bold red color");
        /* Attach the style to the cell */
        cell.setCellStyle(my_style);	
        
        fileInputStream.close();
        
        //write the changes to the same file
        FileOutputStream out = new FileOutputStream(suitePath);
        my_workbook.write(out);
        out.close();	
	}

	
	public static void AddHyperLink(int inpRow) throws IOException {
		System.out.println("Inside AddHyperLink");
		
		String cur_dir = System.getProperty("user.dir");
		String suitePath = cur_dir + "/src/test/java/utility/XeroTestSuite.xls";

		FileInputStream fileInputStream = new FileInputStream(suitePath);
		HSSFWorkbook my_workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet my_sheet = my_workbook.getSheet("Sheet1");

		/* Let us create some HSSFHyperlink objects */
		HSSFHyperlink url_link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);

		/* Define the data for these hyperlinks */
		url_link.setAddress(ExtentManager.getReportFile());
		// file_link.setAddress("file:///c://test.csv");
		// email_link.setAddress("mailto:test@gmail.com");

		/* Attach these links to cells */
        /* Create a row in the sheet */
        Row row = my_sheet.getRow(inpRow);
        /* Create a cell */
        Cell cell = row.getCell(3);
		cell.setHyperlink(url_link);

		// row = my_sheet.createRow(1);
		// cell = row.createCell(1);
		// cell.setCellValue("Click to Open the file");
		// cell.setHyperlink(file_link);
		//
		// row = my_sheet.createRow(2);
		// cell = row.createCell(2);
		// cell.setCellValue("Send an Email");
		// cell.setHyperlink(email_link);

        fileInputStream.close();
        
        //write the changes to the same file
        FileOutputStream out = new FileOutputStream(suitePath);
        my_workbook.write(out);
        out.close();	
	}
	
	
	public static String verifyChildWindowTitle(WebDriver driver, String verifyTitle)
	{
		System.out.println("Inside verifyChildWindowTitle");
		
		String verify = "";
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				
				String applicationTitle=driver.getTitle();
				System.out.println("Child window Title = " + applicationTitle);
				if(applicationTitle.contains(verifyTitle)) {
					System.out.println("Child window title \"" + verifyTitle + "\" verified");
					verify = "pass";
				} else {
					System.out.println("Child window title \"" + verifyTitle + "\" NOT verified");
					verify = "fail";
				}
				
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		
		return verify;
	}
	
	public static String verifyText(String applicationText, String expText){
		System.out.println("Inside verifyText() - Expected text to verify is : " + expText);
		
		String verify;
		if(applicationText.contains(expText)){
			System.out.println(applicationText + " - is verified ");
			verify = "pass";
		}else{
			System.out.println(applicationText + " - is not verified ");
			verify = "fail";
		}
		
		return verify;
	}
	
	public static void XLUpdate(int inpRow, String passFail) throws Exception
	{
		System.out.println("Changing background color in Excel");
		FillBackGroundColor(inpRow, passFail);
		
		System.out.println("Adding hyperlink in Excel");
		AddHyperLink(inpRow);
	}
	
	public static String getInputDataFromPropertiesFile(String xlFile, String dataType) throws IOException
	{
		String cur_dir = System.getProperty("user.dir");
		String suitePath = cur_dir + "/" + xlFile;
		String[][] recData = Modules.readXlSheet(suitePath, "Sheet1");
		
		for (int i = 0; i < recData.length; i++) {
			String key = recData[i][0];
			String value = recData[i][1];
			if(key.equalsIgnoreCase(dataType)){
				return value;
			}
		}
		return null;
	}
	
}
