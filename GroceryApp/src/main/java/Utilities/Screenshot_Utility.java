package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Screenshot_Utility {
	
	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;  //interface to take screenshot.
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  // screenshot will got saved into temporary path.
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// to generate current time stamp.
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");   

		if (!f1.exists()) {
			f1.mkdirs();    //mkdir --> will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp
				+ ".png";//destination screenshot format.
		File finalDestination = new File(destination);//final destination
		FileHandler.copy(screenShot, finalDestination);	//copy the screenshot from temporary path to project folder.

	}

}

