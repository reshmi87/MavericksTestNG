package Commons;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "Validpythoncode")
	public Object[][] Validpythoncode() throws IOException {
		ExcelReader read = new ExcelReader();
		String tryherecode = read.gettryherecode(1);
		String expectedoutput=read.gettryheremessage(1);
		return new Object[][]{
		{tryherecode,expectedoutput}
		};
	}

	@DataProvider(name = "Invalidpythoncode")
	public Object[][] invalidpythoncode() throws IOException {
		ExcelReader read = new ExcelReader();
		String tryherecode = read.gettryherecode(2);
		String expectedalertmessage=read.gettryheremessage(2);
		return new Object[][]{
		{tryherecode,expectedalertmessage}
		};
	}
	
	@DataProvider(name = "PracticeQSearchthearray")
	public Object[][] practiceqsearchthearray() throws IOException {
		ExcelReader read = new ExcelReader();
		ArrayList<String> practicequescode = read.getpracticeques(1);
		String expectedoutput=read.getPQoutput(1);
		return new Object[][]{
			{practicequescode,expectedoutput}
			};
	}
	
	@DataProvider(name = "PracticeQMaxConsones")
	public Object[][] practiceqmaxconsones() throws IOException {
		ExcelReader read = new ExcelReader();
		ArrayList<String> practicequescode = read.getpracticeques(2);
		String expectedoutput=read.getPQoutput(2);
		return new Object[][]{
			{practicequescode,expectedoutput}
			};
	}
	
	@DataProvider(name = "PracticeQEvennums")
	public Object[][] practiceqevennums() throws IOException {
		ExcelReader read = new ExcelReader();
		ArrayList<String> practicequescode = read.getpracticeques(3);
		String expectedoutput=read.getPQoutput(3);
		return new Object[][]{
			{practicequescode,expectedoutput}
			};
	}

	@DataProvider(name = "PracticeQSQofsortedarray")
	public Object[][] practiceqsqofsortedarray() throws IOException {
		ExcelReader read = new ExcelReader();
		ArrayList<String> practicequescode = read.getpracticeques(4);
		String expectedoutput=read.getPQoutput(4);
		return new Object[][]{
			{practicequescode,expectedoutput}
			};
	}
}
