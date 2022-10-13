package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginSecurityPage;
import com.crm.qa.pages.PaymentPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginSecurityPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	LoginSecurityPage loginSecurityPage;
	TestUtil testUtil;

	public LoginSecurityPageTest() {
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
		loginSecurityPage = new LoginSecurityPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("username"));
	}
	
	
	@Test(priority=1)
	public void VerifyAddCardErrorTest() throws InterruptedException {
		Assert.assertTrue(loginSecurityPage.EditName(prop.getProperty("Name")));
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
