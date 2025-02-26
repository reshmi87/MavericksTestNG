package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Commons.BrowserFactory;
import Commons.ConfigReader;
import Listeners.ExtentManager;
import PageObjects.Loginpf;

public class baseclass {
	
	
	public BrowserFactory bf=new BrowserFactory();
	public static WebDriver driver;
	private String appurl;
	ConfigReader config = new ConfigReader();
	


	@BeforeTest
	@Parameters({"browser"})
	public void opendsalgo(String browser) throws IOException {
		ExtentManager.setExtent();
		driver =bf.browsersetup(browser);
		appurl = config.getappurl();
		driver.get(appurl);
	}
	
	public void login() throws IOException {
	String username = config.getusername();
	String password = config.getpassword();
	Loginpf login = new Loginpf();
	login.login(username, password);
	}
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
		 ExtentManager.endReport();
	}
	
	

}
