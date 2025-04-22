package Genric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book = WorkbookFactory.create(fis1);
		Sheet SHEET = Book.getSheet(sheetName);
		Row ROW = SHEET.getRow(rownum);
		Cell CELL = ROW.getCell(cellnum);
		String Exceldata = CELL.getStringCellValue();
	
		return Exceldata;
		
	}
	
	public String getExcelDataformatter(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book = WorkbookFactory.create(fis1);
		DataFormatter format=new DataFormatter();
		String Exceldata = format.formatCellValue(Book.getSheet(sheetName).getRow(rownum).getCell(cellnum));
		return Exceldata;
		
	}
	
	public Object[][] readMultipleData(String sheetname) throws Throwable{
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet(sheetname);
		//int lastRow = sheet.getLastRowNum()+1;
		int lastRow = sheet.getPhysicalNumberOfRows();
		System.out.println(lastRow);
		int lastCell=sheet.getRow(0).getLastCellNum();
		System.out.println(lastCell);
		
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
		
	}
 
}
