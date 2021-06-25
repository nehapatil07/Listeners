package com.ListenerEg;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerAnnotations.class)
public class ScreenShotWithListener {
	public static WebDriver driver;

  public static void GetScreenShot(String name)  {
	  SimpleDateFormat sdf=new SimpleDateFormat("ddmmyyyyhhss");
	  String date=sdf.format(new Date());
	  TakesScreenshot tsc=(TakesScreenshot) driver;
	  File src=tsc.getScreenshotAs(OutputType.FILE);
	  File dest=new File("E:\\workspace3\\Listeners\\Screenshot\\"+name+date+".jpg");
	  try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @Test
  public void Test01() {
	  System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://javabykiran.com/playground/delete-customer"); 
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Neha");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.switchTo().alert().dismiss();
	  Assert.assertEquals(true, false);
  }
  @Test
  public void LogIn(){
	  System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		Assert.assertEquals(true, false);
  }
  @Test(priority=0)
  public void TestHeading() throws InterruptedException {
  System.getProperty("webdriver.driver.chrome", "chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  Thread.sleep(500);
  driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
  //String label=Utility.getlabel("xpath", "/html/body/div/div[2]/p", driver);
 // System.out.println(label);
  String heading=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
  Assert.assertEquals(heading, "Sign in to start session");
  }
@Test(priority = 1)
public void VerifyBlnkUnameErrMsg() throws InterruptedException {
	System.getProperty("webdriver.driver.chrome", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	Thread.sleep(500);
	driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String ActErrMsg = driver.findElement(By.id("email_error")).getText();
	Assert.assertEquals(ActErrMsg, "Please enter email.");
}

@Test(priority = 2)
public void VerifyWrongUName() throws InterruptedException {
	System.getProperty("webdriver.driver.chrome", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
	Thread.sleep(500);
	driver.findElement(By.id("email")).sendKeys("dfjsdf");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String ActErrMsg = driver.findElement(By.id("email_error")).getText();
	Assert.assertEquals(ActErrMsg, "Please enter  email.");
}
}
