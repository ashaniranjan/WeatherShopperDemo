package E2EProject.weatherShopper.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import E2EProject.weatherShopper.Locators.PaymentAndPurchasePageLocators;

public class PaymentAndPurchasePage extends PaymentAndPurchasePageLocators {
	public WebDriver driver = null;

	public PaymentAndPurchasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart() throws InterruptedException

	{
		driver.findElement(By.xpath(goToCart)).click();
		System.out.println("Inside chooseTypeproduct2");
		driver.findElement(By.xpath(makePayement)).click();
	}

	public void paymentAndPurchase() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath(switchToPaymentPopUp)));
		Thread.sleep(5000); // TODO: wait for locator
		driver.findElement(By.xpath(email)).sendKeys("abc@gmail.com");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='4242 4242 4242 4242';", driver.findElement(By.id(cardNumber)));
		jse.executeScript("arguments[0].value='10/24';", driver.findElement(By.id(cardExpiry)));
		driver.findElement(By.id(cvv)).sendKeys("123");
		if (driver.findElement(By.id(zipCode)).isDisplayed()) {
			driver.findElement(By.id(zipCode)).sendKeys("10987");
		}
		driver.findElement(By.id(submit)).click();

	}
}
