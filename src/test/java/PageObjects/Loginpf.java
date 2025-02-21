package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;
import Commons.LoggerLoad;

public class Loginpf {
	WebDriver driver = BrowserFactory.getdriverinstance();
	
	
	@FindBy (linkText="Sign in") WebElement signin;
	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//input[@type='submit']") WebElement login;
	

	public void login(String uname, String pwd) {
		PageFactory.initElements(driver,this);
		signin.click();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
	}

}
