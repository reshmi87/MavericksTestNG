package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Queuepf;

public class Queuetest extends baseclass{
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	Queuepf qpf;
	String pagetitle;
	WebDriver driver;
	
	@Test(priority=1)
	public void queuefromgetstarted() throws IOException {
		base.login();
		qpf=new Queuepf();
	    pagetitle = qpf.Queuepage();
		LoggerLoad.info("Currently in page: "+pagetitle);
		qpf.navigateback();
	}
	
	@Test(priority=2)
	public void queuefromdd() {
		pagetitle = qpf.QueuepagefromDD();
		LoggerLoad.info("Currently in page: "+pagetitle);
	}
	
	@Test(priority=3)
	public void testnocodeimplementationofqueueinpython() {
		pagetitle = qpf.implementationofqueueinpython();
		nocodetest();
	}
	
	@Test(priority=4, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationofqueueinpython(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=5, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationofqueueinpython(String tryherecode, String expectedconsoleoutput) {
		qpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=6)
	public void testnocodeimplementationusingcollcdeque() {
		qpf.navigateback();
		pagetitle = qpf.implementationusingcollcdeque();
		nocodetest();
	}
	
	@Test(priority=7, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationusingcollcdeque(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=8, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationusingcollcdeque(String tryherecode, String expectedconsoleoutput) {
		qpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=9)
	public void testnocodeimplementationusingarray() {
		qpf.navigateback();
		pagetitle = qpf.implementationusingarray();
		nocodetest();
	}
	
	@Test(priority=10, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationusingarray(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=11, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationusingarray(String tryherecode, String expectedconsoleoutput) {
		qpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=12)
	public void testnocodequeueoperations() {
		qpf.navigateback();
		pagetitle = qpf.queueoperations();
		nocodetest();
	}
	
	@Test(priority=13, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodequeueoperations(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=14, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodequeueoperations(String tryherecode, String expectedconsoleoutput) {
		qpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=15)
	public void testpracticecode() {
		qpf.navigateback();
		qpf.PracticeQuestion();
		boolean checkcontent = qpf.PracticeQuestioncontentcheck();
		Assert.assertTrue(checkcontent,  "No content displayed.");
	}
	
	public void nocodetest() {
		pagetitle = qpf.tryhere();
		qpf.clickrun();
		boolean ifalertdisplayed = qpf.isAlertPresent();
		Assert.assertTrue(ifalertdisplayed,  "No alert displayed.");
	}
	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = qpf.tryhere();
		qpf.entercode(code);
		qpf.clickrun();
		boolean ifalertdisplayed = qpf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = qpf.handlealert();
		LoggerLoad.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = qpf.tryhere();
		qpf.entercode(tryherecode);
		qpf.clickrun();
		String output = qpf.getoutput();
		Assert.assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	


}
