package com.saag.HybridTestCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saag.TestBase.Base;
import com.saag.TestBase.ClsEbay;
import com.saag.TestBase.ClsTestData;

public class HybridEbayProdSearchTest extends Base
{
	  @Test(dataProvider = "ebayData")
	  public void prodSearch(String cat,String prod)
	  {
		  ClsEbay obj=new ClsEbay(driver);
		  obj.fnProdSearch(prod);
		  
		  Reporter.log("'" + prod + "' product search test is Successful...",true);
	  }

	  @DataProvider
	  public Object[][] ebayData() throws Exception
	  {
		  Object[][] myData=ClsTestData.getExcelData(".\\src\\test\\resources\\Excel\\DDFEbayInput.xlsx");
		  return myData;
	  }
}
