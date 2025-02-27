package PageObjects;

import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;

public class Arraypf {
	
	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;
	protected boolean practicequestioncontent;
	
	
	@FindBy (linkText="Sign in") WebElement signin;
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement Login;
	@FindBy (xpath = "//a[@href='array']") WebElement Getstarted;
	@FindBy (xpath = "//a[contains(text(),'Data Structures')]") WebElement Dropdown;
	@FindBy (xpath = "//a[text()='Arrays']") WebElement ArrayDropdown;
	@FindBy (linkText = "Arrays in Python") WebElement Arraysinpython;
	@FindBy (linkText="Try here>>>") WebElement Tryhere;
    @FindBy (xpath="//div[@class='input']//textarea") WebElement codetextarea;
	@FindBy (xpath="//button[@type='button']") WebElement runbutton;
	@FindBy (xpath="//pre[@id='output']") WebElement consoleoutput;
    @FindBy (linkText="Practice Questions") WebElement PracticeQuestion;
    @FindBy (linkText="Search the array") WebElement practicequescontent;
    @FindBy(linkText = "Max Consecutive Ones")WebElement Maxconsecutiveones;
    @FindBy (linkText = "Arrays Using List") WebElement ArraysUsingList;
    @FindBy (linkText = "Basic Operations in Lists") WebElement BasicOperations;
    @FindBy (linkText = "Applications of Array") WebElement ApplicationsofArray;
    @FindBy (xpath = "//form/div/div/div/textarea") WebElement PQcodetextarea;
    @FindBy (xpath = "//input[@value='Submit']") WebElement Submit;
    
    @FindBy (linkText="Search the array") WebElement searchthearraylink;
    @FindBy(linkText="Max Consecutive Ones") WebElement MaxConseOnes;
    @FindBy(linkText="Find Numbers with Even Number of Digits") WebElement EvenNoOfDigits;
    @FindBy(xpath="//a[contains(text(),'Squares')]") WebElement SquareOfSortedArray;
    
	
public String Arraypage() {
	PageFactory.initElements(driver,this);
	Getstarted.click();
    pagetitle = driver.getTitle();
   	return pagetitle;
	}

public void navigateback() {
	driver.navigate().back();
}

public String checkpageTitle() {
	String currentpagetitle = driver.getTitle();
    return currentpagetitle;
}

public String ArraypagefromDD() {
	Dropdown.click();
	ArrayDropdown.click();
	pagetitle=driver.getTitle();
	return pagetitle;
}

public String Arraysinpython() {	
	Arraysinpython.click();
	pagetitle=driver.getTitle();
	return pagetitle;	
}

public String ArraysUsingList() {
	ArraysUsingList.click();
	pagetitle=driver.getTitle();
	return pagetitle;
}

public String BasicOperations() {
	BasicOperations.click();
	pagetitle=driver.getTitle();
	return pagetitle;
}
public String ApplicationsofArray() {
	ApplicationsofArray.click();
	pagetitle=driver.getTitle();
	return pagetitle;
}

public String tryhere() {
	Tryhere.click();
	pagetitle = driver.getTitle();
	return pagetitle;
}

public void clickrun() {
	runbutton.click();
}


public void Submit() {
	Submit.click();
}


public void entercode(String code) {    	
	Actions actions = new Actions(driver);
	actions.sendKeys(code).perform();
}

public boolean isAlertPresent() 
{ 
    try 
    { 
        driver.switchTo().alert(); 
        return true; 
    }   
    catch (NoAlertPresentException Ex) 
    { 
        return false; 
    }   
}   

public String handlealert() {
  Alert alert = driver.switchTo().alert();
	String alertmessage = alert.getText();
	alert.accept();
	return alertmessage;
}


public String getoutput() {
	String output = consoleoutput.getText();
	return output;
}

public String PracticeQuestionClick() {
	 PracticeQuestion.click();
	 pagetitle = driver.getTitle();
	return pagetitle;
	 
   }

public boolean PracticeQuestioncontentcheck() {
	boolean iscontentpresent = practicequescontent.isDisplayed();
	return iscontentpresent;
}

public String SearchTheArray() {
	searchthearraylink.click();
	 pagetitle = driver.getTitle();
		return pagetitle;		
}

public String MaxConseOnes() {
	Maxconsecutiveones.click();
	 pagetitle = driver.getTitle();
		return pagetitle;			
} 

public String EvenNoOfDigits() {
	EvenNoOfDigits.click();
	 pagetitle = driver.getTitle();
		return pagetitle;		
}

public String SquareOfSortedArray() {
	SquareOfSortedArray.click();
	 pagetitle = driver.getTitle();
		return pagetitle;			
}


public void enterarraycode(ArrayList<String> practicequescode) throws InterruptedException {
	String existcode = "def findMaxConsecutiveOnes(nums) :";
	System.out.println("existing code is: "+existcode);
	int length=existcode.length();
	System.out.println("Length:"+length);
	PQcodetextarea.sendKeys(" ");
	for(int i=0;i<length;i++) {
	PQcodetextarea.sendKeys(Keys.DELETE);
	}
	System.out.println("New Code from Array list");
	System.out.println(practicequescode);
	String code = practicequescode.toString();
	code=code.substring(1, code.length()-1);
	System.out.println("New Code from String");

	//String[] str1 = code.split("\n");
	char[] cArray=code.toCharArray();
	for (int i = 0; i < cArray.length; i++) {
		if (cArray[i]=='@') {
			PQcodetextarea.sendKeys(Keys.BACK_SPACE);
			
		}
		else if (cArray[i] == '~')	{
				PQcodetextarea.sendKeys(Keys.RETURN);
		}
		else {
			String lasttext=Character.toString(cArray[i]);
			PQcodetextarea.sendKeys(lasttext);
		}
	}
}
}
