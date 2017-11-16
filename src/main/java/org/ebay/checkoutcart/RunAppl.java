package org.ebay.checkoutcart;

import java.util.ResourceBundle;

import org.ebay.pages.Homescreen;
import org.ebay.pages.PageProperties;

public class RunAppl extends PageProperties {

	public RunAppl(String browser) {
		super(browser);
	}

	public static void main(String[] args) {
		
		ResourceBundle config = ResourceBundle.getBundle("Configuration");
		
		Homescreen home = new  Homescreen("chrome");
		home.searchItem();
		
	}

}
