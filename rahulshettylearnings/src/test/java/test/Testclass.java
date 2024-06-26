package test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.PracticePage;
import base.Base;


public class Testclass {

	@Test
	public void RahulShettyPageTesting() throws MalformedURLException, IOException  {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		Base base = new Base(driver);
		PracticePage page = new PracticePage(driver);
		String AutomationParcticeLink = "https://rahulshettyacademy.com/AutomationPractice/";
		
		base.setup(AutomationParcticeLink);
		page.verifyPage("Practice Page");
		page.radioButtonSelect();
		page.dynamicSelectionBox("Ind");
		page.selectDropDown();
		page.checkboxSelection();
		page.switchwindow();
		page.switchtab();
		page.handleingAlert("xyz");
		page.scrollDown("450");
		page.productTableSum();
		page.verifyTableSumAndAssert();
		page.scrollDown("500");
		page.mouseHover();
		page.scrollDown("550");
		page.iframe();
		page.scrollDown("750");
		page.footerAllLinkTest();
		base.closeBrowser();
	
		
		
		

	}

}
