package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement Loginbutton;
	
//	private By usernameTextbox = By.id("Email");
//	private By passwordTextbox = By.id("Password");
//	private By Loginbutton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void enterusername(String username) {
		
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);
//		driver.findElement(usernameTextbox).clear();
//		driver.findElement(usernameTextbox).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
//		driver.findElement(passwordTextbox).clear();
//		driver.findElement(passwordTextbox).sendKeys(password);
	}
	
	public void loginbutton() {
		
		Loginbutton.click();
//		driver.findElement(Loginbutton).click();
	}

}
