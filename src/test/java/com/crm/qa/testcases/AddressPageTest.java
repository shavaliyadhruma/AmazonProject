package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddressPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PaymentPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddressPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AddressPage addressPage;
	TestUtil testUtil;

	public AddressPageTest() {
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
		addressPage = new AddressPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("username"));
	}
	
	
	@Test(priority=1)
	public void VerifyAddAddressErrorTest() throws InterruptedException {
		Assert.assertTrue(addressPage.VerifyAddAddress());
	}

	@Test(priority=2)
	public void AddNewAddressTest() throws InterruptedException {
		Assert.assertTrue(addressPage.AddAddress(prop.getProperty("Address_fullname"), prop.getProperty("Address_phonenumber"), prop.getProperty("Address_address1"), prop.getProperty("Address_address2"), prop.getProperty("Address_city"), prop.getProperty("Address_state"), prop.getProperty("Address_zip"), prop.getProperty("Address_make_default_check"), prop.getProperty("Address_property_type"), prop.getProperty("Address_seciruty_code"), prop.getProperty("Address_callbox"), prop.getProperty("Address_instructions")));

	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
