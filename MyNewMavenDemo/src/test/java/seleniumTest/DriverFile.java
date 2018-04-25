package seleniumTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utility.Modules;

public class DriverFile {

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		String cur_dir = System.getProperty("user.dir");
		System.out.println("user.dir = " + cur_dir);
		String suitePath = cur_dir + "/src/test/java/utility/XeroTestSuite.xls";
		String[][] recData = Modules.readXlSheet(suitePath, "Sheet1");
		String testCase,flag,firefoxStatus;
		
		for (int i = 1; i < recData.length; i++) {
			testCase = recData[i][0];
			flag = recData[i][1];
			if(flag.equalsIgnoreCase("y")){
				firefoxStatus=recData[i][2];
				if(firefoxStatus.equalsIgnoreCase("y")){
					Method tc = FirstSetOfTests.class.getMethod(testCase);
					tc.invoke(tc);
				}
			}
		}
	}

}
