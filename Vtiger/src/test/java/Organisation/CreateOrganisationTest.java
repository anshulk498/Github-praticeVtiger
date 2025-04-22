package Organisation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Genric_Utility.BaseClass;
import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Property_Utility;
import Genric_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganisationCreationPage;

public class CreateOrganisationTest extends BaseClass {
	
	@Test
	public  void createOrganisationTest() throws Throwable {
		
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
		Java_Utility ju=new Java_Utility();
		int RANNUM = ju.getrannum();
		/*Random ran=new Random();
		int RANNUM = ran.nextInt(1000);*/
		
		Property_Utility pu=new Property_Utility();
		/*String BROWSER=pu.getKeyValue("browser");
		String URL=pu.getKeyValue("url");
		String USERNAME = pu.getKeyValue("username");
		String PASSWORD=pu.getKeyValue("password");
		/*FileInputStream fis=new FileInputStream("src/test/resources/data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		
		
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
//		String OrgExceldata=eu.getExcelDataformatter("Organization", 0, 0)+RANNUM;
//		System.out.println(OrgExceldata);
//		System.out.println("hello");
		/*FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book = WorkbookFactory.create(fis1);
		Sheet SHEET = Book.getSheet("Organization");
		Row ROW = SHEET.getRow(0);
		Cell CELL = ROW.getCell(0);
		String OrgExceldata = CELL.getStringCellValue()+RANNUM;*/
		
		/*driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		/*LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		lp.getLoginbutton().click();*/
		 
		HomePage hp=new HomePage(driver);
		hp.getCreateOrgtext().click();
		
	   /* Actions act=new Actions(driver);
	    driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[.='Organizations']")).click();
	   Thread.sleep(2000);
	    act.click(driver.findElement(By.xpath("//img[@title='Create Organization...']"))).perform();
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgExceldata);
	    act.scrollByAmount(0, 500).perform();
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		
	
		OrganisationCreationPage ocp=new OrganisationCreationPage(driver);
		
		
		
		Webdriver_Utility wu=new Webdriver_Utility();
		String OrgExceldata=eu.getExcelDataformatter("Organization", 0, 0)+ju.getrannum();
		wu.getclickelement(driver,ocp.getCreateOrgtext() );
	     Thread.sleep(2000);
		ocp.getOrgNameinputfield().sendKeys(OrgExceldata);
		Thread.sleep(2000);
		wu.getScrollByAmount(driver, 0,400);
		ocp.getSaveOrgButton().click();
		
	    String ActualOrgData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	    System.out.println(ActualOrgData);
	    System.out.println(OrgExceldata);
	    SoftAssert soft = new SoftAssert();
	    soft.assertEquals(ActualOrgData, OrgExceldata);
	    soft.assertAll();
	/*    if(ActualOrgData.contains(OrgExceldata)) {
	    	System.out.println("New orgnaisation created");
	    }else {
	    	System.out.println("fail");
	    }*/
	    
	    /*WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	act.moveToElement(hover).perform();
    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
        //hp.logout(driver);
	}
	
	
	
}