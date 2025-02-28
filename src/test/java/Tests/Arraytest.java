package Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Arraypf;


public class Arraytest extends baseclass{
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	Arraypf apf;
	String pagetitle;
	WebDriver driver;
	
	@Test(priority=1)
	public void arrayfromgetstarted() throws IOException {
		base.login();
		apf=new Arraypf();
	    pagetitle = apf.Arraypage();
		LoggerLoad.info("Currently in page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Array", "Not in Array Page");
		apf.navigateback();
	}
	
	@Test(priority=2)
	public void arrayfromdd() {
		pagetitle = apf.ArraypagefromDD();
		LoggerLoad.info("Currently in page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Array", "Not in Array Page");
	}
	
	@Test(priority=3)
	public void testnocodeArraysinpython() {
		pagetitle = apf.Arraysinpython();
		nocodetest();
	}
	
	@Test(priority=4, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeArraysinpython(String tryherecode, String expectedalertmessage) {
		apf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=5, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeArraysinpython(String tryherecode, String expectedconsoleoutput) {
		apf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=6)
	public void testnocodeArraysusinglist() {
		apf.navigateback();
		pagetitle = apf.ArraysUsingList();
		nocodetest();
	}
	
	@Test(priority=7, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeArraysusinglist(String tryherecode, String expectedalertmessage) {
		apf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=8, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeArraysusinglist(String tryherecode, String expectedconsoleoutput) {
		apf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=9)
	public void testnocodeBasicoperationinlists() {
		apf.navigateback();
		pagetitle = apf.BasicOperations();
		nocodetest();
	}
	
	@Test(priority=10, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeBasicoperationinlists(String tryherecode, String expectedalertmessage) {
		apf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=11, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeBasicoperationinlists(String tryherecode, String expectedconsoleoutput) {
		apf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=12)
	public void testnocodeApplicationsofarray() {
		apf.navigateback();
		pagetitle = apf.ApplicationsofArray();
		nocodetest();
	}
	
	@Test( priority=13, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeApplicationsofarray(String tryherecode, String expectedalertmessage) {
		apf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=14, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeApplicationsofarray(String tryherecode, String expectedconsoleoutput) {
		apf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	} 
	
	@Test(priority=15, dataProvider = "PracticeQSearchthearray", dataProviderClass = DataProviderClass.class)
	public void testPracticeQSearchthearray(ArrayList<String> practicequescode, String expectedoutput) throws InterruptedException {
		apf.navigateback();
		apf.PracticeQuestionClick();
		pagetitle = apf.SearchTheArray();
		apf.enterarraycode(practicequescode);
		apf.clickrun();
		String output=apf.getoutput();
		LoggerLoad.info("Expected output:"+expectedoutput);
		LoggerLoad.info("Actual output:"+output);
		Assert.assertEquals(output, expectedoutput, "Incorrect output displayed.");
	} 

	@Test(priority=16, dataProvider = "PracticeQMaxConsones", dataProviderClass = DataProviderClass.class)
	public void testPracticeQMaxConsones(ArrayList<String> practicequescode, String expectedoutput) throws InterruptedException {
		apf.navigateback();
		pagetitle = apf.MaxConseOnes();
		apf.enterarraycode(practicequescode);
		apf.clickrun();
		String output=apf.getoutput();
		LoggerLoad.info("output:"+output);
		Assert.assertEquals(output, expectedoutput, "Incorrect output displayed.");
	} 
	
	@Test(priority=17, dataProvider = "PracticeQEvennums", dataProviderClass = DataProviderClass.class)
	public void testPracticeQEvennums(ArrayList<String> practicequescode, String expectedoutput) throws InterruptedException {
		apf.navigateback();
		pagetitle = apf.EvenNoOfDigits();
		apf.enterarraycode(practicequescode);
		apf.clickrun();
		String output=apf.getoutput();
		LoggerLoad.info("output:"+output);
		Assert.assertEquals(output, expectedoutput, "Incorrect output displayed.");
	} 
	
	@Test(priority=18, dataProvider = "PracticeQSQofsortedarray", dataProviderClass = DataProviderClass.class)
	public void testPracticeQSQofsortedarray(ArrayList<String> practicequescode, String expectedoutput) throws InterruptedException {
		apf.navigateback();
		pagetitle = apf.SquareOfSortedArray();
		apf.enterarraycode(practicequescode);
		apf.clickrun();
		String output=apf.getoutput();
		LoggerLoad.info("output:"+output);
		Assert.assertEquals(output, expectedoutput, "Incorrect output displayed.");
	}

	public void nocodetest() {
		pagetitle = apf.tryhere();
		apf.clickrun();
		boolean ifalertdisplayed = apf.isAlertPresent();
		Assert.assertTrue(ifalertdisplayed,  "No alert displayed.");
	}
	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = apf.tryhere();
		apf.entercode(code);
		apf.clickrun();
		boolean ifalertdisplayed = apf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = apf.handlealert();
		LoggerLoad.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = apf.tryhere();
		apf.entercode(tryherecode);
		apf.clickrun();
		String output = apf.getoutput();
		Assert.assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		apf.closebrowser();
	}


}
