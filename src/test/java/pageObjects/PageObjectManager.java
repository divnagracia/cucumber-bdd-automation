package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {


	public WebDriver driver;
	public Login_Page loginPage;
	public Inventory_Page inventoryPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public Login_Page getLoginPage() {

		loginPage = new Login_Page(driver);
		return loginPage;
	}

	public Inventory_Page getInventoryPage() {

		inventoryPage = new Inventory_Page(driver);
		return inventoryPage;
	}
}
