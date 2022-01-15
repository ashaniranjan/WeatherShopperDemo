package E2EProject.weatherShopper.Locators;

import org.openqa.selenium.By;

public class ProductListAndCartPageLocators {
	//protected static final String buyMoisturizer = "//button[contains(text(),'Buy moisturizers')]";
	protected static final String pricesOfAlmondMoisturizers = "//p[contains(text(),'Almond')]//following-sibling::p[1]";
    protected static final String pricesofAloeMoisturizer ="//p[contains(text(),'Aloe')]//following-sibling::p[1]";
    //protected static final String buySunscreen= "//button[contains(text(),'Buy sunscreen')]";
    protected static final String pricesOfSPF50 = "//p[contains(text(),'SPF-50')]//following-sibling::p[1]";
    protected static final String pricesOfSPF30 = "//p[contains(text(),'SPF-30')]//following-sibling::p[1]";
}