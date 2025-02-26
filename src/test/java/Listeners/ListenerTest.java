package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Base.baseclass;
import Commons.LoggerLoad;
import io.qameta.allure.Attachment;

public class ListenerTest extends ExtentManager implements ITestListener{
	
	@Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

	@Override
	public void onTestStart(ITestResult result) {
	LoggerLoad.info("Test Execution-"+result.getName()+":STARTED");
	test = extent.createTest(result.getName());
	
}

	@Override
	public void onTestSuccess(ITestResult result) {
	LoggerLoad.info("Test Execution-"+result.getName()+":SUCCESS");
	 if (result.getStatus() == ITestResult.SUCCESS) {
	      test.log(Status.PASS, "Pass Test case is: " + result.getName());
	    }	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	LoggerLoad.info("Test Execution-"+result.getName()+":SKIPPED");
	 if (result.getStatus() == ITestResult.SKIP) {
	      test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
	    }
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	LoggerLoad.info("Test Execution-"+result.getName()+":FAILED");
	 if (result.getStatus() == ITestResult.FAILURE) {
	      test.log(Status.FAIL,
	          MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	      test.log(Status.FAIL,
	          MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	     // Object testClass = result.getInstance();
	        WebDriver driver = baseclass.driver;
	        // Allure ScreenShotRobot and SaveTestLog
	        if (driver instanceof WebDriver) {
	            System.out.println("Screenshot captured for test case:" + result.getName());
	            saveScreenshotPNG(driver);
	        }
	        // Save a log on allure.
	        saveTextLog(result.getName() + " failed and screenshot taken!");
	    }
	    }

	@Override
	public void onFinish(ITestContext context) {
	LoggerLoad.info("Test Execution-"+context.getName()+":COMPLETED");
	try {
	      Map<String, Object> testResult = new HashMap<>();
	      testResult.put("TotalTestCaseCount", context.getAllTestMethods().length);
	      testResult.put("PassedTestCaseCount", context.getPassedTests().size());
	      testResult.put("FailedTestCaseCount", context.getFailedTests().size());
	      testResult.put("SkippedTestCaseCount", context.getSkippedTests().size());

	      ObjectMapper mapper = new ObjectMapper();
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      String filePath = "test-output/ExtentReport/TestExecutionReport.json";
	      mapper.writeValue(new File(filePath), testResult);
	    } catch (IOException e) {
	      throw new RuntimeException("Error occurred while writing to TestExecutionReport.json file: ",
	          e);
	    }
	}
	
}
