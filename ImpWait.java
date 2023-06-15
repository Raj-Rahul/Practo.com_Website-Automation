package hackathon.afterinterim;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class ImpWait 
{
	WebDriver driver=null;
	
	public void Wait(WebDriver d)
	{
		driver=d;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
}
