package E2EProject.weatherShopper.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import E2EProject.weatherShopper.Locators.HomePageLocators;

public class HomePage extends HomePageLocators {
	public WebDriver driver = null;
	ProductListAndCartPage productListAndCartPage = null;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		this.productListAndCartPage = new ProductListAndCartPage(driver);
	}
		
	public void chooseTypeOfProduct() throws InterruptedException 
	{
		String temp = driver.findElement(By.id("temperature")).getText().split(" ")[0];
		int temperature = Integer.parseInt(temp);

		if (temperature < 19) 
		{
			driver.findElement(By.xpath(buyMoisturizer)).click();
			System.out.println("Buying Mositurizer");
			productListAndCartPage.addAlmondMoisturizer();
			productListAndCartPage.addAloeMoisturizer();
			
		} 
		else 
		{
			driver.findElement(By.xpath(buySunscreen)).click();
			System.out.println("Buying Sunscreen");
			productListAndCartPage.sunscreenSPF30();
			productListAndCartPage.sunscreenSPF50();
		}
		
	
	}

}
