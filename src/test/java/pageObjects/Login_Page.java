package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	public WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@id='login-button']")
	public WebElement loginButton;

	public void enterUserName(String userName) {
		usernameField.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		passwordField.sendKeys(passWord);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getTitleLoginPage()
	{
		return driver.getTitle();
	}
	

}
