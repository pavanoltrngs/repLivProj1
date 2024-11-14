package com.saag.DataDrivenTestCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saag.TestBase.Base;

public class DDFEbayProdCatSearchTest extends Base
{
	@Test(dataProvider = "ebayData")
	  public void catSearch(String cat,String prod)
	  {
		  WebElement dd=driver.findElement(By.id(pOR.getProperty("ddCat")));
		  Select s=new Select(dd);
		  s.selectByVisibleText(cat);
		
		  WebElement txt= driver.findElement(By.id(pOR.getProperty("txtSearch")));
		  txt.clear();
		  txt.sendKeys(prod);
		  driver.findElement(By.id(pOR.getProperty("btnSearch"))).click();
		  
		  Reporter.log("'" + prod + "' product search in '" + cat + "' Category test is Successful...",true);
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
