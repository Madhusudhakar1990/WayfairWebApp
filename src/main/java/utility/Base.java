package utility;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base 
{
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentSparkReporter report;
	public static ExtentReports reprt;
	public static Actions act ;
	
	public Base() 
	{
		
	}
	public static void setProp() throws IOException

	{
		prop = new Properties();
		String filePath = "C:\\Users\\ymadh\\eclipse-workspace\\webAndApp\\src\\main\\java\\utility\\data.properties";
		FileReader fread = new FileReader(filePath);
		prop.load(fread);
	}

	public static WebDriver startBrowser()

	{
		// String browName = (String) prop.get("browser");

		if(driver == null)
		{
		driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//String url = prop.getProperty("url");
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}

	public static void reporting() 
	{
		String reportPath = prop.getProperty("report");
		report = new ExtentSparkReporter(reportPath);
		report.config().setDocumentTitle("Ecom Report");
		report.config().setReportName("details ecom report");

		reprt = new ExtentReports();
		reprt.attachReporter(report);
		reprt.setSystemInfo("Tester", "Madhu");

	}

	public static void stopBrowser() 
	{
		driver.close();

	}
}
