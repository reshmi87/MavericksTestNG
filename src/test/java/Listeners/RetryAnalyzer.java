package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Commons.LoggerLoad;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit =2;

	@Override
	public boolean retry(ITestResult result) {
		LoggerLoad.info("Retry method starts From RetryAnalyzer Class");
		if(counter< retryLimit) {
			counter++;
			LoggerLoad.info("Retry:"+counter+" On the failed test case \""+result.getName()+"\"");
			return true;
		}
		LoggerLoad.info("Test case \""+result.getName()+"\": Failed. After "+counter+"retries");
		return false;
	}
}
