package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_Page {

	public WebDriver driver;
	String dynamicItem;

	public Inventory_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	public WebElement productsText;

	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeButton;
	
	@FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
	public WebElement shoppingCartBadgeQuantity;
	

	public void addToCartItem(String item) {
		driver.findElement(By.xpath("//div[@class = 'inventory_item_name' and text()='" + item
				+ "']/following::button[@class = 'btn btn_primary btn_small btn_inventory']")).click();
	}

	public boolean verifyRemoveButton(String item) {
		return driver.findElement(By.xpath("//div[@class = 'inventory_item_name' and text()='" + item
				+ "']/following::button[@class = 'btn btn_secondary btn_small btn_inventory']")).isEnabled();
	}
	
}
