package directmainclasses;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ScreenShotInSelenium {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String url  = "https://www.google.com";
		driver.get(url);
		
		//Taking Screenshot of the entire page 
		TakesScreenshot scrsht = ((TakesScreenshot)driver);
		File src = scrsht.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\2110979\\eclipse-workspace\\rahulshettylearnings\\ScreenShot\\image.png");
		FileUtils.copyFile(src, dest);
		driver.close();
	}

}
