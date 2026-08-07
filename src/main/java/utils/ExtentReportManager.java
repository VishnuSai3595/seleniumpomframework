package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	private static ExtentTest test;
	public static String reportpath;
	
	public static ExtentReports getReportInstance() {
		
		if (extent==null) {
			
			String timestamp = new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss").format(new Date());
			reportpath = ("reports/ExtentReport"+ timestamp + ".html");
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			
			reporter.config().setDocumentTitle("Automation Report");
			reporter.config().setReportName("Execution report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			
		}
		
		return extent;
	}
	
	public static ExtentTest createtest(String testname) {
		
		test = getReportInstance().createTest(testname);
		
		
		return test;
	}



	public static String capturescreenshot(WebDriver driver,String screenshotname) {
		
		try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/screenshots/"+screenshotname+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
		
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	
	}
	}
	
	
}
