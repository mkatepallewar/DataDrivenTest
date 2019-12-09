package com.w2a.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;


public class OpenAccountTest extends TestBase {
	
	@Test (dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException {
			click("openaccount_CSS");
			select("customer_CSS",data.get("customer"));
			select("currency_CSS",data.get("currency"));
			click("process_CSS");
			
			Thread.sleep(3000);
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			
			Assert.assertTrue(alert.getText().contains(data.get("alertText")));
			alert.accept();
	}
}
