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


public class DataStructurepf {

	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;
	
	@FindBy (xpath="//h5[text()='Data Structures-Introduction']/../a") WebElement DataStructuregetstarted;
	@FindBy(linkText = "Time Complexity") WebElement TimeComplexity;
	
	@FindBy(xpath = "//h4[text()='Data Structures-Introduction']")WebElement pageTitle;

	@FindBy (linkText="Practice Questions") WebElement practiceques;	
	@FindBy (linkText="Search the Queue") WebElement practicequescontent;
	@FindBy (linkText="Try here>>>") WebElement Tryhere;
	@FindBy (xpath="//div[@class='input']//textarea") WebElement codetextarea;
	@FindBy (xpath="//button[@type='button']") WebElement runbutton;
	@FindBy (xpath="//pre[@id='output']") WebElement consoleoutput;

	
	public String DataStructurepage() {
		PageFactory.initElements(driver, this);
		DataStructuregetstarted.click();
		pagetitle=driver.getTitle();
		return pagetitle;	
	}
	
	public void navigateback() {
		driver.navigate().back();
	}

	
	public String checkpageTitle() {
		String currentpagetitle = driver.getTitle();
		return currentpagetitle;
	}
	
	public String TimeComplexityLink() {
		TimeComplexity.click();
		pagetitle=driver.getTitle();
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
	    public void closebrowser() {
	   	 driver.quit();
	       }
}
