package FrameWork;

import FrameWork.PageObject.CartPage;
import FrameWork.PageObject.CheckoutPage;
import FrameWork.PageObject.ConfirmationPage;
import FrameWork.PageObject.LandingPage;
import FrameWork.PageObject.ProductCatalogue;
import FrameWork.testComponant.Basetest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;

public class errorValidation extends Basetest {
	@Test(groups= {"ErrorHandling"} , retryAnalyzer=Retry.class)
	public void validation() 
	{    
String productName = "ZARA COAT 3";
LandingPage.loginApplication("snehal@gmail.com" , "Snehaladsul11@@");
//LandingPage.getErrorMessage()
Assert.assertEquals("Incorrect email or password", LandingPage.getErrorMessage());
	
	
	}
	
	@Test 
	public void Productvalidation() throws InterruptedException 
	{    
	String productName = "ZARA COAT 3";
	
	ProductCatalogue productCatalogue =LandingPage.loginApplication("snehaladsul@gmail.com" , "Snehaladsul11@@");
			
	List<WebElement> products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage = productCatalogue.goToCartPage();

	Boolean match = cartPage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
//
//	
	
	
	
	
	
	
	
	}

}
