package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Base.baseclass;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Queuepf;

public class Queuetest {
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	Queuepf qpf;
	String pagetitle;
	WebDriver driver;
	
    @BeforeTest
    public void logintoportal() throws IOException {
	   	base.login();
		qpf=new Queuepf();
	}
	
	@Test(priority=1)
	public void queuefromgetstarted() throws IOException {
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
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=4)
	public void testwithinvalidcodeimplementationofqueueinpython(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=5)
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
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=8)
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
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=11)
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
	
	@Test(priority=11, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodequeueoperations(String tryherecode, String expectedalertmessage) {
		qpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=13)
	public void testwithvalidcodequeueoperations(String tryherecode, String expectedconsoleoutput) {
		qpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=14)
	public void testpracticecode() {
		qpf.navigateback();
		qpf.PracticeQuestion();
		boolean checkcontent = qpf.PracticeQuestioncontentcheck();
		assertEquals(checkcontent, true, "No content displayed.");
	}
	

	public void nocodetest() {
		pagetitle = qpf.tryhere();
		qpf.clickrun();
		boolean ifalertdisplayed = qpf.isAlertPresent();
		assertEquals(ifalertdisplayed, true, "No alert displayed.");
	}
	

	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = qpf.tryhere();
		qpf.entercode(code);
		qpf.clickrun();
		boolean ifalertdisplayed = qpf.isAlertPresent();
		assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = qpf.handlealert();
		LoggerLoad.info(alertmessage);
		assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = qpf.tryhere();
		qpf.entercode(tryherecode);
		qpf.clickrun();
		String output = qpf.getoutput();
		assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	
	@AfterTest
	public void exitfromportal() {
		base.closebrowser();
	}

}
