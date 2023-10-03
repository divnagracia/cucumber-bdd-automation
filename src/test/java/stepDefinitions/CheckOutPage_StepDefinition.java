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

	@Then("redirected to Checkout Review page")
	public void redirected_to_checkout_review_page() {
		Assert.assertEquals(checkOutPage.checkOutOverviewText.getText(), "Checkout: Overview");
	}
}
