package com.w2a.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;


public class AddCustomerTest extends TestBase {
	
	@Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {
		
		if (!data.get("Runmode").equals("Y")){
			throw new SkipException("Skipping the test case as runmode of this data set is set No.");
		}
		
		click("addCustBtn_CSS");
		type("firstName_CSS", data.get("firstName"));
		type("lastName_XPATH", data.get("lastName"));
		type("postCode_CSS", data.get("postCode"));
		click("addBtn_CSS");
//		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
//		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
//		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
//		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
//		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		Thread.sleep(3000);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();
		
//		Assert.fail("Adding customer failed");
	}
}
