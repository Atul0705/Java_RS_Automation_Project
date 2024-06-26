package pages;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;


public class PracticePage {
	
	public WebDriver driver;
	
	public void takeScreenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/rahulshettylearnings/ScreenShot");
		FileUtils.copyFile(src, dest);
	}

	public PracticePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyPage(String Pagename)
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, Pagename);
	}
	public void radioButtonSelect()
	{
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
	}
	public void explicitWait(String path)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}
	public void scrollDown(String y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")", "");
	}
	public void dynamicSelectionBox(String key)
	{
		 String loc = "//input[@id='autocomplete']";
		 String indloc = "//li[@class='ui-menu-item']";
		 driver.findElement(By.xpath(loc)).sendKeys(key);
		 explicitWait(indloc);
		 List<WebElement> country = driver.findElements(By.xpath(indloc));
		 for(WebElement ele : country )
		 {
			 if(ele.getText().equals("India"))
			 {
				 ele.click();
				 break;
			 }
		 }
	}
	public void selectDropDown()
	{
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropdown);
		sel.selectByIndex(2);
	}
	public void checkboxSelection()
	{
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement ele : options)
		{
			if(ele.getAttribute("value").equals("option1"))
			{
				ele.click();
			}
			else if(ele.getAttribute("value").equals("option3"))
			{
				ele.click();
			}
		}
		
	}
	
	public void switchwindow()
	{
		driver.findElement(By.id("openwindow")).click();
		Set<String> windids = driver.getWindowHandles();
		Iterator<String> it = windids.iterator();
		String parentwindow = it.next();
		String newWindow = it.next();
		driver.switchTo().window(newWindow);
		verifyPage("QAClick Academy - A Testing Academy to Learn, Earn and Shine");
		driver.switchTo().window(parentwindow);
		
	}
	public void switchtab() 
	{
		driver.findElement(By.id("opentab")).click();
		Set<String> windids = driver.getWindowHandles();
		Iterator<String> it = windids.iterator();
		String parentwindow = it.next();
		String newWindow = it.next();
		driver.switchTo().window(newWindow);
		verifyPage("QAClick Academy - A Testing Academy to Learn, Earn and Shine");
		driver.switchTo().window(parentwindow);
	}
	
	public void handleingAlert(String name)
	{
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void productTableSum()
	{
		List<WebElement> prices = driver.findElements(By.xpath("//*[@class='table-display'] //tr //td[3]"));
		int sum =0;
		for(WebElement ele : prices)
		{
			sum+= Integer.valueOf(ele.getText());
		}
		System.out.println(sum);
	}
	public void verifyTableSumAndAssert()
	{
		List<WebElement> amount = driver.findElements(By.xpath("//*[@id='product'] //tr //td[4]"));
		int sum = 0;
		for(WebElement ele : amount)
		{
			sum+= Integer.valueOf(ele.getText());
		}
		System.out.println(sum);
		int expectedsum = Integer.valueOf(driver.findElement(By.xpath("//*[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(expectedsum, sum);
		
	}
	
	public void mouseHover()
	{
		WebElement mousehoverbutton = driver.findElement(By.id("mousehover"));
		Actions act = new Actions(driver);
		act.moveToElement(mousehoverbutton).perform();
	}
	
	public void iframe()
	{
		
		WebElement iframe = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.linkText("Job Support")).click();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
	}
	
	public void footerAllLinkTest() throws MalformedURLException, IOException
	{
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links = footer.findElements(By.cssSelector(".gf-li a"));
		SoftAssert softassert = new SoftAssert();
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println(respCode);

	          softassert.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

	      }

	      softassert.assertAll();
		}
	}

