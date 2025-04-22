package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Webdriver_Utility;

public class OrganisationCreationPage {
	
	public OrganisationCreationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement Orgtext;
	
	@FindBy(xpath = "//input[@name='accountname']") private WebElement OrgNameinputfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement SaveOrgButton;
	 
	 @FindBy(xpath = "//td[@class='tabUnSelected']//a[.='Organizations']") private WebElement CreateOrgtext;

	public WebElement getCreateOrgtext() {
		return Orgtext;
	}

	public WebElement getOrgNameinputfield() {
		return OrgNameinputfield;
	}

	public WebElement getSaveOrgButton() {
		return SaveOrgButton;
	}
  
	public WebElement getOrgtext() {
		return CreateOrgtext;
	}
	
	




}
