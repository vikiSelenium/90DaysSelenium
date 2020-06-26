package learnExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public static void main(String[] args) throws Exception {
		XSSFWorkbook wbook = new XSSFWorkbook("C://Selenium//LearnAutomation//data//Data.xlsx"); 
		XSSFSheet sheet = wbook.getSheetAt(0);
    //	XSSFRow row = sheet.getRow(0);
//		String data = row.getCell(1).getStringCellValue();
//		System.out.println(data);
		int totalRows = sheet.getLastRowNum();
		System.out.println(totalRows);
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i =0; i<=totalRows; i++)	
		{
			XSSFRow row = sheet.getRow(i);
			
		for( int j =0; j<colcount; j++) {
			XSSFCell cell = row.getCell(j);
			String data = cell.getStringCellValue();
			
			System.out.println(data);
		}
		}
		
		

	}

}
