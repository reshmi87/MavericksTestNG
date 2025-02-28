package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.baseclass;
import Commons.DataProviderClass;
import PageObjects.LinkedListPf;

public class LinkedListTest extends baseclass {
	private baseclass base = new baseclass();
	WebDriver driver;
	LinkedListPf linkedListPf;

	@BeforeClass
	public void logintoportal() throws IOException {
		base.login();
		linkedListPf = new LinkedListPf();
	}
	
	@Test(priority=1)
	public void testLinkedListFromGetStarted() throws IOException {
		linkedListPf.linkedListPage();
		Assert.assertTrue(linkedListPf.isOnLinkedListPage());
	}
	
	@Test(priority=2)
	public void testSelectLinkedListFromDD() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.selectLinkedListFromDsDropDown();
		Assert.assertTrue(linkedListPf.isOnLinkedListPage());
	}
	
	@Test(priority=3)
	public void testIntroductionPage() throws IOException {
		linkedListPf.clickIntroduction();
		Assert.assertTrue(linkedListPf.isOnIntroductionPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=4)
	public void testInvalidCodeIntroduction(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=5)
	public void tesValidCodeIntroduction(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=6)
	public void testCreatingLinkedListPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickCreateLinkedList();
		Assert.assertTrue(linkedListPf.isOnCreateLinkedListPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=7)
	public void testInvalidCodeCreatingLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=8)
	public void tesValidCodeCreatingLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=9)
	public void testTypesListPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickTypesLinkedList();
		Assert.assertTrue(linkedListPf.isOnTypesLinkedListPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=10)
	public void testInvalidCodeTypesLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=11)
	public void tesValidCodeTypesLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=12)
	public void testImplementListPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickImplementLinkedList();
		Assert.assertTrue(linkedListPf.isOnImplmentLinkedListPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=13)
	public void testInvalidCodeImplementLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=14)
	public void tesValidCodeImplementLinkedList(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=15)
	public void testTraversalPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickTraversal();
		Assert.assertTrue(linkedListPf.isOnTraversalPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=16)
	public void testInvalidCodeTraversal(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=17)
	public void tesValidCodeTraversal(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=18)
	public void testInsertionPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickInsertion();
		Assert.assertTrue(linkedListPf.isOnInsertionPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=19)
	public void testInvalidCodeInsertion(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=20)
	public void tesValidCodeInsertion(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=21)
	public void testDeletionPage() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickDeletion();
		Assert.assertTrue(linkedListPf.isOnDeletionPage());
	}
	
	@Test(dataProvider = "Invalidpythoncode", dataProviderClass = DataProviderClass.class, priority=22)
	public void testInvalidCodeDeletion(String tryherecode, String expectedalertmessage) throws IOException {
		linkedListPf.clickTryHere();
		invalidCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(dataProvider = "Validpythoncode", dataProviderClass = DataProviderClass.class, priority=23)
	public void tesValidCodeDeletion(String tryherecode, String expectedalertmessage) throws IOException {
		validCodeTest(tryherecode, expectedalertmessage);
	}
	
	@Test(priority=24)
	public void testPracticeQuestionsInStack() throws IOException {
		linkedListPf.navigateback();
		linkedListPf.clickPracticeQuestions();
		Assert.assertTrue(linkedListPf.isOnPracticeQuestionsPage());
	}
	
	private void invalidCodeTest(String tryherecode, String expectedalertmessage) {
		sendCode(tryherecode);
		Assert.assertEquals(linkedListPf.getAlertText(), expectedalertmessage);
	}
	
	
	private void validCodeTest(String tryherecode, String expectedalertmessage) {
		linkedListPf.navigateback();
		linkedListPf.clickTryHere();
		sendCode(tryherecode);
		Assert.assertEquals(linkedListPf.getOutputEditor(), expectedalertmessage);
	}
	
	private void sendCode(String tryherecode) {
		linkedListPf.sendCode(tryherecode);
		linkedListPf.clickRun();
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		linkedListPf.closebrowser();
	}
}
