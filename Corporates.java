package hackathon.afterinterim;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Corporates 
{
	Properties p = new Properties();
	WebDriver driver=null;
	
	public Corporates(WebDriver d) throws IOException
	{
		driver =d;
		FileReader reader = new FileReader("config.properties");
        p.load(reader);
	}
	
	public void nav()
	{
		driver.findElement(By.xpath("//span[contains(text(),'For Corporates') and@class='nav-interact']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Health & Wellness Plans') and@class='nav-interact']")).click();
	}
	
	public void formfilling() throws IOException
	{
		//value entered in the form
		driver.findElement(By.id("name")).sendKeys(p.getProperty("name"));
		
		driver.findElement(By.id("organizationName")).sendKeys(p.getProperty("Oname"));
		
		driver.findElement(By.id("contactNumber")).sendKeys(p.getProperty("Cno"));
		
		//input wrong value in email field to generate error
		driver.findElement(By.id("officialEmailId")).sendKeys(p.getProperty("email"));
		
		Select organization=new Select(driver.findElement(By.id("organizationSize")));
		organization.selectByVisibleText("10001+");
		
		Select interested = new Select(driver.findElement(By.id("interestedIn")));
		interested.selectByValue("A career opportunity");
		
		//screenshot of the error by invalid input
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File firstsrc = screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "\\screenshot\\error_captured.png";
		FileUtils.copyFile(firstsrc, new File(path));
	}
}
