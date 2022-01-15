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

public class productPurchaseFlow {

	public static WebDriver driver;
	HomePage homePage = null;
	ProductListAndCartPage productListAndCartPage = null;
	PaymentAndPurchasePage paymentAndPurchasePage = null;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");

		if (browser.equalsIgnoreCase("firefox")) {

			// Initializing the firefox driver (Gecko)
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			// Initialize the chrome driver
			driver = new ChromeDriver();

		}
		homePage = new HomePage(driver);
		productListAndCartPage = new ProductListAndCartPage(driver);
		paymentAndPurchasePage = new PaymentAndPurchasePage(driver);
		driver.get("https://weathershopper.pythonanywhere.com/");
	}

	@Test
	public void purchaseFlow() throws InterruptedException {
		System.out.println("Inside productlist page");
		homePage.chooseTypeOfProduct();
		paymentAndPurchasePage.addToCart();
		paymentAndPurchasePage.paymentAndPurchase();
	}

	@AfterClass
	public void browserclose() {
		driver.close();
	}

}
