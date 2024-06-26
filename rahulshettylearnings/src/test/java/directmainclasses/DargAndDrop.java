package directmainclasses;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DargAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		
		WebElement bank = driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		WebElement dest = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		
		//Drag and drop perform using action class
		
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(bank, dest).build().perform();
		
		
		driver.quit();

	}

}
