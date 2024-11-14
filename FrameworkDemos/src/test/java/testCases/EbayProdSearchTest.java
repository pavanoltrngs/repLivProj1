package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EbayProdSearchTest 
{
  @Test
  public void prodSeach() 
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  
	  WebElement txt=driver.findElement(By.id("gh-ac"));
	  txt.clear();
	  txt.sendKeys("Sony");
	  
	  driver.findElement(By.id("gh-btn")).click();
	  
	  Reporter.log("Ebay Product Search Test is Successful...",true);
  }
}
