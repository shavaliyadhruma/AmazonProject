package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
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
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("username"));
	}
	
	
	@Test(priority=1)
	public void MenuOrderTest() throws InterruptedException {
		Assert.assertTrue(homePage.VerifyOrders());
	}

	@Test(priority=2)
	public void MenuBuyAgainTest() throws InterruptedException {
		Assert.assertTrue(homePage.VerifyBuyAgain());
	}

	@Test(priority=2)
	public void MenuBuyNotShipped() throws InterruptedException {
		Assert.assertTrue(homePage.VerifyNotShipped());
	}

	@Test(priority=4)
	public void loginCancelledOrders() throws InterruptedException {
		Assert.assertTrue(homePage.VerifyCancelledOrders());
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
