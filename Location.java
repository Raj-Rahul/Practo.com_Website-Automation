package hackathon.afterinterim;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Location 
{
	WebDriver driver=null;

	public Location(WebDriver d)
	{
		driver=d;
	}

	public void cleary()
	{
		
		driver.findElement(By.xpath("//input[@data-input-box-id='omni-searchbox-locality']")).clear();
		driver.findElement(By.xpath("//input[@data-input-box-id='omni-searchbox-locality']")).sendKeys("Bangalore");
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.findElement(By.xpath("//div[contains(text(),'Search in entire Bangalore')]")).click();
		}
		
		catch(Exception e)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.findElement(By.xpath("//div[contains(text(),'Bangalore')]")).click();
		}
				
	}
	public void hospital() 
	{
		//WebElement e;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@placeholder='Search doctors, clinics, hospitals, etc.']")).sendKeys("Hospital");
		driver.findElement(By.xpath("//div[@class='c-omni-suggestion-item__content__title' and text()='Hospital']")).click();
		
	}
	public void ratings() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(15000);
		js.executeScript("window.scrollBy(0,3000)");
		
		Set<String> s = new HashSet<String>();
		s.add("//a[contains(text(),'Koshys Hospital')]");
		s.add("//a[contains(text(),'Smiles Institute of Gastroenterology')]");
		s.add("//a[contains(text(),'Manipal Hospitals Yeshwanthpur')]");
		s.add("//a[contains(text(),'Motherhood Hospital')]");
		s.add("//a[contains(text(),'Apollo Spectra Hospitals')]");

		String pw=driver.getWindowHandle();
		
		for(String i:s)
		{
			driver.findElement(By.xpath(i)).click();
			Set<String> cw=driver.getWindowHandles();
			for(String h:cw)
			{
				if(!h.equals(pw))
				{
					driver.switchTo().window(h);
					System.out.println(driver.findElement(By.xpath("//span[@data-qa-id='hospital_name']")).getText());
					System.out.println(driver.findElement(By.xpath("//span[@class='common__star-rating__value']")).getText());
					driver.close();
					driver.switchTo().window(pw);
				}
			}
		}
	}
}
