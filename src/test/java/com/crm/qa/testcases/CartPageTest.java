package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GuestSearchPage;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartPageTest extends TestBase {
	LoginPage loginPage;
	GuestSearchPage guestSearchPage;

	CartPage cartPage;
	TestUtil testUtil;

	public CartPageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		guestSearchPage = new GuestSearchPage();
		cartPage = new CartPage();
	}
	
	
	@Test(priority=1)
	public void VerifyCartTest() throws InterruptedException {
		Assert.assertTrue(cartPage.CartResultTest(prop.getProperty("SearchText")));
	}

	@Test(priority=2)
	public void VerifyCartQtyTest() throws InterruptedException {
		Assert.assertTrue(cartPage.CartQtyTest(Integer.parseInt(prop.getProperty("Qty"))));
	}

	@Test(priority=3)
	public void VerifyCartCheckoutTest() throws InterruptedException {
		Assert.assertTrue(cartPage.CartCheckoutTest(prop.getProperty("Address_fullname"), prop.getProperty("Address_phonenumber"), prop.getProperty("Address_address1"), prop.getProperty("Address_address2"), prop.getProperty("Address_city"), prop.getProperty("Address_state"), prop.getProperty("Address_zip"), prop.getProperty("Address_make_default_check"), prop.getProperty("Address_property_type"), prop.getProperty("Address_seciruty_code"), prop.getProperty("Address_callbox"), prop.getProperty("Address_instructions")));
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
