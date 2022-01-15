package Project.E2EProject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import E2EProject.weatherShopper.Pages.HomePage;
import E2EProject.weatherShopper.Pages.PaymentAndPurchasePage;
import E2EProject.weatherShopper.Pages.ProductListAndCartPage;

public class backup extends BaseTest {
	
private static WebDriver driver; 

//BaseTest baseTest = new BaseTest();
//HomePage homePage=new HomePage();
//ProductListAndCartPage productListAndCartPage = new ProductListAndCartPage();
//PaymentAndPurchasePage paymentAndPurchasePage = new PaymentAndPurchasePage();


 /*   @Parameters({"browser"})
	@BeforeClass
	public void beforeTest(String browser) {

		  // If the browser is Firefox, then do this
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
    	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
    	//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
    	
		  if(browser.equalsIgnoreCase("firefox")) {
			 
		//Initializing the firefox driver (Gecko)
			  driver = new FirefoxDriver();	  

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver

			  driver = new ChromeDriver();

		  }
	
		driver.get("https://weathershopper.pythonanywhere.com/");
	}*/

	@Test
	public void productPurchase() throws InterruptedException {
		
	

		String temp = driver.findElement(By.id("temperature")).getText().split(" ")[0];
		int temperature = Integer.parseInt(temp);

		if (temperature < 19) 
		{
			addAlmondMoisturizer();
			addAloeMoisturizer();
		} 
		else 
		{
			sunscreenSPF50();
			sunscreenSPF30();
		}
		addToCart();
		paymentAndPurchase();
	}
	
	
	public static void addAlmondMoisturizer() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Buy moisturizers')]")).click();
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath("//p[contains(text(),'Almond')]//following-sibling::p[1]"));
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

	public static void addAloeMoisturizer() throws InterruptedException {
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath("//p[contains(text(),'Aloe')]//following-sibling::p[1]"));
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

	public static void sunscreenSPF50() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Buy sunscreen')]")).click();
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath("//p[contains(text(),'SPF-50')]//following-sibling::p[1]"));
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

	public static void sunscreenSPF30() throws InterruptedException {
		
		List<Integer> sortedProductPrices = new ArrayList<>();
		List<WebElement> productPrices = driver.findElements(By.xpath("//p[contains(text(),'SPF-30')]//following-sibling::p[1]"));
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

	public static void addToCart() throws InterruptedException

	{
		driver.findElement(By.xpath("//body/nav[1]/ul[1]/button[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Pay with Card')]")).click();
	}
	
	public static void paymentAndPurchase() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='stripe_checkout_app']")));
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='4242 4242 4242 4242';", driver.findElement(By.id("card_number")));
		jse.executeScript("arguments[0].value='10/24';", driver.findElement(By.id("cc-exp")));
		driver.findElement(By.id("cc-csc")).sendKeys("123");
		if (driver.findElement(By.id("billing-zip")).isDisplayed()) 
		{
			driver.findElement(By.id("billing-zip")).sendKeys("10987");
		}
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	
	@AfterClass
	public static void browserclose()
	{
		driver.close();
	}
	
}
	

