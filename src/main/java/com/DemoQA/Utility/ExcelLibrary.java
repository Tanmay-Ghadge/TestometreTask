package com.DemoQA.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLibrary 
{
	@Test
	public Object getCellValue(String workbookPath,String sheetName,int rowNumber,int columnNumber) throws IOException
	{

		File file=new File(workbookPath);
		FileInputStream inputStream=new FileInputStream(file);

		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=  sheet.getRow(rowNumber);
		XSSFCell cell= row.getCell(columnNumber);

		Object cellValue = null;

		switch(cell.getCellType())
		{
		case STRING:cellValue=cell.getStringCellValue();break;
		case NUMERIC:cellValue=cell.getNumericCellValue();break;
		case BOOLEAN:cellValue=cell.getBooleanCellValue();break;
		}

		workbook.close();

		return cellValue;
		
	}
	
	public ArrayList readExcelRow(String data) throws IOException
	{
		ArrayList <String> fieldData=new ArrayList<String>();
		String[] values=data.split(",");
		
		/*
		 * values[0]=excel file path
		 * values[1]=Sheet index
		 * values[2]=field name
		 */
		
	//converting String values into integer	
		String workbookPath=values[0];//excel file path
		int sheetNumber=Integer.valueOf(values[0]);//Sheet index
		
		File file=new File(workbookPath);
		FileInputStream inputStream=new FileInputStream(file);

		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(sheetNumber);

		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row= sheet.getRow(i);
			XSSFCell cell=row.getCell(0); // getting field value
			String cellValue=cell.getStringCellValue();
			
			if(cellValue.equals(values[2]))
			{
				for(int j=1;j<=row.getLastCellNum();i++)
				{
					String input=row.getCell(j).getStringCellValue();
					fieldData.add(input);
				}
				break;
			}
		}
		workbook.close();
		return fieldData;
		
	}
	
	public static ArrayList readExcelRow(String workbookPath1,String sheetName,String fieldName) throws IOException, InterruptedException
	{
		ArrayList <String> fieldData=new ArrayList<String>();
		
		/*
		 * values[0]=excel file path
		 * values[1]=Sheet index
		 * values[2]=field name
		 */
		
	//converting String values into integer	
		String workbookPath=workbookPath1;//excel file path
		
		File file=new File(workbookPath);
		FileInputStream inputStream=new FileInputStream(file);

		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheet(sheetName);

		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row= sheet.getRow(i);
			XSSFCell cell=row.getCell(0); // getting field value
			String cellValue=cell.getStringCellValue();
			String input;
			
			DataFormatter formatter=new DataFormatter();
			
			if(cellValue.equals(fieldName))
			{
				for(int j=1;j<row.getLastCellNum();j++)
				{
				 input=formatter.formatCellValue(row.getCell(j));
					fieldData.add(input);
				}
				break;
			}
		}
		workbook.close();
		Thread.sleep(3000);
		return fieldData;
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String excelPath="D:\\tanmay\\AJ Automation\\New folder (2)\\practice.xlsx";
		ArrayList list=readExcelRow(excelPath, "Data","field 4");
		
		System.out.println(list.get(7));
	}
}
