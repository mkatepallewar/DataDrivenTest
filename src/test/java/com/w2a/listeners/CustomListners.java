package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=rep.startTest(result.getName().toUpperCase());
		//runmode - Y
		if (!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException("Skipping the test "+ result.getName().toUpperCase()+" as Test Run mode is No...");
		}
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		try {
			TestUtil.captureScreeShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with Exception"+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));
		
		
		Reporter.log("Click to see Screen Image.");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">ScreenImage</>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+" height=200 width=200></img></>");
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" : Skipped the test case as runmode is No");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
