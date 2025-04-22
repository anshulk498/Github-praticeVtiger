package Genric_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {
	
	
	
	/**
	 * this method is used for wait to click on ui
	 */
	public void getImplicaitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method is used for wait to until highlighted element not shown
	 */
	
		public void getExplicitWait(WebDriver driver, WebElement target) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Selenium 4 constructor change
	        wait.until(ExpectedConditions.elementToBeClickable(target));
	    
	}
		
	
	/**
	 * this method is used for maximize the window
	 */
	public void getMaximized(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used for minimize the window
	 */
	public void getMinimized(WebDriver driver) {
		driver.manage().window().minimize();
	}
    
	/**
	 * this method is used for scrolling the window
	 */
	public void getScrollByAmount(WebDriver driver,int x,int y) {
		Actions act=new Actions( driver);
		act.scrollByAmount(x, y).perform();	
	}

	/**
	 * this method is used for mousehover actions on web page
	 */
	public void getMovetoElement(WebDriver driver,WebElement target) {
		Actions act=new Actions( driver);
		act.moveToElement(target).perform();
	}
	
	/**
	 * this method is used for doubleclick actions on web page
	 */
	public void getDoubleClick(WebDriver driver ,WebElement target) {
		Actions act=new Actions( driver);
		act.doubleClick(target).perform();
		
	}
	
	/**
	 * this method is used for rightclick actions on web page
	 */
	public void getRightClick(WebDriver driver ,WebElement target) {
		Actions act=new Actions( driver);
		act.contextClick(target).perform();
	}
	
	/**
	 * this method is used for drag and drop actions on web page
	 */
	public void getDragDrop(WebDriver driver ,WebElement source,WebElement target) {
		Actions act=new Actions( driver);
		act.dragAndDrop(source, target).perform();
	}
	/**
	 * this method is used for click on webelement by actions class
	 */
	public void getclickelement(WebDriver driver ,WebElement target) {
		Actions act=new Actions( driver);
		act.click(target).perform();
	}
	
	/**
	 * this method is used for swtiching for multiple windows
	 */
	 public void switchWindow(WebDriver driver, String partialWindowTitle) {
	       
	        Set<String> windowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = windowHandles.iterator();

	        while (iterator.hasNext()) {
	            String windowHandle = iterator.next();

	            
	            String title=driver.switchTo().window(windowHandle).getTitle();

	            if (title.contains(partialWindowTitle)) {
	                System.out.println("Switched to window with title: " + title);
	                break; 
	            }
	        }
	    }
	/**
	 * this method is used for accept the popup 
	 */
		public void acceptAlertpopup(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		
		/**
		 * this method is used for dismiss the popup 
		 */
			public void dismissAlertpopup(WebDriver driver) {
				driver.switchTo().alert().dismiss();
				
			}
			/**
			 * this method is used for send key in the text field 
			 */
			public void getSendkeys(WebDriver driver,WebElement target,String text) {
				target.click();
				target.clear();
				target.sendKeys(text);
				
			}
			
	/**
	 * this method is used to getoptions from drop-down
	 */
			public void getOptions(WebDriver driver, WebElement target, String text) {
		        
		        Select sel1 = new Select(target);
		        List<WebElement> option1 = sel1.getOptions();
		        for (int i = 0; i < option1.size(); i++) {
		            
		            System.out.println(option1.get(i).getText());
		            if (option1.get(i).getText().contains(text)) {
		                option1.get(i).click(); 
		                break; 
		            }
		        }
		    }
    
    }


