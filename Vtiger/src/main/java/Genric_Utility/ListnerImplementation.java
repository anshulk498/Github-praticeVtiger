package Genric_Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String testdata = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+testdata+".png");
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	

	
}
