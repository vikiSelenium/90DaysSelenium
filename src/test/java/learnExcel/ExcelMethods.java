package learnExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMethods {

	public static void main(String[] args) throws Exception {
		XSSFWorkbook wbook = new XSSFWorkbook("C://Selenium//LearnAutomation//data//Data.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		//System.out.println(rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		String value = sheet.getRow(0).getCell(1).getStringCellValue();
		//System.out.println(value);
		for(int i=0; i<=rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for (int j =0; j<colCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.println(data);
			}
		}	
		

	}

}
