package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Base;

public class HomePage extends Base 
{
	public WebDriver driver;
	public HomePage hp;

	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "StoreLogo")
	WebElement title;

	public void clickLogo() 
	{
		title.click();
	}

}
