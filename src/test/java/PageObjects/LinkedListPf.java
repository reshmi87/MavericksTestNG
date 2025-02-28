package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;

public class LinkedListPf {
	Logger log = LogManager.getLogger(LinkedListPf.class);

	WebDriver driver = BrowserFactory.getdriverinstance();

	@FindBy(xpath = "//input[@id='id_username']")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@id='id_password']")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	@FindBy(xpath = "//h5[text()='Linked List']/../a[text()='Get Started']")
	WebElement hrefGetStarted;

	@FindBy(xpath = "//h4[text()='Linked List']")
	WebElement linkedListPage;

	@FindBy(xpath = "//a[text()='Introduction']")
	WebElement hrefIntroduction;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement btnTryhere;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement btnRun;

	@FindBy(xpath = "//p[text()='Introduction']")
	WebElement introductionPage;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement inputEditor;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement ouputEditor;

	@FindBy(xpath = "//a[text() = 'Creating Linked LIst']")
	WebElement createLinkedListLink;

	@FindBy(xpath = "//p[text()='Creating Linked LIst']")
	WebElement createLinkedListPage;

	@FindBy(xpath = "//a[text() = 'Types of Linked List']")
	WebElement typesLinkedListLink;

	@FindBy(xpath = "//p[text()='Types of Linked List']")
	WebElement typesLinkedListPage;

	@FindBy(xpath = "//a[text() = 'Implement Linked List in Python']")
	WebElement implementLinkedListLink;
	@FindBy(xpath = "//p[text()='Implement Linked List in Python']")
	WebElement implementLinkedListPage;

	@FindBy(xpath = "//a[text() = 'Traversal']")
	WebElement traversalLink;
	@FindBy(xpath = "//p[text()='Traversal']")
	WebElement traversalPage;

	@FindBy(xpath = "//a[text() = 'Insertion']")
	WebElement insertionLink;
	@FindBy(xpath = "//p[text()='Insertion']")
	WebElement insertionPage;

	@FindBy(xpath = "//a[text() = 'Deletion']")
	WebElement deletionLink;
	@FindBy(xpath = "//p[text()='Deletion']")
	WebElement deletionPage;

	@FindBy(xpath = "//a[text() = 'Practice Questions']")
	WebElement practiceQuestionsLink;

	@FindBy(xpath = "//p[text() = ' Practice Questions']")
	WebElement practiceQuestionsPage;
	
	@FindBy (linkText="Sign in") WebElement signIn;
	
	@FindBy (xpath="//a[contains(text(),'Data Structures')]") WebElement dsDropDown;
	
	@FindBy (xpath="//a[text()='Linked List']") WebElement linkedListDropDownValue;
	
	public void linkedListPage() {
		PageFactory.initElements(driver, this);
		clickGetStarted();
	}

	public void navigateback() {
		driver.navigate().back();
	}

	public void clickBtnLogin() {
		btnLogin.click();
	}

	public void clickGetStarted() {
		hrefGetStarted.click();
	}

	public boolean isOnLinkedListPage() {
		return linkedListPage.isDisplayed();
	}

	public void clickIntroduction() {
		hrefIntroduction.click();
	}

	public boolean isOnIntroductionPage() {
		return introductionPage.isDisplayed();
	}

	public void clickTryHere() {
		btnTryhere.click();
	}

	public boolean isOnTryEditorPage() {
		return btnRun.isDisplayed();
	}

	public void clickRun() {
		btnRun.click();
	}

	public void clickCreateLinkedList() {
		createLinkedListLink.click();
	}

	public boolean isOnCreateLinkedListPage() {
		return createLinkedListPage.isDisplayed();
	}

	public void clickTypesLinkedList() {
		typesLinkedListLink.click();
	}

	public boolean isOnTypesLinkedListPage() {
		return typesLinkedListPage.isDisplayed();
	}

	public void clickImplementLinkedList() {
		implementLinkedListLink.click();
	}

	public boolean isOnImplmentLinkedListPage() {
		return implementLinkedListPage.isDisplayed();
	}

	public void clickTraversal() {
		traversalLink.click();
	}

	public boolean isOnTraversalPage() {
		return traversalPage.isDisplayed();
	}

	public void clickInsertion() {
		insertionLink.click();
	}

	public boolean isOnInsertionPage() {
		return insertionPage.isDisplayed();
	}

	public void clickDeletion() {
		deletionLink.click();
	}

	public boolean isOnDeletionPage() {
		return deletionPage.isDisplayed();
	}

	public void clickPracticeQuestions() {
		practiceQuestionsLink.click();
	}

	public boolean isOnPracticeQuestionsPage() {

		return practiceQuestionsPage.isDisplayed();
	}
	
	public String getOutputEditor() {
		return ouputEditor.getText();
	}

	public void sendCode(String pythonCode) {
		Actions actions = new Actions(driver);
		actions.sendKeys(inputEditor, pythonCode).perform();
	}

	public boolean isRunSuccess() {
		return ouputEditor.isDisplayed();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
	
	public void selectLinkedListFromDsDropDown() {
		dsDropDown.click();
		linkedListDropDownValue.click();
	}
	
	public void closebrowser() {
		driver.quit();
	}
}
