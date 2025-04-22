package pratice;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Genric_Utility.BaseClass;
import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganisationCreationPage;
public class CreateOrgWithDataProvider {

	


		
		@Test(dataProvider = "dataproviderfile")
		public  void createOrganisationTest(String name,String phone,String email) throws Throwable {
			WebDriver driver=null;
			WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
			Java_Utility ju=new Java_Utility();
			
			
			
			Property_Utility pu=new Property_Utility();
			
			FileInputStream fis=new FileInputStream("src/test/resources/data.properties");
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
			}
			
			
			
			
			LoginPage lp=new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
			lp.getLoginbutton().click();
			 
			HomePage hp=new HomePage(driver);
			WebElement moretext = driver.findElement(By.xpath("//a[.='More']"));
			Actions act=new Actions(driver);
			Thread.sleep(2000);
			act.moveToElement(moretext).perform();
			Thread.sleep(2000);
			hp.getCreateOrgtext().click();
		  
            Java_Utility JU=new Java_Utility();
            int rannum = ju.getrannum();
		    act.click(driver.findElement(By.xpath("//img[@title='Create Organization...']"))).perform();
		    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name+rannum);
		    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		    driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(email);
		    act.scrollByAmount(0, 500).perform();
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
		
//			OrganisationCreationPage ocp=new OrganisationCreationPage(driver);
//			ocp.createOrg(driver);
//			
		    String ActualOrgData = driver.findElement(By.id("dtlview_Organization Name")).getText();
		    System.out.println(ActualOrgData);
		    if(ActualOrgData.contains(name)) {
		    	System.out.println("New orgnaisation created");
		    }else {
		    	System.out.println("fail");
		    }
		    
		   
	        hp.logout(driver);
	        driver.quit();
		}
		
		@DataProvider
		public Object[][] dataproviderfile(){
			Object[][] obj=new Object[2][3];
			obj[0][0]="puma";
			obj[0][1]="12345";
			obj[0][2]="puma@yopmail.com";
			
			obj[1][0]="nike";
			obj[1][1]="67890";
			obj[1][2]="nike@yopmail.com";
			return obj;
		}
		
		
	}


