package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.ConfigReader;
import Commons.DataProviderClass;
import Commons.LoggerLoad;
import PageObjects.Treepf;

public class Treetest  extends baseclass{
	public baseclass base = new baseclass();
	public ConfigReader config = new ConfigReader();
	Treepf tpf;
	String pagetitle;
	WebDriver driver;
	
	@Test(priority=1)
	public void treefromgetstarted() throws IOException {
		base.login();
		tpf=new Treepf();
	    pagetitle = tpf.Treepage();
		LoggerLoad.info("Currently in page: "+pagetitle);
		tpf.navigateback();
	}
	
	@Test(priority=2)
	public void treefromdd() {
		pagetitle = tpf.TreepagefromDD();
		LoggerLoad.info("Currently in page: "+pagetitle);
	}
	
	@Test(priority=3)
	public void testnocodeoverviewoftrees() {
		pagetitle = tpf.overviewoftrees();
		nocodetest();
	}
	
	@Test(priority=4, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeoverviewoftrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=5, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeoverviewoftrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=6)
	public void testnocodeterminologies() {
		tpf.navigateback();
		pagetitle = tpf.terminologies();
		nocodetest();
	}
	
	@Test(priority=7, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeterminologies(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=8, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeterminologies(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=9)
	public void testnocodetypesoftrees() {
		tpf.navigateback();
		pagetitle = tpf.typesoftrees();
		nocodetest();
	}
	
	@Test(priority=10, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodetypesoftrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=11, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodetypesoftrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=12)
	public void testnocodetreetraversals() {
		tpf.navigateback();
		pagetitle = tpf.treetraversals();
		nocodetest();
	}
	
	@Test(priority=13, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodetreetraversals(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=14, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodetreetraversals(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=15)
	public void testnocodetraversalsillustration() {
		tpf.navigateback();
		pagetitle = tpf.traversalsillustration();
		nocodetest();
	}
	
	@Test(priority=16, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodetraversalsillustration(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=17, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodetraversalsillustration(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=18)
	public void testnocodebinarytrees() {
		tpf.navigateback();
		pagetitle = tpf.binarytrees();
		nocodetest();
	}
	
	@Test(priority=19, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodebinarytrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=20, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodebinarytrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=21)
	public void testnocodetypesofbinarytrees() {
		tpf.navigateback();
		pagetitle = tpf.typesofbinarytrees();
		nocodetest();
	}
	
	@Test(priority=22, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodetypesofbinarytrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=23, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodetypesofbinarytrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=24)
	public void testnocodeimplementationinpython() {
		tpf.navigateback();
		pagetitle = tpf.implementationinpython();
		nocodetest();
	}
	
	@Test(priority=25, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationinpython(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=26, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationinpython(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}

	@Test(priority=27)
	public void testnocodebinarytreetraversals() {
		tpf.navigateback();
		pagetitle = tpf.binarytreetraversals();
		nocodetest();
	}
	
	@Test(priority=28, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodebinarytreetraversals(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=29, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodebinarytreetraversals(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=30)
	public void testnocodeimplementationofbinarytrees() {
		tpf.navigateback();
		pagetitle = tpf.implementationofbinarytrees();
		nocodetest();
	}
	
	@Test(priority=31, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationofbinarytrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=32, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationofbinarytrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=33)
	public void testnocodeapplicationofbinarytrees() {
		tpf.navigateback();
		pagetitle = tpf.applicationofbinarytrees();
		nocodetest();
	}
	
	@Test(priority=34, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeapplicationofbinarytrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=35, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeapplicationofbinarytrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=36)
	public void testnocodebinarysearchtrees() {
		tpf.navigateback();
		pagetitle = tpf.binarysearchtrees();
		nocodetest();
	}
	
	@Test(priority=37, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodebinarysearchtrees(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=38, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodebinarysearchtrees(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}
	
	@Test(priority=39)
	public void testnocodeimplementationofbst() {
		tpf.navigateback();
		pagetitle = tpf.implementationofbst();
		nocodetest();
	}
	
	@Test(priority=40, dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeimplementationofbst(String tryherecode, String expectedalertmessage) {
		tpf.navigateback();
		invalidcodetest(tryherecode,expectedalertmessage);
	}
	
	@Test(priority=41, dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class)
	public void testwithvalidcodeimplementationofbst(String tryherecode, String expectedconsoleoutput) {
		tpf.navigateback();
		validcodetest(tryherecode,expectedconsoleoutput);
	}

	@Test(priority=42)
	public void testpracticecode() {
		tpf.navigateback();
		tpf.PracticeQuestion();
		boolean checkcontent = tpf.PracticeQuestioncontentcheck();
		Assert.assertTrue(checkcontent,  "No content displayed.");
	}
	
	public void nocodetest() {
		pagetitle = tpf.tryhere();
		tpf.clickrun();
		boolean ifalertdisplayed = tpf.isAlertPresent();
		Assert.assertTrue(ifalertdisplayed,  "No alert displayed.");
	}
	
	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = tpf.tryhere();
		tpf.entercode(code);
		tpf.clickrun();
		boolean ifalertdisplayed = tpf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = tpf.handlealert();
		LoggerLoad.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}
	
	public void validcodetest(String tryherecode,String expectedconsoleoutput) {
		pagetitle = tpf.tryhere();
		tpf.entercode(tryherecode);
		tpf.clickrun();
		String output = tpf.getoutput();
		Assert.assertEquals(output, expectedconsoleoutput, "Incorrect output displayed.");
		LoggerLoad.info("Output is "+output);
	}
	
}
