package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		
		//Testing soft failure, if it faied, will execute next line
		verifyEquals("abc", "xyz");
		Thread.sleep(3000);
		log.debug("Inside Loging Test");
		click("bmlBtn_CSS");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login Not Successful");
		log.debug("Login Successfully Executed");
		
		//Hard Failure
//		Assert.fail();
	}

}
