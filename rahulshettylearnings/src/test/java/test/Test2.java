package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.Base;
import pages.*;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Base base = new Base(driver);
		PracticePage page = new PracticePage(driver);
		GreenKart kart = new GreenKart(driver);
		String GreenKartLink = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String path = "//*[@class='react-date-picker__calendar-button react-date-picker__button']";
		base.setup(GreenKartLink);
		kart.getTopDeals();
		kart.switchTab();
		page.explicitWait(path);
		kart.calanderHandelingAndVerifyDate();

		
		
	}

}
