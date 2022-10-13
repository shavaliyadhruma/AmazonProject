package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PaymentPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class PaymentPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	PaymentPage paymentPage;
	TestUtil testUtil;

	public PaymentPageTest() {
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
		paymentPage = new PaymentPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("username"));
	}
	
	
	@Test(priority=1)
	public void VerifyAddCardErrorTest() throws InterruptedException {
		Assert.assertTrue(paymentPage.VerifyAddCard());
	}

	@Test(priority=2)
	public void AddNewCardTest() throws InterruptedException {
		Assert.assertTrue(paymentPage.AddCard());
	}

	@Test(priority=3)
	public void VerifyAddAddressErrorTest() throws InterruptedException {
		Assert.assertTrue(paymentPage.VerifyAddAddress());
	}

	@Test(priority=4)
	public void AddNewAddressTest() throws InterruptedException {
		Assert.assertTrue(paymentPage.VerifyAddAddress());
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
