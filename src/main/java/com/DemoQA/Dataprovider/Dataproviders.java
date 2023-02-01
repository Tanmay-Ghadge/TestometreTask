package com.DemoQA.Dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.DemoQA.Utility.ExcelLibrary;

public class Dataproviders extends ExcelLibrary
{ 

	@DataProvider(name = "dataforFirstName")
	public static Iterator<String> getFormTestData(Method method,ITestContext test) throws IOException, InterruptedException
	{

		ExcelLibrary readExcel=new ExcelLibrary();
		String path="C:\\Users\\tusha\\git\\repository\\Opencart\\src\\test\\resources\\Test Data\\TestData.xlsx";

		ArrayList list;
		String methodName=method.getName();	
		switch (methodName) 
		{
		case "firstNameValidationNegative":
		{ 
			String excelPath="D:\\tanmay\\AJ Automation\\Test Data2.xlsx";
			list=readExcelRow(excelPath, "Form Data","First name-Negative");
		};
		return list.iterator();

		case "firstNameValidationPositive":
		{ 
			String excelPath="D:\\tanmay\\AJ Automation\\Test Data2.xlsx";
			list=readExcelRow(excelPath, "Form Data","First name-Positive");
		};
		return list.iterator();

		case "lastNameValidationNegative":
		{ 
			String excelPath="D:\\tanmay\\AJ Automation\\Test Data2.xlsx";
			list=readExcelRow(excelPath, "Form Data","Last Name-Negative");
		};
		return list.iterator();

		case "lastNameValidationPositive":
		{ 
			String excelPath="D:\\tanmay\\AJ Automation\\Test Data2.xlsx";
			list=readExcelRow(excelPath, "Form Data","Last Name-positive");
		};
		return list.iterator();

		}
		return null;

		

	}
	}	