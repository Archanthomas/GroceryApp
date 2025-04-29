package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int row, int column,String sheet) throws IOException
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s =w.getSheet(sheet); //method to get excel sheet from file.
		XSSFRow r = s.getRow(row); // declare row
		XSSFCell c = r.getCell(column); // declare cell.
		return c.getStringCellValue(); // to return cell value. 
	}
	
	//method to get integer data from excel file.
	public static String getIntegerData(int row, int column, String sheet) throws IOException
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s =w.getSheet(sheet); //method to get excel sheet from file.
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(column);
		int x = (int) c.getNumericCellValue(); // to get integer data from cell.
		return String.valueOf(x); // to convert integer to string.
	}

}
