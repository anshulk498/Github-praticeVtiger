package Product;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Genric_Utility.BaseClass;
import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Property_Utility;
import Genric_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;
import pom.ProductCreationpage;

public class CreateProductTest extends BaseClass{
	
	@Test
	public  void createProductTest() throws Throwable {
		WebDriver driver=null;
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
		Java_Utility ju=new Java_Utility();
		int RANNUM = ju.getrannum();
		/*Random ran=new Random();
		int RANNUM = ran.nextInt(1000);*/
		Webdriver_Utility wu=new Webdriver_Utility();
		Property_Utility pu=new Property_Utility();
		String BROWSER=pu.getKeyValue("browser");
		String URL=pu.getKeyValue("url");
		String USERNAME = pu.getKeyValue("username");
		String PASSWORD=pu.getKeyValue("password");
		/*FileInputStream fis=new FileInputStream("src/test/resources/data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");*/
		
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
		
		Excel_Utility eu=new Excel_Utility();

		/*FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book = WorkbookFactory.create(fis1);
		Sheet SHEET = Book.getSheet("Product");
		Row ROW = SHEET.getRow(0);
		Cell CELL = ROW.getCell(0);
		String productExceldata = CELL.getStringCellValue()+RANNUM;*/
		
		/*driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		lp.getLoginbutton().click();
		//driver.findElement(By.xpath("//a[.='Products']")).click();
		HomePage hp=new HomePage(driver);
	    hp.getGetproducttext().click();
	    ProductCreationpage pcp=new ProductCreationpage(driver);
        pcp.productClick(driver);
	    
	    wu.getExplicitWait(driver, driver.findElement(By.xpath("//input[@name='productname']")));
		String productexceldata = eu.getExcelDataformatter("Product", 0, 0)+ju.getrannum();
		pcp.getEnterProductName().sendKeys(productexceldata);
		wu.getScrollByAmount(driver, 0, 500);
		pcp.getSaveproduct().click();
	   /* Thread.sleep(2000);
	    System.out.println("hi");
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
        System.out.println("bye");
        /*wb.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='productname']")))).sendKeys(porductExceldata);
	    wu.getExplicitWait(driver, driver.findElement(By.xpath("//input[@name='productname']")));
	    driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(porductExceldata);
	   
	    wu.getOptions(driver, driver.findElement(By.xpath("//select[@name='productcategory']")), "Software");
	   /* Select sel=new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));
	    List<WebElement> options = sel.getOptions();
	    for(int i=0;i<options.size();i++) {
	    	System.out.println(options.get(i).getText());
	    	if(options.get(i).getText().contains("Software")) {
	    		options.get(i).click();
	    		break;
	    	}
	    }
	   // Actions act=new Actions(driver);
	    //act.scrollByAmount(0, 700).perform();
	  //  act.click( driver.findElement(By.xpath("(//input[@type='file'])[1]"))).perform();
      //  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//input[@name='file_1']")).sendKeys("C:\\Users\\John\\Downloads\\notes of classic selenium pdf(anshul).pdf");

//	    Robot r=new Robot();
//	    StringSelection str=new StringSelection("C:\\Users\\John\\Downloads\\notes of classic selenium pdf(anshul).pdf");
//	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//	   
//	   r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_V);
//		
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
	   
	    driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
	    String ActualData = driver.findElement(By.id("dtlview_Product Name")).getText();
    	System.out.println(ActualData);
    	System.out.println(productexceldata);
    	if(ActualData.equalsIgnoreCase(productexceldata)) {
    		System.out.println("pass");
    	}else {
    		System.out.println("fail");
    	}
    	
    	/*WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	act.moveToElement(hover).perform();
    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
	    
	
}
	@Test
	public void m1() {
		System.out.println("METHOD RUNNING");
	}
}