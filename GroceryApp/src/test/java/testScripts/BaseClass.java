package testScripts;

import org.testng.annotations.Test;

import Utilities.Screenshot_Utility;
import constants.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
FileInputStream file;
Properties properties;
	public WebDriver driver;
  
  @BeforeMethod(alwaysRun=true)
  @Parameters("browser")
  public void intializeBrowserMethod(@Optional("Chrome")String browser) throws Exception {
	  properties= new Properties();
	  file= new FileInputStream(Constants.CONFIGFILE);
	  properties.load(file);//reads the configration file and loads it's properties in to the properties object.
	  if(browser.equalsIgnoreCase("Chrome")) {
		  driver = new ChromeDriver();  
	  }
	  else if(browser.equalsIgnoreCase("Edge")){
		  
		driver = new EdgeDriver();  
	  }
	  else if(browser.equalsIgnoreCase("Firefox")){
		  
			driver = new FirefoxDriver();  
		  }
	  else {
		  throw new Exception("Invalid browser");
	  }
	  driver.get(properties.getProperty("url"));
	 // driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod(ITestResult itestresult) throws IOException//ITestResult is an interface.
  {
	 if(itestresult.getStatus()==ITestResult.FAILURE) 
	 {
		 Screenshot_Utility screenshot = new Screenshot_Utility();
		 screenshot.getScreenshot(driver,itestresult.getName());
	 }
	 // driver.quit();
  }

}
