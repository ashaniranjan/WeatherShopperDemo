package E2EProject.weatherShopper.Locators;

public class PaymentAndPurchasePageLocators {

	protected static String goToCart = "//body/nav[1]/ul[1]/button[1]";
	protected static String makePayement = "//span[contains(text(),'Pay with Card')]";
	protected static String switchToPaymentPopUp = "//iframe[@class='stripe_checkout_app']";
	protected static String email = "//input[@id='email']";
	protected static String cardNumber = "card_number";
	protected static String cardExpiry = "cc-exp";
	protected static String cvv = "cc-csc";
	protected static String zipCode = "billing-zip";
	protected static String submit = "submitButton";

}
