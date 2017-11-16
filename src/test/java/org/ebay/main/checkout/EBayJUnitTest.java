package org.ebay.main.checkout;
import org.junit.Assert.*;
import org.junit.Before;

import java.util.LinkedList;

import org.ebay.pages.Homescreen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.runners.Parameterized;

@RunWith(Parallelized.class)
public class EBayJUnitTest {

	String browserName;
	
	@Test
	public void test() {
		
		System.out.println("BROWSER:"+browserName);
		Homescreen home = new  Homescreen(browserName);
		home.searchItem();

	}

	
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browser", browserName);
		capability.setCapability("name", "Parallel test");

	}

	
	@Parameterized.Parameters
	public static LinkedList<String> getEnvironments() throws Exception {
		LinkedList<String> env = new LinkedList<String>();
		env.add(new String( "chrome"));
		env.add(new String("firefox"));
		return env;
	}

	public EBayJUnitTest(String browserName) {
		this.browserName = browserName;
	}
}
