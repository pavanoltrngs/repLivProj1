package com.saag.TestBase;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClsTestData 
{
	public static Object[][] getExcelData(String fPath) throws Exception
	{
		  Object[][] myExcelData=null;
		  XSSFWorkbook wb=new XSSFWorkbook(fPath);
		  XSSFSheet ws=wb.getSheet("Sheet1");
		  int rows=ws.getPhysicalNumberOfRows();
		  myExcelData=new Object[rows-1][2];
		  
		  for(int i=1;i<rows;i++)
		  {
			  myExcelData[i-1][0]=ws.getRow(i).getCell(0).getStringCellValue();
			  myExcelData[i-1][1]=ws.getRow(i).getCell(1).getStringCellValue();
		  }
		  return myExcelData;
	}
}
