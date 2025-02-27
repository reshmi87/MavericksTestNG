package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;
import Commons.LoggerLoad;

public class Loginpf {
	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;	
	
	@FindBy (linkText="Sign in") WebElement signin;
	@FindBy (linkText="Sign out") WebElement signout;
	@FindBy (name="username") WebElement usrname;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//input[@type='submit']") WebElement login;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement displaymessage;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement errormessage;
	@FindBy (linkText="Register!") WebElement Register;
	
	public void clicksignin() {
		PageFactory.initElements(driver,this);
		signin.click();
	}
	public String checkpageTitle() {
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	public void enterusername(String uname) {
		usrname.sendKeys(uname);
	}
	
	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickloginbutton() {
		login.click();
	}
	
	public void registerclick() {
		Register.click();
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	public void login(String uname, String pwd) {
		PageFactory.initElements(driver,this);
		signin.click();
		usrname.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
	}
	
	public void signout() {
		signout.click();
	}

	public String getsigninmessage() {
		String loggedinmessage = displaymessage.getText();
		return loggedinmessage;
	}
	
	public String getsignoutmessage() {
		String loggedoutmessage = displaymessage.getText();
		return loggedoutmessage;
	}
	
	public String geterrormessage() {
		String errormsg = errormessage.getText();
		return errormsg;
	}
	
	public String emptyusernamevalidation() {
		String message=null;
		message=usrname.getAttribute("validationMessage");
		LoggerLoad.info(message);
		return message;
	}
	
	public String emptypasswordvalidation() {
		String message=null;
		message=password.getAttribute("validationMessage");
		LoggerLoad.info(message);
		return message;
	}
	
	public void clearfields() {
		usrname.clear();
		password.clear();
	}
}
