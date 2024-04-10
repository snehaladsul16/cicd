package FrameWork;

import FrameWork.PageObject.CartPage;
import FrameWork.PageObject.CheckoutPage;
import FrameWork.PageObject.ConfirmationPage;
import FrameWork.PageObject.LandingPage;
import FrameWork.PageObject.ProductCatalogue;
import FrameWork.testComponant.Basetest;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import FrameWork.PageObject.OrderPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends Basetest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "PurchesOrder" })
	public void submitorder(String Email, String Pass, String productName) throws IOException, InterruptedException {
{
		ProductCatalogue productCatalogue = LandingPage.loginApplication(Email, Pass);
		List<WebElement>products=productCatalogue.getProductList();
		//productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}}

 @Test(dependsOnMethods= {"submitorder"})
	public void orderHistoryTest() {

		ProductCatalogue productCatalogue = LandingPage.loginApplication("snehaladsul@gmail.com", "Snehaladsul11@@");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));

	}
 
// public String grtScreenshot(String testCasename) throws IOException {
//	 
//	TakesScreenshot ts=(TakesScreenshot)driver;
//	File src=ts.getScreenshotAs(OutputType.FILE);
//	File dest=new File(System.getProperty("user.dir")+"reports"+ testCasename +".png");
//	Files.copy(src, dest);
// return System.getProperty("user.dir")+"reports"+ testCasename +".png";
//
//}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "snehaladsul@gmail.com", "Snehaladsul11@@", "ZARA COAT 3" },
				{ "rohitnalkar@gmail.com ","Snehaladsul11@@", "ADIDAS ORIGINAL" } };
			

	}

}
