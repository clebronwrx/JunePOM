package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class TestUtil extends TestBase{
	
	 private static Workbook book;
	 private static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file =null;
		try {
		 file = new FileInputStream("/Users/chrislebron/eclipse-workspace/June20POMFramework/src/main/java/testdata/Commercial Tab OptionNTitles Test Data .xlsx");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
	}
	
	public static void screenshot(WebDriver driver,String name) throws Exception {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File shot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destination = currentDir + "/screenshot/"+date+".png";
		FileUtils.copyFile(shot, new File(destination));
	
	}
	
	
	
	
	
	

}
