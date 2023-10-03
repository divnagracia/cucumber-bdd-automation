package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page {

	public WebDriver driver;

	public ShoppingCart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement checkOutButton;


	public void clickCheckOutButton() {
		checkOutButton.click();
	}
	

	

}
