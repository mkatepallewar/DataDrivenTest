package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenShotFile;
	public static String screenShotName;
	public static void captureScreeShot() throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName="TestSuite";
		int rows=excel.getRowCount(sheetName);
		for (int rNum=2; rNum<=rows; rNum++) {
			String testcase=excel.getCellData(sheetName, "TCID", rNum);
			if (testcase.equalsIgnoreCase(testName)) {
				String runmode=excel.getCellData(sheetName, "Runmode", rNum);
				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		String SheetName=m.getName();
		int rows=excel.getRowCount(SheetName);
		int cols=excel.getColumnCount(SheetName);
		
		
		Object[][] data= new Object [rows-1][1];
		
		Hashtable<String, String> table=null;
		
		for (int rowNum=2;rowNum<=rows;rowNum++) {
			table=new Hashtable<String, String>();
			
			for (int colNum=0;colNum<cols;colNum++) {
				table.put(excel.getCellData(SheetName, colNum, 1), excel.getCellData(SheetName, colNum, rowNum));
				data[rowNum-2][0]=table;
			}
		}
		return data;
		
	}
}
