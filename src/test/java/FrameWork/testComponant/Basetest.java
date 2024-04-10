package FrameWork.testComponant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FrameWork.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public LandingPage LandingPage;
public WebDriver driver;
public WebDriver initalizationDriver() throws IOException {
	
	//properties class-read global properties
	Properties prop=new Properties();
	//FileInputStream fis = new  FileInputStream("C:\\Users\\rohit\\eclipse-workspace\\Slenium\\src\\main\\java\\FrameWork\\resources\\Globaldata.properties");
	FileInputStream fis = new  FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\FrameWork\\resources\\Globaldata.properties");
	prop.load(fis);
	String browsername=prop.getProperty("browser");
	
	if (browsername.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    
	}
	
	else if(browsername.equalsIgnoreCase("Edge"))
	{//edge
	System.setProperty("webdriver.edge.driver","edge.exe");
 driver=new EdgeDriver();
		
	}
	else if(browsername.equalsIgnoreCase("firefox"))   //greckodriver
	{//firefox
	System.setProperty("webdriver.firefox.driver","firefox.exe");
	  driver=new FirefoxDriver();	
}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
}
@BeforeMethod(alwaysRun=true)
public LandingPage launchApplication() throws IOException {
	
driver=	initalizationDriver();
 LandingPage = new LandingPage(driver);
LandingPage.goTo();
return LandingPage	;
}
@Test
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	
	
}



@AfterMethod(alwaysRun=true)
public void closeDriver() {
	
driver.close();	
}
}
