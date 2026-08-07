package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtils;
import utils.ExtentReportManager;
import utils.log;



public class Basetest {
	
	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	
	public void teardownReport() {
		extent.flush();
		String reportpath =ExtentReportManager.reportpath;
		EmailUtils.sendTestReport(reportpath);
	}
	
	
	
	@BeforeMethod
	public void setup() {
		log.info("opening driver.....");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		log.info("opening website......");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotpath = ExtentReportManager.capturescreenshot(driver, "LoginFailure");
			test.fail("Test failed check screenshot...", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		
		if(driver!=null) {
			log.info("closing website....");
			driver.close();
		}
	}

}
