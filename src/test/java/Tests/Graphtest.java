package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.BrowserFactory;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Graphpf;

public class Graphtest extends baseclass{
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	Graphpf gpf;
	String pagetitle;
	WebDriver driver = BrowserFactory.getdriverinstance();
	
	@Test(priority=1)
	public void Graphfromgetstarted() throws IOException {
		base.login();
		gpf=new Graphpf();
	    pagetitle = gpf.Graphmainpage();
		LoggerLoad.info("Currently in page: "+pagetitle);
		gpf.navigateback();
	}
	
	@Test(priority=2)
	public void Graphfromdd() {
		pagetitle = gpf.GraphpagefromDD();
		LoggerLoad.info("Currently in page: "+pagetitle);
	}
	
	@Test(priority=3)
	public void testnocodeGraph() {
		pagetitle = gpf.Graph();
		nocodetest();
	}
	
	@Test(priority=4, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeGraph(String tryherecode, String expectedalertmessage) {
		gpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=5, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeGraph(String tryherecode, String expectedconsoleoutput) {
		gpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=6)
	public void testnocodeGraphRepresentationsPage() {
		gpf.navigateback();
		pagetitle = gpf.GraphRepresentationsPage();
		nocodetest();
	}
	
	@Test(priority=7, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeGraphRepresentationsPage(String tryherecode, String expectedalertmessage) {
		gpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=8, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeGraphRepresentationsPage(String tryherecode, String expectedconsoleoutput) {
		gpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=9)
	public void testpracticecode() {
		gpf.navigateback();
		gpf.PracticeQuestions();
		boolean checkcontent = gpf.PracticeQuestioncontentcheck();
		Assert.assertTrue(checkcontent,  "No content displayed.");
	}
	
	public void nocodetest() {
		pagetitle = gpf.tryhere();
		gpf.clickrun();
		boolean ifalertdisplayed = gpf.isAlertPresent();
		Assert.assertTrue(ifalertdisplayed,  "No alert displayed.");
	}
	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = gpf.tryhere();
		gpf.entercode(code);
		gpf.clickrun();
		boolean ifalertdisplayed = gpf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = gpf.handlealert();
		LoggerLoad.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = gpf.tryhere();
		gpf.entercode(tryherecode);
		gpf.clickrun();
		String output = gpf.getoutput();
		Assert.assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		gpf.closebrowser();
	}

}
