package org.ebay.checkoutcart;

import java.util.ResourceBundle;

import org.ebay.pages.Homescreen;
import org.ebay.pages.PageProperties;

public class Checkoutcart extends PageProperties {

	public static void main(String[] args) {
		
		ResourceBundle config = ResourceBundle.getBundle("Configuration");
		
		Homescreen home = new  Homescreen();
		home.searchItem();
		
	}

}
