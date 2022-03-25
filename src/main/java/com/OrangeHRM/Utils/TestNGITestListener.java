package com.OrangeHRM.Utils;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestNGITestListener extends TestBase implements ITestListener {
	String methodName;
	WebDriver driver = null;
	ExtentTest test ;
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports extentReports = ExtentReportNG.getReportObject();
	public void onFinish(ITestContext result) {
		extentReports.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());		
		methodName =  result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodName,driver), result.getMethod().getMethodName());
			//captureScreenshot(driver, methodName+"_Failed");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		methodName =  result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			captureScreenshot(driver, methodName+"_Skipped");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extentReports.createTest("OrangeHRM:"+ result.getMethod().getMethodName());//result.getMethod().getMethodName()
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		methodName =  result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			captureScreenshot(driver, methodName+"_Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	
}
