package com.saag.POMTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saag.TestBase.Base;
import com.saag.TestBase.ClsEbay;

public class POMEbayProdSearchTest extends Base
{
  @Test
  public void prodSearch() 
  {
	  ClsEbay obj=new ClsEbay(driver);
	  obj.fnProdSearch("Sony");
	  
	  Reporter.log("Ebay Product Search Test is Successful...",true);
  }
}
