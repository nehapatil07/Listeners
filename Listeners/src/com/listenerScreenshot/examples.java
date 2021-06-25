package com.listenerScreenshot;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerAnn.class)
public class examples {
	public static WebDriver driver;
	@Test(priority=0)
	  public void LogIn() {
			  System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
			  driver=new ChromeDriver();
			  driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
			  driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			  driver.findElement(By.id("password")).sendKeys("sfdn");
			  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
			  String ActText=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
			  Assert.assertEquals(ActText, "wrong password");
		  }
	  @Test(priority=1)
	  public void Test02(){
		  System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		  driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		  driver.findElement(By.id("password")).sendKeys("");
		  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		  String ActText=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		  Assert.assertEquals(ActText, "blank password");
	  }
	@Test(priority=2)
	  public void TestHeading()  {
	  System.getProperty("webdriver.driver.chrome", "chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
	  String heading=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
	  Assert.assertEquals(heading, "Sign in to start session");
	  }
	
	@Test(priority = 3)
	public void VerifyWrongUName(){
		System.getProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("dfjsdf");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String ActErrMsg = driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(ActErrMsg, "Please enter the valid email.");
	}
	@Test(priority = 4)
	public void VerifyCorrectcredential(){
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String ActTitle = driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		Assert.assertEquals(ActTitle, "Dashboard: Courses Offered");
	}
	 
}
