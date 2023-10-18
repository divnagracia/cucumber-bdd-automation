package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOut_Page;
import pageObjects.ShoppingCart_Page;
import utils.TestContextSetup;

public class CheckOutPage_StepDefinition {

	TestContextSetup testContextSetup;
	CheckOut_Page checkOutPage;
	ShoppingCart_Page shoppingCartPage;

	public CheckOutPage_StepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}

//	@Given("I am in Checkout Information page")
//	public void i_am_in_checkout_information_page() {
//		Assert.assertEquals(checkOutPage.checkOutInformationText.getText(), "Checkout: Your Information");
//	}

	@When("^I enter firstName (.+)$")
	public void i_enter_firstname(String firstName) {
		checkOutPage.enterFirstName(firstName);
	}

	@And("^enter lastName (.+)$")
	public void enter_lastname(String lastName) {
		checkOutPage.enterLastName(lastName);
	}

	@And("^enter postalCode (.+)$")
	public void enter_postalcode(String postalCode) {
		checkOutPage.enterPostalCode(postalCode);
	}

	@And("click Continue")
	public void click_continue() {
		checkOutPage.clickCheckOutButton();
	}

	@Then("I am in Checkout Review page")
	public void iam_in_checkout_review_page() {
		Assert.assertEquals(checkOutPage.checkOutOverviewText.getText(), "Checkout: Overview");
	}

	@When("I verify the no. of item name, item description and price are displayed")
	public void i_verify_the_item_name_item_description_and_item_price_are_equal_from_the_inventory_page() {
		Assert.assertEquals(checkOutPage.verify_and_count_Item_Name(),2);
	}

	@And("verify item total is correct")
	public void verify_item_total_is_correct() {
		Assert.assertEquals("Item total: $"+checkOutPage.verifyTotalSumofPrice(),checkOutPage.itemTotalText.getText());
		}

	@And("verify the tax info and total info are available and correct")
	public void verify_the_tax_info_and_total_info_are_available() {
		Assert.assertEquals("Total: $"+checkOutPage.verify_overallTotal(),checkOutPage.totalText.getText());
	}

	@And("click Finish")
	public void click_finish() {
		checkOutPage.finishButton.isDisplayed();
		checkOutPage.finishButton.click();
	}

	@Then("Checkout is complete with validation message displayed")
	public void checkout_is_complete() {
		Assert.assertTrue(checkOutPage.checkOutCompleteContainer.isDisplayed());
	}
}

