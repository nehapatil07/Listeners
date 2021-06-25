package com.ListenerEg;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerAnnotations implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("Listener's on start method"+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Listener's on test success method"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Listener's on test failure method"+result.getName());
		ScreenShotWithListener.GetScreenShot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Listener's on test skipped method"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Listener's on failed within success % method"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listener's on context start method"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Listener's on context finish method"+context.getName());
	}

}
