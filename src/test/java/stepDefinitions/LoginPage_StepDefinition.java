package stepDefinitions;

import org.testng.Assert;

import pageObjects.Login_Page;
import pageObjects.Inventory_Page;
import utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage_StepDefinition {
	
	TestContextSetup testContextSetup;
	Login_Page loginPage;
	Inventory_Page inventoryPage;

	public LoginPage_StepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.loginPage =testContextSetup.pageObjectManager.getLoginPage();
		this.inventoryPage=testContextSetup.pageObjectManager.getInventoryPage();
	}

	@Given("I am on the Login page")
	public void i_am_on_the_Login_page(){
     Assert.assertTrue(loginPage.getTitleLoginPage().contains("Swag Labs"));
	}

	@When("I enter username {string}")
	public void i_enter_username_as(String arg1) throws Throwable {
		loginPage.enterUserName(arg1);
	}

	@And("I enter password {string}")
	public void i_enter_password_as(String arg1) throws Throwable {
		loginPage.enterPassword(arg1);
	}

	@When("click on Login button")
	public void click_on_login_button() {
	    loginPage.clickLoginButton();
	}
	 
	@Then("I am successfully logged in")
	public void i_am_already_logged_in() throws Throwable {
		Assert.assertTrue(inventoryPage.productsText.isDisplayed());
	}

	
}