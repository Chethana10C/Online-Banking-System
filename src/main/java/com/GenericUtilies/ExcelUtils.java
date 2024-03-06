package com.GenericUtilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import net.bytebuddy.asm.Advice.Return;

public class ExcelUtils {
	/**
	 * This methos is used to read the data from the excel 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
			// get last row count
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
		public int getLastRowNo(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
		 // write data into excel
	/**
	 * This method is used to write the data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
		public void writeDataIntoExcel(String sheetName, int row, int cell, String value) throws Throwable 
		{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
			
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
		}
		
		/**
		 * This method used to read data from excel by using Hashmap
		 * @param sheetName
		 * @param row
		 * @param driver
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public HashMap<String, String> readMultipleData(String sheetName, int row) throws EncryptedDocumentException, IOException
		{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		for(int i =0; i<=rowCount ;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			
			map.put(key, value);
		}
		 return map;
		}
	
		
		
	//@DataProvider
	public Object[][] genericDP(String sheetName) throws Throwable, IOException
	{
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);	
			int LastRow = sh.getLastRowNum()+1;
			int LastCell = sh.getRow(0).getLastCellNum();
			Object [][]  obj = new Object[LastRow][LastCell]; // EMPTY OBJECT ARRAY
			   
			   for (int i=0; i<LastRow;i++)
			   {
				  for(int j=0; j<LastCell;j++)
				  {
					   obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				  }
			   }
					 return obj; 
			
			
			
			
	}
		
}



