package E2EProject.weatherShopper.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import E2EProject.weatherShopper.Locators.ProductListAndCartPageLocators;

public class ProductListAndCartPage extends ProductListAndCartPageLocators {
	public WebDriver driver;
	public ProductListAndCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void addAlmondMoisturizer() throws InterruptedException {
		//driver.findElement(By.xpath(buyMoisturizer)).click();
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath(pricesOfAlmondMoisturizers));
		for (int i = 0; i < productPrices.size(); i++) 
		{
			sortedProductPrices.add(Integer.valueOf(productPrices.get(i).getText().replaceAll("\\D+", "")));
		}
		System.out.println("List before sorting" + sortedProductPrices);
		Collections.sort(sortedProductPrices);
		System.out.println("List after sorting" + sortedProductPrices);
		int price = sortedProductPrices.get(0);
		driver.findElement(By.xpath("//p[contains(text()," + price + ")]//following-sibling::button")).click();
		
	}
	
	public void addAloeMoisturizer() throws InterruptedException {
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath(pricesofAloeMoisturizer));
		for (int i = 0; i < productPrices.size(); i++) 
		{
			sortedProductPrices.add(Integer.valueOf(productPrices.get(i).getText().replaceAll("\\D+", "").toString()));
		}
		System.out.println("List before sorting" + sortedProductPrices);
		Collections.sort(sortedProductPrices);
		System.out.println("List after sorting" + sortedProductPrices);
		int price = sortedProductPrices.get(0);
		driver.findElement(By.xpath("//p[contains(text()," + price + ")]//following-sibling::button")).click();
		
	}

	public void sunscreenSPF50() throws InterruptedException {
		//driver.findElement(By.xpath(buySunscreen)).click();
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath(pricesOfSPF50));
		for (int i = 0; i < productPrices.size(); i++) 
		{
			sortedProductPrices.add(Integer.valueOf(productPrices.get(i).getText().replaceAll("\\D+", "").toString()));
			
		}
		System.out.println("List before sorting" + sortedProductPrices);
		Collections.sort(sortedProductPrices);
		System.out.println("List after sorting" + sortedProductPrices);
		int price = sortedProductPrices.get(0);
		driver.findElement(By.xpath("//p[contains(text()," + price + ")]//following-sibling::button")).click();
		
	}

	public void sunscreenSPF30() throws InterruptedException {
		
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath(pricesOfSPF30));
		for (int i = 0; i < productPrices.size(); i++) 
		{
			sortedProductPrices.add(Integer.valueOf(productPrices.get(i).getText().replaceAll("\\D+", "")));
			
		}
		System.out.println("List before sorting" + sortedProductPrices);
		Collections.sort(sortedProductPrices);
		System.out.println("List after sorting" + sortedProductPrices);
		int price = sortedProductPrices.get(0);
		driver.findElement(By.xpath("//p[contains(text()," + price + ")]//following-sibling::button")).click();
	}


}
