package com.Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
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
}
