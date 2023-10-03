package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Page {

	public WebDriver driver;

	public CheckOut_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first-name']")
	public WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='last-name']")
	public WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='postal-code']")
	public WebElement postalCodeTextbox;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueButton;
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
	public WebElement checkOutInformationText;
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
	public WebElement checkOutOverviewText;
	
	@FindBy(xpath = "//div[@class='checkout_info']")
	public WebElement checkOutInfoForm;

	public void enterFirstName(String firstName) {
		firstNameTextbox.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {
		lastNameTextbox.sendKeys(lastName);
	}

	public void enterPostalCode(String postalCode) {
		postalCodeTextbox.sendKeys(postalCode);
	}

	public void clickCheckOutButton() {
		continueButton.isDisplayed();
		continueButton.click();
	}

}
