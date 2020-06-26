package learnExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPOI {
	
	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook wbook = new XSSFWorkbook("C://Selenium//LearnAutomation//data//Data.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);
		
		
		
	}
	
	

}
