package utility;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFile;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			
			String cur_dir = System.getProperty("user.dir");
			reportFile = cur_dir+"//reports//"+fileName;
			
			extent = new ExtentReports(reportFile, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(cur_dir+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
	
	public static String getReportFile() {
		return reportFile;
	}
}
