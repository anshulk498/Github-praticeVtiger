package Genric_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;

@Listeners(Genric_Utility.ListnerImplementation.class
		)
public class BaseClass {
	public WebDriver driver;
public static WebDriver sdriver;//this is used for changing web driver when testscript get fail and invoke LISTNER method from genric utility
	Property_Utility pu=new Property_Utility();
	//@BeforeSuite(groups = {"smoketest","sanitytest"})
	 @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("database connection started");
	 
	    }
	// @BeforeTest(groups = {"smoketest","sanitytest"})
	@BeforeTest
	public void beforeTest() {
		System.out.println("parallel excuation started");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","sanitytest"})
	//@BeforeClass
	public void beforeClass() throws Throwable {
		//launching browser
		
		
		
		String BROWSER=pu.getKeyValue("browser");
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
		}
		sdriver=driver;
	}
	//@BeforeMethod(groups = {"smoketest","sanitytest"})
	@BeforeMethod
	public void beforeMethod() throws Throwable {
		//login in app
		
		String USERNAME = pu.getKeyValue("username");
		String PASSWORD=pu.getKeyValue("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		lp.getLoginbutton().click();
		
	}
	
	//@AfterMethod(groups = {"smoketest","sanitytest"})
	@AfterMethod
	public void afterMethod() {
		System.out.println("logout into app");
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		
	}
	
	//@AfterClass(groups = {"smoketest","sanitytest"})
	@AfterClass
	public void afterClass() {
		System.out.println("launching browser closed");
	}
	//@AfterTest(groups = {"smoketest","sanitytest"})
	@AfterTest
	public void afterTest() {
		System.out.println("parallel excuation closed");
	}
	//@AfterSuite(groups = {"smoketest","sanitytest"})
    @AfterSuite
	public void aftersuite() {
		System.out.println("database connection closed");
	}
	
	

	
	
	
	
}
