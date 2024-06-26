package pages;

import java.util.*;

import org.openqa.selenium.*;
import org.testng.Assert;
public class GreenKart {

	WebDriver driver;
	PracticePage page = new PracticePage(driver);
	public GreenKart(WebDriver driver)
	{
		this.driver = driver;
	}


	public void getTopDeals()
	{
		driver.findElement(By.linkText("Top Deals")).click();
	}
	public void switchTab()
	{
		Set<String>windowshandles = driver.getWindowHandles();
		Iterator<String>it = windowshandles.iterator();
		String parenttab = it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);

	}
	public void calanderHandelingAndVerifyDate()
	{
		String date ="15";
		String month = "6";
		String year = "2027";
		String [] expected = {month,date,year};
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i =0; i<actualList.size();i++)

		{

			System.out.println(actualList.get(i).getAttribute("value"));

			Assert.assertEquals(actualList.get(i).getAttribute("value"), expected[i]);

		}
		
	}

}
