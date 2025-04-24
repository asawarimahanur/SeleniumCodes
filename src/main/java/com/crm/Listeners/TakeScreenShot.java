package com.crm.Listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.BaseClass.BaseOrangeHRM;


public class TakeScreenShot extends BaseOrangeHRM implements ITestListener{
	
	public static ExtentSparkReporter spark = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	@Override
	public void onTestStart(ITestResult result) {
	String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"failed");
		TakesScreenshot ts=(TakesScreenshot) dr;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String image = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(image);
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(".\\src\\test\\resources\\ExtentReport\\Screenshot.html");
		
		//Configure ExtentSparkReporter
		spark.config().setDocumentTitle("OrangeHRM");
		spark.config().setReportName("OrangeHRM Login page");
		spark.config().setTheme(Theme.DARK);
		
		//create extentreport
		report = new ExtentReports();
		
		//set ExtentReport
		report.setSystemInfo("os", "window-11");
		report.setSystemInfo("browser", "Chrome-v1.0.3");
		
		//Attach ExtentSparkReporter to Extent Report
		report.attachReporter(spark);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
	}