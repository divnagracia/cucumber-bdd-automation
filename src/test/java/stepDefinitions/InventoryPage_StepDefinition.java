package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Inventory_Page;
import utils.TestContextSetup;

public class InventoryPage_StepDefinition {
	
	TestContextSetup testContextSetup;
	Inventory_Page inventoryPage;

	public InventoryPage_StepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.inventoryPage=testContextSetup.pageObjectManager.getInventoryPage();
	}
	@Given("I am in Products List page")
	public void i_am_in_products_list_page() {
		Assert.assertEquals(inventoryPage.productsText.getText(),"Products");
	}
	@When("^click Add to Cart to a selected (.+)$")
	public void click_add_to_cart_to_a_selected_(String item) {
	   inventoryPage.addToCartItem(item);
	}
	@Then("^(.+) reflected in cart$")
	public void quantity_reflected_in_cart(String item) {
	Assert.assertEquals(inventoryPage.shoppingCartBadgeQuantity.getText(), item);
	}
	@And("^(.+) has remove button$")
	public void name2_has_remove_button(String item) {
	    Assert.assertTrue(inventoryPage.verifyRemoveButton(item));
	}
}
