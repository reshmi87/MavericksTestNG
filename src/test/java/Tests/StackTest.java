package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.DataProviderClass;
import PageObjects.StackPf;

public class StackTest {
	private baseclass base = new baseclass();
	WebDriver driver;
	StackPf stackPf;

	@BeforeClass
	public void logintoportal() throws IOException {
		base.login();
		stackPf = new StackPf();
	}
	
	@Test(priority=1)
	public void testStackFromGetStarted() throws IOException {
		stackPf.stackPage();
		Assert.assertTrue(stackPf.isOnStackPage());
	}
	
	@Test(priority=2)
	public void testStackFromDsDropDown() throws IOException {
		stackPf.navigateback();
		stackPf.selectStackFromDsDropDown();
		Assert.assertTrue(stackPf.isOnStackPage());
	}
	
	@Test(priority=3)
	public void testOperationsInStack() throws IOException {
		stackPf.clickOperationsInStage();
		Assert.assertTrue(stackPf.isOnClickOperationsInStage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=5)
	public void testInvalidCodeOperationsInStack(String tryherecode, String expectedalertmessage) throws IOException {
		stackPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=6)
	public void tesValidCodeOperationsInStack(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=7)
	public void testImplementationsInStack() throws IOException {
		stackPf.navigateback();
		stackPf.clickImplementationLink();
		Assert.assertTrue(stackPf.isOnImplementationPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=9)
	public void testInvalidCodeImplementationInStack(String tryherecode, String expectedalertmessage) throws IOException {
		 stackPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=10)
	public void tesValidCodeImplementationInStack(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=11)
	public void testApplicationInStack() throws IOException {
		stackPf.navigateback();
		stackPf.clickApplicationLink();
		Assert.assertTrue(stackPf.isOnApplicationPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=13)
	public void testInvalidCodeApplicationInStack(String tryherecode, String expectedalertmessage) throws IOException {
		stackPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=14)
	public void tesValidCodeApplicationInStack(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=15)
	public void testPracticeQuestionsInStack() throws IOException {
		stackPf.navigateback();
		stackPf.clickPracticeQuestions();
		Assert.assertTrue(stackPf.isOnPracticeQuestionsPage());
	}
	
	private void invalidCodeTest(String tryherecode, String expectedalertmessage) {
		sendCode(tryherecode);
		Assert.assertEquals(stackPf.getAlertText(), expectedalertmessage);
	}
	
	
	private void validCodeTest(String tryherecode, String expectedalertmessage) {
		stackPf.navigateback();
		stackPf.clickTryHere();
		sendCode(tryherecode);
		Assert.assertEquals(stackPf.getOutputEditor(), expectedalertmessage);
	}
	
	private void sendCode(String tryherecode) {
		stackPf.sendCode(tryherecode);
		stackPf.clickRun();
	}

}
