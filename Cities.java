package hackathon.afterinterim;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.*;

public class Cities 
{
	WebDriver driver=null;
	
	public Cities(WebDriver d)
	{
		driver=d;
	}
	
	public void navTest()
	{
		driver.findElement(By.partialLinkText("Lab Tests")).click();
	}
	
	public void cityName() throws IOException
	{
		List<WebElement> l1=driver.findElements(By.xpath("//li[@class='u-text--center']/div[@class='u-margint--standard o-f-color--primary']"));
		List<String> li = new ArrayList<String>();
        for(WebElement el : l1){
            li.add(el.getText());
         }
        
        excel e=new excel(driver);
        e.putData("sheet1",li);
       
	}
}
