package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	WebDriver driver;
	public Base(WebDriver driver)
	{
		this.driver = driver;
	}
	@BeforeTest
	public void setup(String url)
	{
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
