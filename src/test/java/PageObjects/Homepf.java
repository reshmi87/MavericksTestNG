package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.BrowserFactory;

public class Homepf {
	
	WebDriver driver = BrowserFactory.getdriverinstance();
	String pagetitle;	
 
    @FindBy(linkText = "Get Started") WebElement getstartedHomepage;
    @FindBy (xpath="//h5[text()='Data Structures-Introduction']/../a")  WebElement getStarted;
    @FindBy(linkText = "NumpyNinja") WebElement NumpyNinja;
    @FindBy(linkText = "data-toggle") WebElement dataStructuresDropdown;
    @FindBy (xpath="//a[contains(text(),'Data Structures')]") WebElement Datastructuredd;
	@FindBy (xpath="//a[text()='Arrays']") WebElement Arraydd;
	@FindBy (xpath="//a[text()='Linked List']") WebElement LinkedListdd;
	@FindBy (xpath="//a[text()='Stack']") WebElement Stackdd;
	@FindBy (xpath="//a[text()='Queue']") WebElement Queuedd;
	@FindBy (xpath="//a[text()='Tree']") WebElement Treedd;
	@FindBy (xpath="//a[text()='Graph']") WebElement Graphdd;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement displaymessage;

	public void landonportalpage(String url) {
		PageFactory.initElements(driver,this);
		driver.navigate().to(url);
	}
	
	public void homeGetStarted() {
    	getstartedHomepage.click();
    }
	
	public void clickGetStarted() {
        getStarted.click();
    }
	
 
    public String checkpageTitle() {
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
   
	public String notloggedinmessage() {
		String notloggedinmsg = displaymessage.getText();
		return notloggedinmsg;
	}

    public void Numpyninja() {
    	NumpyNinja.click();
    }

    public void openDataStructuresDropdown() {
    	Datastructuredd.click();
    }
	
	public boolean checkArray() {
		boolean isvaluepresent = Arraydd.isDisplayed();
		return isvaluepresent;
	}
	public boolean checkLinkedlist() {
		boolean isvaluepresent = LinkedListdd.isDisplayed();
		return isvaluepresent;
	}
	public boolean checkqueue() {
		boolean isvaluepresent = Queuedd.isDisplayed();
		return isvaluepresent;
	}
	public boolean checkstack() {
		boolean isvaluepresent = Stackdd.isDisplayed();
		return isvaluepresent;
	}
	public boolean checktree() {
		boolean isvaluepresent = Treedd.isDisplayed();
		return isvaluepresent;
	}
	public boolean checkgraph() {
		boolean isvaluepresent = Graphdd.isDisplayed();
		return isvaluepresent;
	}
}
