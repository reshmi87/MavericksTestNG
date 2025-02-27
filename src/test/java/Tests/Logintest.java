package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseclass;
import PageObjects.Loginpf;
import Commons.DataProviderClass;
import Commons.LoggerLoad;

public class Logintest extends baseclass{
	public baseclass base = new baseclass();
	Loginpf lpf;
	String pagetitle;
	WebDriver driver;
	
	@Test(priority=1)
	public void toLoginpage() {
		lpf=new Loginpf();
		lpf.clicksignin();
		pagetitle = lpf.checkpageTitle();
		LoggerLoad.info("Current page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Login", "Incorrect Page");
	}
	
	@Test(priority=2, dataProvider = "LoginValidcredentials", dataProviderClass = DataProviderClass.class)
	public void successfulLogin(String username, String password) {
		lpf.enterusername(username);
		lpf.enterpassword(password);
		lpf.clickloginbutton();
		String successmessage = "You are logged in";
		String actualmessage = lpf.getsigninmessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Login not successful");
	}
	
	@Test(priority=3)
	public void signout() {
		lpf.signout();
		String successmessage = "Logged out successfully";
		String actualmessage = lpf.getsignoutmessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Logged out successfully");
	}
	

	@Test(priority=4, dataProvider = "LoginValidcredentials", dataProviderClass = DataProviderClass.class)
	public void Loginwithnonexistingcredentials(String username, String password) {
		lpf.clicksignin();
		username=username+"abc";
		lpf.enterusername(username);
		lpf.enterpassword(password);
		lpf.clickloginbutton();
		String successmessage = "Invalid Username and Password";
		String actualmessage = lpf.getsigninmessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Incorrectmessage");
	}
	
	@Test(priority=5, dataProvider = "LoginValidcredentials", dataProviderClass = DataProviderClass.class)
	public void Loginwithnousername(String username, String password) {
		lpf.enterpassword(password);
		lpf.clickloginbutton();
		String actualvalidationmessage = lpf.emptyusernamevalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage, "Incorrect validation");
	}
	
	@Test(priority=6, dataProvider = "LoginValidcredentials", dataProviderClass = DataProviderClass.class)
	public void Loginwithnopassword(String username, String password) {
		lpf.clearfields();
		lpf.enterusername(username);
		lpf.clickloginbutton();
		String actualvalidationmessage = lpf.emptypasswordvalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage, "Incorrect validation");
	}
	
	@Test(priority=7)
	public void RegisterfromLogin() {
		lpf.registerclick();
		pagetitle = lpf.checkpageTitle();
		LoggerLoad.info("Current page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Registration", "Incorrect Page");
	}
}
