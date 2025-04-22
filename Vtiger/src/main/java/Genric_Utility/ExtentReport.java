package Genric_Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Test
public class ExtentReport implements ITestListener {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	
	public void onTestFailure(ITestResult result) {
		String testdata = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		 LocalDate date = LocalDate.now();
		 date.toString().replace("", "-").replace(":", "*");
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+testdata+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	//1 where test suite will start
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		//extent report configuration
	
		Date d=new Date();
		System.out.println(d);
		d.toString().replace("", "-").replace(":", "*");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(new File("extentreport.html"));
		htmlreport.config().setDocumentTitle("extentreport");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("automation testing");	
		
		//add system config
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("os", "window 11");
		report.setSystemInfo("url", "http://localhost:8888/index.php");
		report.setSystemInfo("reportName", "anshul");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
	

	

}
