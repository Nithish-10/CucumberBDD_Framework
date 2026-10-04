package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	public WebDriver driver;
	By cartBag = By.cssSelector("img[alt='Cart']");
	By proceedToCheckout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(proceedToCheckout).click();
	}	
	
	public Boolean VerifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
}
