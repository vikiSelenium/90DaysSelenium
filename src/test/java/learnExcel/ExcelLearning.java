package learnExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelLearning {

	
	@DataProvider(name ="testdata")
	public static Object[][] readExcel() throws Exception {
		XSSFWorkbook wbook = new XSSFWorkbook("C://Selenium//LearnAutomation//data//Data.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
//		String value = sheet.getRow(0).getCell(0).getStringCellValue();
//		System.out.println(value);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rowCount + colCount);
		Object[][] data = new Object[rowCount][colCount];
		for(int i=0; i<rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for (int j=0; j<colCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String output = cell.getStringCellValue();
				data[i][j] = output;
				System.out.println(output);
			}
		
		
		
		}
		return data;
	}
	@Test(dataProvider ="testdata")
	public void test(String UserName, String Password) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/v1/");
		driver.findElementByName("uid").sendKeys(UserName);
		driver.findElementByName("password").sendKeys(Password);
		
		
	}
}


	
	
	