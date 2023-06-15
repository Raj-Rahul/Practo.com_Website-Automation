package hackathon.afterinterim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver 
{
	public WebDriver d(String browser)
	{
		WebDriver rj=null;
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\2263071\\Downloads\\chromedriver_win32 (1)");
			rj=new ChromeDriver();
			rj.manage().window().maximize();
			rj.get("https://www.practo.com/");
			return rj;
		}
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\2263071\\Downloads\\chromedriver_win32 (1)");
				rj=new EdgeDriver();
				rj.manage().window().maximize();
				rj.get("https://www.practo.com/");
				return rj;
	}
}
