package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.close();
		}
	}

}
