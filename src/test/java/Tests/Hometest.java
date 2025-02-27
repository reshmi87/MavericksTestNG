package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseclass;
import PageObjects.Homepf;
import Commons.ConfigReader;
import Commons.LoggerLoad;

public class Hometest extends baseclass{
	public baseclass base = new baseclass();
	Homepf hpf;
	String pagetitle;
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	
	@Test(priority=1)
	public void toportal() throws IOException {
		hpf=new Homepf();
		String portalurl = config.getportalurl();
		hpf.landonportalpage(portalurl);
		pagetitle = hpf.checkpageTitle();
		LoggerLoad.info("Current page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Numpy Ninja", "Incorrect Page");
	}
	
	@Test(priority=2)
	public void tohome() throws IOException {
		hpf.homeGetStarted();
		LoggerLoad.info("Current page: "+pagetitle);
		Assert.assertEquals(pagetitle, "Numpy Ninja", "Incorrect Page");
	}
	
	@Test(priority=3)
	public void getStartedbeforelogin() throws IOException {
		hpf.clickGetStarted();
		String expectdmsg="You are not logged in";
		String actualmsg=hpf.notloggedinmessage();
		Assert.assertEquals(actualmsg, expectdmsg, "Incorrect Message");
	}
	
	@Test(priority=4)
	public void getStartedAfterlogin() throws IOException {
		base.login();
		hpf.clickGetStarted();
		pagetitle= hpf.checkpageTitle();
		Assert.assertEquals(pagetitle, "Data Structures-Introduction", "Incorrect Page");
	}
	
	@Test(priority=5)
	public void gotoNumpyNinjalink() throws IOException {
		hpf.Numpyninja();
		pagetitle= hpf.checkpageTitle();
		Assert.assertEquals(pagetitle, "Numpy Ninja", "Incorrect Page");
	}
	
	@Test(priority=6)
	public void DataStructuredd() throws IOException {
		hpf.homeGetStarted();
		hpf.openDataStructuresDropdown();
		boolean arrays = true, linkedlist= true, stack=true, queue=true, tree=true, graph=true;
		assertEquals(hpf.checkArray(), arrays, "Arrays not present");
		assertEquals(hpf.checkLinkedlist(), linkedlist, "Linked List not present");
		assertEquals(hpf.checkstack(), stack, "Stack not present");
		assertEquals(hpf.checkqueue(), queue, "Queue not present");
		assertEquals(hpf.checktree(), tree, "Tree not present");
		assertEquals(hpf.checkgraph(), graph, "Graph not present");
	}
}
