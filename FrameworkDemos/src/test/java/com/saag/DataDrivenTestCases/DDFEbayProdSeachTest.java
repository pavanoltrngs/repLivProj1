package com.saag.DataDrivenTestCases;

import org.testng.annotations.Test;

import com.saag.TestBase.Base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFEbayProdSeachTest extends Base
{
  @Test(dataProvider = "ebayData")
  public void prodSearch(String cat,String prod)
  {
	  WebElement txt= driver.findElement(By.id(pOR.getProperty("txtSearch")));
	  txt.clear();
	  txt.sendKeys(prod);
	  driver.findElement(By.id(pOR.getProperty("btnSearch"))).click();
	  
	  Reporter.log("'" + prod + "' product search test is Successful...",true);
  }

  @DataProvider
  public Object[][] ebayData() throws Exception
  {
	  Object[][] myData=null;
	  XSSFWorkbook wb=new XSSFWorkbook(".\\src\\test\\resources\\Excel\\DDFEbayInput.xlsx");
	  XSSFSheet ws=wb.getSheet("Sheet1");
	  int rows=ws.getPhysicalNumberOfRows();
	  myData=new Object[rows-1][2];
	  
	  for(int i=1;i<rows;i++)
	  {
		  myData[i-1][0]=ws.getRow(i).getCell(0).getStringCellValue();
		  myData[i-1][1]=ws.getRow(i).getCell(1).getStringCellValue();
	  }
	  return myData;
  }
}















