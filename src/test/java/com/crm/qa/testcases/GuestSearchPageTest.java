package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GuestSearchPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class GuestSearchPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	GuestSearchPage guestSearchPage;
	TestUtil testUtil;

	public GuestSearchPageTest() {
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
	}
	
	
	@Test(priority=1)
	public void VerifySearchSuggestions() throws InterruptedException {
		Assert.assertTrue(guestSearchPage.SearchSuggestionTest(prop.getProperty("SearchText")));
	}

	@Test(priority=2)
	public void VerifySearchResult() throws InterruptedException {
		Assert.assertTrue(guestSearchPage.SearchResultTest(prop.getProperty("SearchText")));
	}

	@Test(priority=3)
	public void VerifyFilterResult() throws InterruptedException {
		Assert.assertTrue(guestSearchPage.filterResultTest(prop.getProperty("MinPrice"), prop.getProperty("MaxPrice")));
	}

	@Test(priority=4)
	public void VerifySortingResult() throws InterruptedException {
		Assert.assertTrue(guestSearchPage.SortingResultTest(prop.getProperty("Sort")));
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
