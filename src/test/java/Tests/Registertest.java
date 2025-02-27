package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Loginpf;
import PageObjects.Registerpf;

public class Registertest extends baseclass{
	public baseclass base = new baseclass();
	Registerpf rpf;
	String pagetitle;
	WebDriver driver;
	String newuname;
	
	@Test(priority=1)
	public void toRegisterpage() {
		rpf=new Registerpf();
		rpf.registerpage();
		pagetitle = rpf.checkpageTitle();
		LoggerLoad.info("Current page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Registration", "Incorrect Page");
	}
	
	@Test(priority=2, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void successfulRegistration(String username, String password) {
		newuname = rpf.generateuser(username);
		rpf.username(newuname);
		rpf.password1(password);
		rpf.password2(password);
		rpf.registerbutton();
		String successmessage = "New Account Created. You are logged in as "+newuname;
		String actualmessage = rpf.getsuccessmessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Registration not successful");
	}
	

	@Test(priority=3, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void successfulLoginafterRegistration(String username, String password) {
		Loginpf login = new Loginpf();
		rpf.signout();
		login.login(newuname, password);
		String expectedmessage = "You are logged in";
		String actualmessage = login.getsigninmessage();
		LoggerLoad.info("Signin message: "+actualmessage);
		Assert.assertEquals(actualmessage, expectedmessage, "Incorrect Message");
	}
	
	@Test(priority=4, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void Registrationusingexistingcredentials(String username, String password) {
		rpf.signout();
		rpf.registerpage();
		rpf.username(newuname);
		rpf.password1(password);
		rpf.password2(password);
		rpf.registerbutton();
		String expectedmessage = "Username already exists";
		String actualmessage = rpf.geterrormessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}
	
	@Test(priority=5, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void Registrationwithoutusername(String username, String password) {
		rpf.password1(password);
		rpf.password2(password);
		rpf.registerbutton();
		String actualvalidationmessage = rpf.emptyusernamevalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage, "Incorrect validation");
	}
	
	@Test(priority=6, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void Registrationwithoutpassword(String username, String password) {
		newuname = rpf.generateuser(username);
		rpf.username(newuname);
		rpf.password2(password);
		rpf.registerbutton();
		String actualvalidationmessage = rpf.emptypasswordvalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage, "Incorrect validation");
	}
	
	@Test(priority=7, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void Registrationwithoutconfirmpassword(String username, String password) {
		rpf.username(newuname);
		rpf.password1(password);
		rpf.registerbutton();
		String actualvalidationmessage = rpf.emptyconfirmpasswordvalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage, "Incorrect validation");
	}
	
	@Test(priority=8, dataProvider = "Registerinvalidusername", dataProviderClass = DataProviderClass.class)
	public void Registrationusinginvalidusername(String username, String password) {
		rpf.clearfields();
		rpf.username(username);
		rpf.password1(password);
		rpf.password2(password);
		rpf.registerbutton();
		String expectedmessage = "Invalid username";
		String actualmessage = rpf.geterrormessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}
	
	@Test(priority=9, dataProvider = "Registerinvalidpassword", dataProviderClass = DataProviderClass.class)
	public void Registrationusinginvalidpassword(String username, String password) {
		rpf.clearfields();
		rpf.username(username);
		rpf.password1(password);
		rpf.password2(password);
		rpf.registerbutton();
		String expectedmessage = "Invalid Password";
		String actualmessage = rpf.geterrormessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}
	@Test(priority=9, dataProvider = "Registervalidcredentials", dataProviderClass = DataProviderClass.class)
	public void Registrationuspasswordmismatch(String username, String password) {
		rpf.clearfields();
		rpf.username(newuname);
		rpf.password1(password);
		password=password+"text";
		rpf.password2(password);
		rpf.registerbutton();
		String expectedmessage = "password_mismatch:The two password fields didn’t match.";
		String actualmessage = rpf.geterrormessage();
		LoggerLoad.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}
}
