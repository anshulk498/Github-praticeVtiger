package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Genric_Utility.BaseClass;
import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Property_Utility;
import Genric_Utility.RetryAnalyzer;
import Genric_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateNewCampaign;
import pom.HomePage;
import pom.LoginPage;


public class CreateCampaignTest extends BaseClass {
	//pull
	 @Test
	//@Test(retryAnalyzer =Genric_Utility.RetryAnalyzer.class )

	public  void createCampaignTest()  throws Throwable {
		//WebDriver driver=null;
		 Webdriver_Utility wu=new Webdriver_Utility();
		 Property_Utility pu=new Property_Utility();
		 Java_Utility ju=new Java_Utility();
	//	WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
//		Random ran=new Random();
//		int RANNUM = ran.nextInt(1000);
		
		int RANNUM = ju.getrannum();
		
		
//		FileInputStream fis=new FileInputStream("src/test/resources/data.properties");
//		Properties pro=new Properties();
//		pro.load(fis);
//		String BROWSER = pro.getProperty("browser");
//		String URL=pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD=pro.getProperty("password");
		
		
		/*String BROWSER=pu.getKeyValue("browser");
		String URL=pu.getKeyValue("url");
		String USERNAME = pu.getKeyValue("username");
		String PASSWORD=pu.getKeyValue("password");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
		
		else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}*/
		
		Excel_Utility eu=new Excel_Utility();
		String Exceldata=eu.getExcelDataformatter("Campaigns", 0, 0)+RANNUM;
//		FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
//		Workbook Book = WorkbookFactory.create(fis1);
//		Sheet SHEET = Book.getSheet("Campaigns");
//		Row ROW = SHEET.getRow(0);
//		Cell CELL = ROW.getCell(0);
//		String Exceldata = CELL.getStringCellValue()+RANNUM;
		
		/*driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		lp.getLoginbutton().click();*/
		
		HomePage hp=new HomePage(driver);
		hp.moretext(driver);
		Thread.sleep(1000);
		hp.getCampaignstext();
		
		CreateNewCampaign cnc=new CreateNewCampaign(driver);
		cnc.getAddCampgain().click();
		System.out.println("hi");
		Thread.sleep(2000);
		
		wu.getclickelement(driver, cnc.getCreateCampgain());
		System.out.println("hello");
		Thread.sleep(2000);
	    /*Actions act=new Actions(driver);
	     * 
	     
	    act.moveToElement(driver.findElement(By.xpath("//a[.='More']"))).perform();
	    driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();*/
	    
	   
	    wu.getExplicitWait( driver,driver.findElement(By.xpath("//input[@name='campaignname']")));

	    
	 
	    cnc.getInputCampgainname().sendKeys(Exceldata);

	    wu.getOptions(driver, driver.findElement(By.xpath("//select[@name='campaigntype']")), "Email");
	   /* Select sel=new Select(driver.findElement(By.xpath("//select[@name='campaigntype']")));
	    List<WebElement> options = sel.getOptions();
	    for(int i=0;i<options.size();i++) {
	    	System.out.println(options.get(i).getText());
	    	if(options.get(i).getText().contains("Email")) {
	    		options.get(i).click();
	    		break;
	    	}
	    }*/
	    	
	    	driver.findElement(By.xpath("//div[@align='center']//input[@title='Save [Alt+S]']")).click();
	    	Assert.assertEquals(false, true);
	    	Thread.sleep(2000);
            wu.getExplicitWait(driver, driver.findElement(By.cssSelector("span.dvHeaderText")));
	    // wb.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.dvHeaderText"))));
		
	    	String ActualData = driver.findElement(By.id("dtlview_Campaign Name")).getText();
	    	System.out.println("actual data is:"+Exceldata);
	    	System.out.println("expected data is:"+ActualData);
	    	//Assert.assertEquals(ActualData, Exceldata);//hardassert
	    	SoftAssert soft = new SoftAssert();
	    	soft.assertEquals(ActualData, Exceldata);
	    	soft.assertAll();
	    	/*if(ActualData.equalsIgnoreCase(Exceldata)) {
	    		System.out.println("pass");
	    	}else {
	    		System.out.println("fail");
	    	}*/
	    	
	    	/*WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    	wu.getclickelement(driver, hover);
	    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
	   
	    }
	
	@Test(retryAnalyzer =Genric_Utility.RetryAnalyzer.class )
	public void m1() {
		System.out.println("i m m1 method");
	}
	}


