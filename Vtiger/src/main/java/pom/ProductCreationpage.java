package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.Excel_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.Webdriver_Utility;

public class ProductCreationpage {
    WebDriver driver;
    
    Excel_Utility eu=new Excel_Utility();
    
	public ProductCreationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']") private WebElement addProduct;
	
	@FindBy(xpath = "//input[@name='productname']") private WebElement enterProductName;
	
	@FindBy(xpath = "(//div[@align='center']//input[@type='submit'])[2]") private WebElement saveproduct;
	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getEnterProductName() {
		return enterProductName;
	}

	public WebElement getSaveproduct() {
		return saveproduct;
	}
	
	//bussines logic
	public void productClick(WebDriver driver) {
		addProduct.click();
	}

	
	
	
	

}
