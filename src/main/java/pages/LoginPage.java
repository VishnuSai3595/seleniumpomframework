package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By usernameTextbox = By.id("Email");
	private By passwordTextbox = By.id("Password");
	private By Loginbutton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	public void enterusername(String username) {
		
		driver.findElement(usernameTextbox).clear();
		driver.findElement(usernameTextbox).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys(password);
	}
	
	public void loginbutton() {
		driver.findElement(Loginbutton).click();
	}

}
