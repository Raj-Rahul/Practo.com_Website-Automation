package hackathon.afterinterim;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;



public class Main 
{
	public WebDriver driver;
	ImpWait iw=new ImpWait();
	Extentreport extentreport=new Extentreport();
	@BeforeClass
	public void before()
	{
		System.out.println("Report will generate after all the test cases are executed:");
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setDriver(@Optional("chrome")String browser)
	{
		Driver dd=new Driver();
		driver=dd.d(browser);
	}
	
	@Test (enabled=false,priority=1)
	public void test1() throws InterruptedException
	{
		//adding name to extent report
		extentreport.TestName("Verifying User Information");
				
		//adding log to extent report
		extentreport.logs("Open browser");
		
		//Creating object for Location class
		Location l=new Location(driver);
		
		extentreport.logs("Clear the text box and enter valid location");
		l.cleary();
		
		extentreport.logs("loading hospital lists");
		
		extentreport.logs("Get the names of the hospitals");
		l.hospital();
		
		extentreport.logs("Get the ratings of the hospitals");
		l.ratings();
	}
	
	@Test (enabled=false,priority=2)
	public void test2() throws IOException
	{
		extentreport.TestName("Getting Detail of TOP Cities");
		
		extentreport.logs("Open browser");
		
		
		//creating object for cities class
		Cities c=new Cities(driver);
		extentreport.logs("city options clicking");
		c.navTest();
		iw.Wait(driver);
		extentreport.logs("Fetching names of top cities shown");
		c.cityName();
		extentreport.logs("Extracting data");
	}
	
	@Test (enabled=true,priority=3)
	public void test3() throws IOException
	{
		extentreport.TestName("Form Filling");
		
		//creating object for corporates class
		Corporates c=new Corporates(driver);
		c.nav();
		extentreport.logs("Opening the browser");
		extentreport.logs("Moving to another tab");
		extentreport.logs("Inputs");
		c.formfilling();
		extentreport.logs("Wrong Input");
		extentreport.logs("Screenshot");
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	@AfterClass
	public void after() throws IOException
	{
		extentreport.Flush();
	}
}
