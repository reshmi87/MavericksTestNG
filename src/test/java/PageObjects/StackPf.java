package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;

public class StackPf {
	WebDriver driver = BrowserFactory.getdriverinstance();

	@FindBy(xpath = "//input[@id='id_username']")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@id='id_password']")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	@FindBy(xpath = "//h5[text()='Stack']/../a[text()='Get Started']")
	WebElement hrefGetStarted;

	@FindBy(xpath = "//h4[text()='Stack']")
	WebElement stackPage;

	@FindBy(linkText = "Sign in")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='Operations in Stack']")
	WebElement operationsInStackLink;

	@FindBy(xpath = "//p[text()='Operations in Stack']")
	WebElement operationsInStackPage;

	@FindBy(xpath = "//a[text()='Implementation']")
	WebElement implementationLink;

	@FindBy(xpath = "//p[text()='Implementation']")
	WebElement implementationPage;

	@FindBy(xpath = "//a[text()='Applications']")
	WebElement applicationLink;

	@FindBy(xpath = "//p[text()='Applications']")
	WebElement applicationPage;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement btnTryhere;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement btnRun;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement inputEditor;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement ouputEditor;

	@FindBy(xpath = "//a[text() = 'Practice Questions']")
	WebElement practiceQuestionsLink;

	@FindBy(xpath = "//p[text() = 'Practice Questions']")
	WebElement practiceQuestionsPage;

	@FindBy(xpath = "//a[contains(text(),'Data Structures')]")
	WebElement dsDropDown;

	@FindBy(xpath = "//a[text()='Stack']")
	WebElement stackDropDownValue;

	public void stackPage() {
		PageFactory.initElements(driver, this);
		clickGetStarted();
	}

	public void navigateback() {
		driver.navigate().back();
	}

	public void clickGetStarted() {
		hrefGetStarted.click();
	}

	public boolean isOnStackPage() {
		return stackPage.isDisplayed();
	}

	public void clickOperationsInStage() {
		operationsInStackLink.click();
	}

	public boolean isOnClickOperationsInStage() {
		return operationsInStackLink.isDisplayed();
	}

	public void clickImplementationLink() {
		implementationLink.click();
	}

	public boolean isOnImplementationPage() {
		return implementationPage.isDisplayed();
	}

	public void clickApplicationLink() {
		applicationLink.click();
	}

	public boolean isOnApplicationPage() {
		return applicationPage.isDisplayed();
	}

	public void clickPracticeQuestions() {
		practiceQuestionsLink.click();
	}

	public boolean isOnPracticeQuestionsPage() {

		return practiceQuestionsPage.isDisplayed();
	}

	public void sendCode(String pythonCode) {
		Actions actions = new Actions(driver);
		actions.sendKeys(inputEditor, pythonCode).perform();
	}

	public boolean isRunSuccess() {
		return ouputEditor.isDisplayed();
	}

	public String getOutputEditor() {
		return ouputEditor.getText();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
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

	public void selectStackFromDsDropDown() {
		dsDropDown.click();
		stackDropDownValue.click();
	}

}
