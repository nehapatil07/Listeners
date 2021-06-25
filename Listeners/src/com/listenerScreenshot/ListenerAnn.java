package com.listenerScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerAnn implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot tsc=(TakesScreenshot) examples.driver;
		File src=tsc.getScreenshotAs(OutputType.FILE);
		//File dest=new File("E:\\workspace3\\Listeners\\MyScreenShot\\demo.jpg");  //it will create a screenshot with name demo.jpg
		File dest=new File("E:\\workspace3\\Listeners\\MyScreenShot\\"+result.getName()+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
