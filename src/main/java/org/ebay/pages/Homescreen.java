package org.ebay.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Homescreen extends PageProperties

{
	ResourceBundle config = ResourceBundle.getBundle("Configuration");
	
	public void searchItem(){
			
			//Enter search details and click search
			txtField(config.getString("searchXpath"), config.getString("searchValue"));	
			clickButton(config.getString("searchButtonXpath"));
			clickButton(config.getString("buyItNowXpath"));
			clickButton(config.getString("item1Xpath"));
			clickJsButton(config.getString("addToCartId"));
			clickJsButton(config.getString("continueShoppingId"));
			//clickButton(config.getString("continueShoppingXpath"));
			clickButton(config.getString("item2Xpath"));
			clickJsButton(config.getString("addToCartId"));
			//clickJsButton(config.getString("cartId"));
			
		
	}

}
