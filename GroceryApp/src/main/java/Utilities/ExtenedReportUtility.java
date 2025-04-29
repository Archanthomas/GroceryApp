package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenedReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();   
	public synchronized static ExtentReports createExtentReports() //method to create extend report.
	{    

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //ExtentSparkReporter it is class which handles the creation and configuration of an html report. 
		
		reporter.config().setReportName("Grocery Application");  
		extentReports.attachReporter(reporter);   
		extentReports.setSystemInfo("Organization", "Obsqura");  //add system level informations to the report.
		extentReports.setSystemInfo("Name", "Archana Thomas");
		return extentReports;   //returns the report.
	}

}
