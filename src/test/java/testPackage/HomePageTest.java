package testPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.HomePage;
import utility.Base;

public class HomePageTest 
{

	public  WebDriver driver;
	public HomePage hp;
	

	@BeforeTest
	public void enginStart() throws IOException
	{
		System.out.println("Engine started");
		Base.setProp();
		Base.reporting();
		this.driver = Base.startBrowser();
		System.out.println("Engine running");
	}
	
	
	@Test
	public void checkLogo() throws InterruptedException
	{
		hp  = new HomePage(driver);
		hp.clickLogo();
		Thread.sleep(5000);
		
	}
	
	
	@AfterTest
	public void stopEngine()
	{
		Base.stopBrowser();
	}
	
	
	
}
