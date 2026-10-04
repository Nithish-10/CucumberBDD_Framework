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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;
 
public class OfferPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;	
PageObjectManager pageObjectManager;
/*Single responsibility principle: each step definition class should have only one responsibility. 
This class is responsible for the offer page related step definitions, while the landing page related step definitions are in a separate class. 
This makes the code more organized and easier to maintain.*/

/*Loosly coupled:  classes should be going to enhance n the future */

//tightly coupled: classes are dependent on each other and changes in one class can affect the other class.

/*Factory design pattern: it is a design pattern that provides an interface for creating objects in a super class,
 *  but allows subclasses to alter the type of objects that will be created.
 */


public OfferPageStepDefinition(TestContextSetup testContextSetup) {
	this.testContextSetup = testContextSetup;

}

	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		switchToOffersPage();
		
		OffersPage offerPage = testContextSetup.pageObjectManager.getOffersPage();;
		offerPage.searchItem(shortName);	
	    //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    offerPageProductName = offerPage.getProductName().trim();
	    //offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	    
	}
	
	public void switchToOffersPage() {
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) 
		//PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.selectTopDealsPage();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		
		testContextSetup.genericUtils.SwitchWindowToChild();
///	    Set<String> s1=testContextSetup.driver.getWindowHandles();
///	    Iterator<String> i1=s1.iterator();
///	    String parentWindow = i1.next();
///	    String childWindow = i1.next();
///     testContextSetup.driver.switchTo().window(childWindow);
	}

	@And("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageProductName, testContextSetup.LandingPageProductName);
	}
	
}
