package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(css  = "input[name='user_name']") private WebElement usernamefield;
	
	@FindBy(css  = "input[name='user_password']") private WebElement passwordfield;
	
	@FindBy(id   = "submitButton") private WebElement loginbutton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	
	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public WebElement getPasswordfield() {
		return passwordfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public void login(String username,String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);	
	}

}
