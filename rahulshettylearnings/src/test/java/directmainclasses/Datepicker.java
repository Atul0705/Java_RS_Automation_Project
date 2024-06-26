package directmainclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datepicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/");
		WebElement date= driver.findElement(By.name("bdaytime"));
		date.sendKeys("07051999");
		date.sendKeys(Keys.TAB);
		date.sendKeys("0948PM");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[style='font-size:15px;margin-left:50px;']")));
		System.out.println(driver.findElement(By.cssSelector("div[style='font-size:15px;margin-left:50px;']")).getText());
	}

}
