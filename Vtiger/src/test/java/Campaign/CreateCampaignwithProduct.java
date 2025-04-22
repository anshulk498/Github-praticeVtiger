package Campaign;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
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
import org.testng.asserts.SoftAssert;

import Genric_Utility.BaseClass;
import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Property_Utility;
import Genric_Utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateNewCampaign;
import pom.HomePage;
import pom.ProductCreationpage;

public class CreateCampaignwithProduct extends BaseClass {
	
	 @Test
	public  void createCampaignwithProduct() throws Throwable {
		//WebDriver driver=null;
	//	WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
//		Random ran=new Random();
//		int RANNUM = ran.nextInt(1000);
		Java_Utility ju=new Java_Utility();
		int RANNUM=ju.getrannum();
		Webdriver_Utility wu=new Webdriver_Utility();
		
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
		String productExceldata=eu.getExcelDataformatter("Product", 0, 0)+RANNUM;
		/*FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book = WorkbookFactory.create(fis1);
		Sheet SHEET = Book.getSheet("Product");
		Row ROW = SHEET.getRow(0);
		Cell CELL = ROW.getCell(0);
		String porductExceldata = CELL.getStringCellValue()+RANNUM;*/
		
		/*driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
	   /* Actions act=new Actions(driver);
	    driver.findElement(By.xpath("//a[.='Products']")).click();
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();*/
		HomePage hp=new HomePage(driver);
		hp.clickProducttext(driver);
		ProductCreationpage pcp=new ProductCreationpage(driver);
		pcp.productClick(driver);
	   // wb.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='productname']")))).sendKeys(porductExceldata);
        wu.getExplicitWait(driver, driver.findElement(By.xpath("//input[@name='productname']")));
        //driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(porductExceldata);
        pcp.getEnterProductName().sendKeys(productExceldata);
        wu.getOptions(driver, driver.findElement(By.xpath("//select[@name='productcategory']")),"Software");
        /*Select sel=new Select(driver.findElement(By.xpath("//select[@name='productExceldata']")));
	    List<WebElement> options = sel.getOptions();
	    for(int i=0;i<options.size();i++) {
	    	System.out.println(options.get(i).getText());
	    	if(options.get(i).getText().contains("Software")) {
	    		options.get(i).click();
	    		break;
	    	}
	    }*/
	  
	   // act.scrollByAmount(0, 700).perform();
        wu.getScrollByAmount(driver, 0, 700);
	   // act.click( driver.findElement(By.xpath("(//input[@type='file'])[1]"))).perform();
        Thread.sleep(3000);
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
		 Thread.sleep(2000);
		 
	   // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	    pcp.getSaveproduct().click();
	    wu.getScrollByAmount(driver, 0, -700);
	 
		 Thread.sleep(2000);
	    
	   /* FileInputStream fis2=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook Book1 = WorkbookFactory.create(fis2);
		Sheet SHEET1 = Book1.getSheet("Campaigns");
		Row ROW1 = SHEET1.getRow(0);
		Cell CELL1 = ROW1.getCell(0);
		String CampgainExceldata = CELL1.getStringCellValue()+RANNUM;*/
	    String CampgainExceldata=eu.getExcelDataformatter("Campaigns", 0, 0)+RANNUM;
	    
		// act.moveToElement(driver.findElement(By.xpath("//a[.='More']"))).perform();
	        hp.moretext(driver);//click on more text
	
		   /* driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();*/
	        CreateNewCampaign cnc=new CreateNewCampaign(driver);
	        cnc.clickAddCampgain();
	        cnc.clickCreateCampgain();
		    //wu.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='campaignname']"))))sendKeys(CampgainExceldata);
		  WebElement inputCampName = cnc.getInputCampgainname();
	        wu.getExplicitWait(driver, inputCampName);
		  //  driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CampgainExceldata);
	        inputCampName.sendKeys(CampgainExceldata);
	        
		   // wu.getOptions(driver, driver.findElement(By.xpath("//select[@name='campaigntype']")),"Email");
	        wu.getOptions(driver, cnc.getCampdropdownOptions(),"Email");
		    /*Select sel1=new Select(driver.findElement(By.xpath("//select[@name='campaigntype']")));
		    System.out.println("hi");
		    List<WebElement> options1 = sel1.getOptions();
		    for(int i=0;i<options.size();i++) {
		    	System.out.println(options1.get(i).getText())
		    	if(options1.get(i).getText().contains("Email")) {
		    		options1.get(i).click();
		    		break;
		  
		    }*/
		    
		   
		    driver.findElement(By.xpath("//img[@alt='Select']")).click();
		  
		    
		    wu.switchWindow(driver, "Products&action");
		    /*Set<String> wd = driver.getWindowHandles();
		    Iterator<String> allid = wd.iterator();
		    
		    while(allid.hasNext()) {
		    	String window = allid.next();
		    	driver.switchTo().window(window);
		    	
				String title = driver.getTitle();
		    	
		    	if(title.contains("Products&action")) {
		    		break;
		    	}
		    }*/
		    
		    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productExceldata);
		    driver.findElement(By.xpath("//input[@type='button']")).click();
		    driver.findElement(By.xpath("//a[.='"+productExceldata+"']")).click();
		    wu.switchWindow(driver, "Campaigns&action");
		    
		    /*Set<String> wd1 = driver.getWindowHandles();
		    Iterator<String> allid1 = wd1.iterator();
		    
		    while(allid1.hasNext()) {
		    	String window1 = allid1.next();
		    	driver.switchTo().window(window1);
		    	
				String title1 = driver.getTitle();
		    	
		    	if(title1.contains("Campaigns&action")) {
		    		break;
		    	}
		    }*/
		    
		    Thread.sleep(2000);
		    //act.scrollByAmount(0, 500).perform();
		    wu.getScrollByAmount(driver, 0, 500);
		   // act.click(driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"))).perform();
		    wu.getclickelement(driver, driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")));
		    Thread.sleep(2000);
		    String ActualData = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		    System.out.println(ActualData);
		    SoftAssert soft = new SoftAssert();
	    	soft.assertEquals(ActualData, CampgainExceldata);
	    	soft.assertAll();
		  /*  if(ActualData.equalsIgnoreCase(CampgainExceldata)) {
	    		System.out.println("pass");
	    	}else {
	    		System.out.println("fail");
	    	}*/
	    //	act.scrollByAmount(0, -500);
		    System.out.println("HI");
		    wu.getScrollByAmount(driver, 0, -500);
	    	/*WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    	act.moveToElement(hover).perform();
	    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		   // hp.logout(driver);
		    }
		    
		  

	}
