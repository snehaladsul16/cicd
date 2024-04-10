package snehal.stepDefination;
import FrameWork.PageObject.ProductCatalogue;
import FrameWork.PageObject.CartPage;
import FrameWork.PageObject.ConfirmationPage;

import java.io.IOException;
import java.util.List;
import FrameWork.PageObject.CheckoutPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameWork.PageObject.LandingPage;
import FrameWork.testComponant.Basetest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImplementation extends Basetest {
	
	public LandingPage LandingPage;
	public ProductCatalogue productCatalogue;
	public CheckoutPage checkoutPage;
	public CartPage cartPage ;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce website")
	public void I_landed_on_Ecommerce_website() throws IOException {
		
		LandingPage=launchApplication();
		
	}

	@Given ("^login with username (.+)and password(.+)$")
	public void login_with_username_and_password(String name, String password) {
		
		productCatalogue = LandingPage.loginApplication(name, password );
		
	}
	
	@When("^I add product(.+)in Cart$")
	public void I_add_product_in_Cart(String productName) throws InterruptedException {
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	}
	
	@And ("^checkout (.+)and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();	
	}
	@Then("{String} msg is displayed ON confirmationPage")	
	public void msg_is_displayed_ON_confirmationPage(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}

@Then("{String}msg is displayed")
public void somthing_msg_is_displayed(String StringArgs1){
	Assert.assertEquals("Incorrect email or password", LandingPage.getErrorMessage());
	driver.close();
	
}
}
