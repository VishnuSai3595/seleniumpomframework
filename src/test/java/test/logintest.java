package test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.LoginPage;

public class logintest extends Basetest {
	
	@Test
	
	public void validlogintest() {
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterusername("admin@yourstore.com");
		loginpage.enterpassword("admin");
		loginpage.loginbutton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		System.out.println("the title : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		
	}
	
	

}
