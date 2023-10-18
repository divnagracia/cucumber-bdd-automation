package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
	public WebElement itemTotalText;

	@FindBy(css = ".inventory_item_price")
	public List<WebElement> item_priceText;

	@FindBy(css = ".inventory_item_name")
	public List<WebElement> item_nameText;

	@FindBy(css = ".inventory_item_desc")
	public List<WebElement> item_descriptionText;
	
	@FindBy(xpath = "//div[@class='summary_tax_label' and text()='Tax: $']")
	public WebElement taxInfoText;
	
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label' and text()='Total: $']")
	public WebElement totalText;

	@FindBy(xpath = "//button[@id='finish']")
	public WebElement finishButton;
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Complete!')]")
	public WebElement checkOutCompleteText;
	
	@FindBy(xpath = "//div[@id='checkout_complete_container']")
	public WebElement checkOutCompleteContainer;
	
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

	public double verifyTotalSumofPrice() {
		double price = 0;
		for (WebElement element : item_priceText) {
			String priceText = element.getText().replace("$", "");
			price += Double.parseDouble(priceText);
		}
		return price;
	}

	public int verify_and_count_Item_Name() {
		System.out.println(item_nameText.size() + "" + item_descriptionText.size() + "" + item_priceText.size());
		if (item_nameText.size() == item_descriptionText.size()
				&& item_descriptionText.size() == item_priceText.size()) {
			return item_nameText.size();
		} else
			// If the 3 lists are not equal, return -1
			return -1;
	}

	public double verify_overallTotal() {
      double item_total = verifyTotalSumofPrice();
      String taxInfo = taxInfoText.getText().replace("Tax: $", "");
      double totalPrice = item_total + Double.parseDouble(taxInfo);
      return totalPrice;
	}

}
