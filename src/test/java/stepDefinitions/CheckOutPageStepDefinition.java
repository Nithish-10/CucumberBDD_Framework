package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;



public class CheckOutPageStepDefinition {
	public WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	public CheckOutPage checkoutPage;
	TestContextSetup textContextSetup;	
	public CheckOutPageStepDefinition(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		this.checkoutPage = textContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("User proceed to checkout and validate the {string} items in checkout page")
	public void user_proceed_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
		checkoutPage.checkoutItems();
		Thread.sleep(2000);
	}
	
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
//		Assert.assertTrue(testContextSetup.pageObjectManager.getCheckOutPage().VerifyPromoBtn());
//		Assert.assertTrue(testContextSetup.pageObjectManager.getCheckOutPage().VerifyPlaceOrder());
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}
	
	

	
	
}
