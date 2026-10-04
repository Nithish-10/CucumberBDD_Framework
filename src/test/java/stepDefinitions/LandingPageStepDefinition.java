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
import pageObjects.LandingPage;
import utils.TestContextSetup;



public class LandingPageStepDefinition {
	public WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	public LandingPage landingPage;
	TestContextSetup testContextSetup;	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
//		testContextSetup.driver= new ChromeDriver();
//		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
	}
	@When("User searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    
	    testContextSetup.LandingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    //testContextSetup.LandingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	    System.out.println(LandingPageProductName+ " is extracted from home page");
	    
	}
	

	@When("Added {string} items of the selected product to cart")
	public void and_added_items_of_the_selected_product_to_cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
}
