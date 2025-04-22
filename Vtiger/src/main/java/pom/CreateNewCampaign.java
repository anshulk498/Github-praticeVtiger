package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaign {
	WebDriver driver;
	public CreateNewCampaign(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

  @FindBy(xpath = "//a[@name='Campaigns']") private WebElement addCampgain;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']") private WebElement createCampgain;
	
	@FindBy(xpath = "//input[@name='campaignname']") private WebElement inputCampgainname;
	
	@FindBy(xpath = "//select[@name='campaigntype']") private WebElement getcampOptions;

	

	public WebElement getCampdropdownOptions() {
		return getcampOptions;
	}

	public WebElement getInputCampgainname() {
		return inputCampgainname;
	}

	public WebElement getAddCampgain() {
		return addCampgain;
	}

	public WebElement getCreateCampgain() {
		return createCampgain;
	}
//bussiness logic
	public void clickAddCampgain() {
		addCampgain.click();
	}
	
	public void clickCreateCampgain() {
		createCampgain.click();
	}
	
	
}
