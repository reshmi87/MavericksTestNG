package PageObjects;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commons.BrowserFactory;
import Commons.LoggerLoad;

public class Registerpf {
	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;
	
	@FindBy (linkText="Register") WebElement register;
	@FindBy (id="id_username") WebElement usrname;
	@FindBy (id="id_password1") WebElement password;
	@FindBy (id="id_password2") WebElement confirmpassword;
	@FindBy (xpath="//input[@type='submit']") WebElement registerbutton;
	@FindBy (xpath="//div[contains(text(),'New Account Created')]") WebElement successmessage;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement errormessage;

	@FindBy (linkText="Sign out") WebElement signout;
	
	
	public void registerpage() {
		PageFactory.initElements(driver,this);
		register.click();
	}
	
	public String checkpageTitle() {
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	
	public void username(String uname) {
		usrname.sendKeys(uname);
	}
	
	public void password1(String pwd1) {
		password.sendKeys(pwd1);
		}
	
	public void password2(String pwd2) {
		confirmpassword.sendKeys(pwd2);
	}
	
	public void registerbutton() {
		registerbutton.click();
	}
	
	public String getsuccessmessage() {
		String successmsg = successmessage.getText();
		return successmsg;
	}
	
	public String generateuser(String uname) {
		Random rand = new Random();
		int randnum = rand.nextInt(1000);
		String newuname=uname+randnum;
		return newuname;
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
	
	public String emptyconfirmpasswordvalidation() {
		String message=null;
		message=confirmpassword.getAttribute("validationMessage");
		LoggerLoad.info(message);
		return message;
	}
	
	public void clearfields() {
		usrname.clear();
		password.clear();
		confirmpassword.clear();
	}
	
	public void signout() {
		signout.click();
	}
	
	public void closebrowser() {
		 driver.quit();
	    }
}