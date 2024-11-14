package com.saag.POMTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saag.TestBase.Base;
import com.saag.TestBase.ClsEbay;

public class POMEbayProdCatSearchTest extends Base
{
  @Test
  public void catSearch() 
  {
	  ClsEbay obj=new ClsEbay(driver);
	  obj.fnProdCatSearch("Cameras & Photo", "Sony");
	  
	  Reporter.log("Ebay Product Search in a category Test is Successful...",true);
  }
}
