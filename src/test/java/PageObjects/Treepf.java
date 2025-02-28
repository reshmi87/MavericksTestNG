package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;

public class Treepf {
	
	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;
	

	@FindBy (xpath="//h5[text()='Tree']/../a") WebElement treegetstarted;
	
	@FindBy (linkText="Overview of Trees") WebElement overviewoftrees;
	@FindBy (linkText="Terminologies") WebElement terminologies;
	@FindBy (linkText="Types of Trees") WebElement typesoftrees;
	@FindBy (linkText="Tree Traversals") WebElement treetraversals;
	@FindBy (linkText="Traversals-Illustration") WebElement traversalsillustration;	
	@FindBy (linkText="Binary Trees") WebElement binarytrees;
	@FindBy (linkText="Types of Binary Trees") WebElement typesofbinarytrees;
	@FindBy (linkText="Implementation in Python") WebElement implementationinpython;
	@FindBy (linkText="Binary Tree Traversals") WebElement binarytreetraversals;
	@FindBy (linkText="Implementation of Binary Trees") WebElement implementationofbinarytrees;
	@FindBy (linkText="Applications of Binary trees") WebElement applicationofbinarytrees;
	@FindBy (linkText="Binary Search Trees") WebElement binarysearchtrees;
	@FindBy (linkText="Implementation Of BST") WebElement implementationofbst;	
	
	@FindBy (linkText="Practice Questions") WebElement practiceques;	
	@FindBy (linkText="Search the tree") WebElement practicequescontent;
	@FindBy (linkText="Try here>>>") WebElement Tryhere;
	@FindBy (xpath="//div[@class='input']//textarea") WebElement codetextarea;
	@FindBy (xpath="//button[@type='button']") WebElement runbutton;
	@FindBy (xpath="//pre[@id='output']") WebElement consoleoutput;
	@FindBy (xpath="//a[contains(text(),'Data Structures')]") WebElement Datastructuredd;
	@FindBy (xpath="//a[text()='Tree']") WebElement Treedd;
	
	public String Treepage() {
		PageFactory.initElements(driver,this);
	    treegetstarted.click();
	    pagetitle = driver.getTitle();
		return pagetitle;
		}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	public String TreepagefromDD() {
		Datastructuredd.click();
		Treedd.click();
	    pagetitle = driver.getTitle();
		return pagetitle;
		}
	
	public String checkpageTitle() {
		String currentpagetitle = driver.getTitle();
			return currentpagetitle;
	}
	
    public String overviewoftrees() {
    	overviewoftrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    
    public String terminologies() {
    	terminologies.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String typesoftrees() {
    	typesoftrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String treetraversals() {
    	treetraversals.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String traversalsillustration() {
    	traversalsillustration.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String binarytrees() {
    	binarytrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String typesofbinarytrees() {
    	typesofbinarytrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String implementationinpython() {
    	implementationinpython.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String binarytreetraversals() {
    	binarytreetraversals.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String implementationofbinarytrees() {
    	implementationofbinarytrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String applicationofbinarytrees() {
    	applicationofbinarytrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String binarysearchtrees() {
    	binarysearchtrees.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    public String implementationofbst() {
    	implementationofbst.click();
    	 pagetitle = driver.getTitle();
    	return pagetitle;
    }
    
    public void PracticeQuestion() {
    	practiceques.click();
    }
    
    public boolean PracticeQuestioncontentcheck() {
    	try {
    		practicequescontent.getText();
            return true; 
    	}
    	catch(NoSuchElementException ex) 
    	{
		return false;
    	}	 
    }
    
    public String tryhere() {
    	Tryhere.click();
    	pagetitle = driver.getTitle();
    	return pagetitle;
    }
    
    public void clickrun() {
    	runbutton.click();
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

}