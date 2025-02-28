package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.DataStructurepf;

public class DataStructuretest extends baseclass {
	
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	DataStructurepf dpf;
	String pagetitle;
	WebDriver driver;
	
	@Test(priority=1)
	public void DataStructurefromgetstarted() throws IOException {
		base.login();
		dpf=new DataStructurepf();
	    pagetitle = dpf.DataStructurepage();
		LoggerLoad.info("Currently in page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Data Structures-Introduction", "Not in Data Structures-Introduction Page");
		}

	@Test(priority=2)
	public void testnocodeTimeComplexity() throws InterruptedException {
		pagetitle = dpf.TimeComplexityLink();
		nocodetest();
	}
	
	@Test(priority=3, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeTimeComplexity(String tryherecode, String expectedalertmessage) {
		dpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=4, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeTimeComplexity(String tryherecode, String expectedconsoleoutput) {
		dpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=5)
	public void testpracticecode() {
		dpf.navigateback();
		dpf.PracticeQuestion();
		boolean checkcontent = dpf.PracticeQuestioncontentcheck();
		Assert.assertTrue(checkcontent,  "No content displayed.");
	}
	
	public void nocodetest() {
		pagetitle = dpf.tryhere();
		dpf.clickrun();
		boolean ifalertdisplayed = dpf.isAlertPresent();
		Assert.assertTrue(ifalertdisplayed,  "No alert displayed.");
	}
	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = dpf.tryhere();
		dpf.entercode(code);
		dpf.clickrun();
		boolean ifalertdisplayed = dpf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = dpf.handlealert();
		LoggerLoad.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = dpf.tryhere();
		dpf.entercode(tryherecode);
		dpf.clickrun();
		String output = dpf.getoutput();
		Assert.assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		dpf.closebrowser();
	}

}
