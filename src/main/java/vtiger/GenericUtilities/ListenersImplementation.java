package vtiger.GenericUtilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * This class provides implementation for the ITestListener Interface of TestNG
 * @author ADMIN
 *
 */
public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"== test script execution started==");
		test = report.createTest(methodName);
		test.log(Status.INFO, " === test script execution started ===");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"== test script passed==");
		test.log(Status.PASS, methodName+"=== PASS ===");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" === FAIL ===");
		test.log(Status.INFO, result.getThrowable());
		 
		//System.out.println(methodName+"== test script failed==");
		// System.out.println(result.getThrowable());
		 WebDriverUtility wUtil =  new WebDriverUtility();
		 String screenshotName = methodName+"-"+ new JavaUtility().getSystemDateInFormat();
			try {
				WebDriver driver = null;
				wUtil.takeScreenShot(driver, screenshotName);
				//wUtil.takeScreenShot(BaseClass1.sDriver, screenshotName);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
/*String screenshotName = methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenShot(BaseClass1.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path); // go the screenshot location and it will 
			                                     // attached to the report
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
			}
	

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"== test script skipped==");
		//System.out.println(result.getThrowable());// print the exception
		test.log(Status.SKIP, methodName+" === SKIP ===");
		test.log(Status.INFO, result.getThrowable()); // print the exception in report
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Execution started");
		//Extent Report Configuration Report-05 Apr 2023-10-23-45.html
				ExtentSparkReporter htmlreporter = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
				htmlreporter.config().setDocumentTitle("Vtiger Execution Report");
				htmlreporter.config().setTheme(Theme.DARK);
				htmlreporter.config().setReportName("Automation Execution Report");
				
				report = new ExtentReports();
				report.attachReporter(htmlreporter);
				report.setSystemInfo("Base URL", "http://localhost:8888");
				report.setSystemInfo("Base Browser", "chrome");
				report.setSystemInfo("Base Platform", "Windows");
				report.setSystemInfo("Reporter-Name", "admin");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution finished");
		report.flush(); // generate the report
	}

	
}
