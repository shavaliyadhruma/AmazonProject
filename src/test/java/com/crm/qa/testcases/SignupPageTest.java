package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignupPageTest extends TestBase{
	SignUpPage SignUpPage;
	HomePage homePage;

	public SignupPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		SignUpPage = new SignUpPage();
	}
	
	@Test(priority=1)
	public void signupTest(){
		homePage = SignUpPage.signup(prop.getProperty("signup_name"), prop.getProperty("signup_email"), prop.getProperty("signup_password"));
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
