package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Basetest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class logintest extends Basetest {
	
//	@DataProvider(name="login test")
	public Object[][] getlogindata() throws IOException{
		
		String filepath = System.getProperty("user.dir")+"/test data/datadriven.xlsx";
		String sheetname = "sheet1";
		ExcelUtils.loadexcel(filepath, sheetname);
		int rowcount = ExcelUtils.getrowcount();
		Object[][] data = new Object[rowcount-1][2];
		for (int i=1; i<rowcount;i++) {
			data[i-1][0]=ExcelUtils.getcellData(i, 0);
			data[i-1][1]=ExcelUtils.getcellData(i, 1);
		ExcelUtils.closeexcel();
			
		}
		
		return data;
	}
	
//	@DataProvider(name = "login test1")
	
	public Object[][] getData(){
		
		return new Object[][] {
			
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}
	
	
	
//	@Test(dataProvider  ="login test1")
	
//	@Test 
//	@Parameters({"username","password"})
//	(String username, String password)
	
	@Test
	public void validlogintest() {
		test = ExtentReportManager.createtest("Valid Login test");
		test.info("Navigating to URL....");
		LoginPage loginpage = new LoginPage(driver);
		test.info("entering credentials..");
//		loginpage.enterusername(username);
//		loginpage.enterpassword(password);
		loginpage.enterusername("admin@yourstore.com");
		loginpage.enterpassword("admin");
		loginpage.loginbutton();
		test.pass("login succesfull");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		System.out.println("the title : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
	}
	@Test
	public void Invalidlogintest() {
		test = ExtentReportManager.createtest("InValid Login test");
		test.info("Navigating to URL....");
		LoginPage loginpage = new LoginPage(driver);
		test.info("entering credentials..");
		loginpage.enterusername("admin@yourstore.com");
		loginpage.enterpassword("admin123");
		loginpage.loginbutton();
		test.pass("login succesfull");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		System.out.println("the title : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
		
		
	}
	
	

}
