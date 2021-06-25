package com.ListenerEg;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(ListenerAnnotations.class)
public class DemoTest {
  @Test
  public void Test01() {
	  System.out.println("Hi..! i am in success test case");
  }
  @Test
  public void Test02() {
	  System.out.println("Hello..! i am i failure test case");
	  Assert.assertEquals(true, false);
  }
  @Test
  public void Test03() {
	  System.out.println("Skip test case03..!");
	  throw new SkipException("skip");
	  
  }
}
