package directmainclasses;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryToolTipHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String url = "https://demo.guru99.com/test/tooltip.html";
		driver.get(url);
		
		
		Actions act = new Actions(driver);
		
		//In traditional method we use getattribute key and fetch the title of the attribute but ans of now we have a bunch of different Advance API that are being used to develop the website 
		//We have to move the cursor to the tooltips point using the offset method 
		
		WebElement download = driver.findElement(By.id("download_now"));
		
		act.clickAndHold().moveToElement(download);
		act.moveToElement(download).build().perform();
		
		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));							
        String actualTooltip = toolTipElement.getText();
        
        System.out.println(actualTooltip);
		
        
        driver.quit();
		
		

	}

}
