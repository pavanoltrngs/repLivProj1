package com.saag.TestBase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class Base
{ 
	public static WebDriver driver;
	public static Properties pConfig=new Properties();
	public static Properties pOR=new Properties();
	public static FileInputStream fis;
	
  @BeforeSuite
  public void startUp() throws Exception
  {
	  fis=new FileInputStream(".\\src\\test\\resources\\Properties\\config.properties");
	  pConfig.load(fis);
	  
	  fis=new FileInputStream(".\\src\\test\\resources\\Properties\\OR.properties");
	  pOR.load(fis);
	  
	  String bName=pConfig.getProperty("browser");
	  if(bName.equalsIgnoreCase("Chrome"))
		  driver=new ChromeDriver();
	  else if(bName.equalsIgnoreCase("Firefox"))
		  driver=new FirefoxDriver();
	  else if(bName.equalsIgnoreCase("Edge"))
		  driver=new EdgeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get(pConfig.getProperty("siteUrl"));
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(pConfig.getProperty("timeout"))));
		
  }

  @AfterSuite
  public void afterSuite() {
  }

}
