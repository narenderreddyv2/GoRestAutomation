package api.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




public class extntreport implements ITestListener {

	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	String reportname;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportname = "Test-Report" + timeStamp + ".html";
		reporter = new ExtentSparkReporter(".\\reports\\"+reportname);
		reporter.config().setDocumentTitle("RestAssuredAutomation");
		reporter.config().setReportName("Pet Store Automation API");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("User", "Narender Reddy");
		test=extent.createTest(result.getMethod().getMethodName());
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "Test Passed");
		

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.fail(result.getThrowable().getMessage());
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

}
