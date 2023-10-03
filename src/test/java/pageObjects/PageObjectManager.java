package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {


	public WebDriver driver;
	public Login_Page loginPage;
	public Inventory_Page inventoryPage;
	public ShoppingCart_Page shoppingCartPage;
	public CheckOut_Page checkOutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		//should I put PageFactory.initElements(driver, this); ?
	}

	public Login_Page getLoginPage() {

		loginPage = new Login_Page(driver);
		return loginPage;
	}

	public Inventory_Page getInventoryPage() {

		inventoryPage = new Inventory_Page(driver);
		return inventoryPage;
	}
	
	public ShoppingCart_Page getShoppingCartPage() {

		shoppingCartPage = new ShoppingCart_Page(driver);
		return shoppingCartPage;
	}
	public CheckOut_Page getCheckOutPage() {

		checkOutPage = new CheckOut_Page(driver);
		return checkOutPage;
	}
}
