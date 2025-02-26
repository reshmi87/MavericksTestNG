package Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import Commons.LoggerLoad;

public class Transformer implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		Reporter.log("Transform method " + testMethod.getName());
		LoggerLoad.info("Transform method " + testMethod.getName());
	}
	

}
