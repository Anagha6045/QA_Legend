package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility 
{
 public static XSSFWorkbook wb;
 public static XSSFSheet sh;
 public static FileInputStream f;
 ExcelUtility excel_utility;
 
 public String getString(int i, int j, String filePath,String sheet) throws IOException
 {
	 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
	 wb = new XSSFWorkbook(f);
	 sh = wb.getSheet(sheet);
	 Row r= sh.getRow(i);
	 org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
	 return c.getStringCellValue();
	 
 }
 
 public String getNumeric(int i, int j, String filePath,String sheet) throws IOException
 {
	 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
	 wb = new XSSFWorkbook(f);
	 sh = wb.getSheet(sheet);
	 Row r= sh.getRow(i);
	 org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
	 int value = (int) c.getNumericCellValue();
	 return String.valueOf(value);
	 
 }
 
 public  ArrayList<String> getString(String filePath,String sheet) throws IOException
 {
	 f =new FileInputStream(System.getProperty("user.dir")+ filePath);
	 wb = new XSSFWorkbook(f);
	 sh = wb.getSheet(sheet);
	 ArrayList<String> excelRows= new ArrayList<>();
	 int rowCount=sh.getLastRowNum()-sh.getFirstRowNum();
	 
	 for(int i=0;i<=rowCount;i++)
	 {
		 Row row=sh.getRow(i);
		 int cellCount=row.getLastCellNum();
		 
		 for(int j=0;j<cellCount;j++)
		 {
			 excelRows.add(row.getCell(j).getStringCellValue());
		 }
	 }
	return excelRows;
 }
 
 public int getRowCount(String excelFilePath, String sheet) throws IOException {
      f =new FileInputStream(System.getProperty("user.dir")+ excelFilePath);
    	 wb = new XSSFWorkbook(f);
    	 sh = wb.getSheet(sheet);
         return sh.getPhysicalNumberOfRows();
     
 }
}