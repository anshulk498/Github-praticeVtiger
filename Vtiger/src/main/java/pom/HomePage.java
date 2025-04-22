package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.Webdriver_Utility;

public class HomePage {
   
    
    public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='More']") private WebElement moretext;
	
	@FindBy(xpath = "//a[.='Products']") private WebElement producttext;
	
	@FindBy(xpath = "//a[@name='Campaigns']") private WebElement Campaignstext;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']//a[.='Organizations']") private WebElement createOrgtext;
	
	@FindBy(xpath = "//img[@title='Create Product...']") private WebElement createProducttext;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement profileImage;
	
	@FindBy(xpath = "//a[.='Sign Out']") private WebElement logouttext;
	
	public WebElement getMoretext() {
		return moretext;
	}

	
	public WebElement getGetproducttext() {
		return producttext;
	}

	public WebElement getCampaignstext() {
		return Campaignstext;
	}

	public WebElement getCreateOrgtext() {
		return createOrgtext;
	}

	public WebElement getCreateProducttext() {
		return createProducttext;
	}

	public WebElement getProfileImage() {
		return profileImage;
	}

	public WebElement getLogouttext() {
		return logouttext;
	}
//bussiness logic
	public void moretext(WebDriver driver) {
		//moretext.click();
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.getMovetoElement(driver, moretext);
		
	}
	
	public void clickProducttext(WebDriver driver) {
		producttext.click();
		
	}
	
	public void logout(WebDriver driver) {
		//act.moveToElement(hover).perform();
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.getMovetoElement(driver, profileImage);
    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
	
	
	
}
