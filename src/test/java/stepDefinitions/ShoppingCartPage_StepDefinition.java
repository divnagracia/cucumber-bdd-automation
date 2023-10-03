package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOut_Page;
import pageObjects.Inventory_Page;
import pageObjects.Login_Page;
import pageObjects.ShoppingCart_Page;
import utils.TestContextSetup;

public class ShoppingCartPage_StepDefinition {

	TestContextSetup testContextSetup;
	Inventory_Page inventoryPage;
	ShoppingCart_Page shoppingCartPage;
	CheckOut_Page checkOutPage;

	public ShoppingCartPage_StepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.shoppingCartPage = testContextSetup.pageObjectManager.getShoppingCartPage();
		this.inventoryPage = testContextSetup.pageObjectManager.getInventoryPage();
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}

	@When("I click Shopping Cart Badge")
	public void click_shopping_cart_badge() {
		inventoryPage.clickShoppingCart();
	}

	@And("click Checkout button")
	public void click_checkout() {
		shoppingCartPage.clickCheckOutButton();
	}

	@Then("I am in Checkout Information page")
	public void iam_in_checkout_information_page() {
		Assert.assertEquals(checkOutPage.checkOutInformationText.getText(), "Checkout: Your Information");
	}
}
