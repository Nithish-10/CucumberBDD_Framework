package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	private LandingPage landingPage;
	private OffersPage offersPage;
	public CheckOutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}

	public CheckOutPage getCheckOutPage() {
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

}
