package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.testng.Assert;

public class HomePage extends TestBase {

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/a/div/div/div/div[2]/h2")
	WebElement menuOrders;

	@FindBy(xpath = "/html/body/div[1]/section/div/div[3]/ul/li[1]")
	WebElement subOrders;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[5]/div[2]/div")
	WebElement orderCount;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[5]/div[1]/span/form/span[1]/span/span/span/span")
	WebElement dpMonths;

	@FindBy(xpath = "/html/body/div[1]/section/div/div[7]/div")
	WebElement lblNoOrder;

	@FindBy(xpath = "/html/body/div[1]/section/div/div[3]/ul/li[2]/a")
	WebElement subBuyAgain;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/span")
	WebElement lblBuyAgain;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[3]/ul/li[3]/span/a")
	WebElement subNotYetShipped;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[5]/div[1]/div")
	WebElement lblNotYetShipped;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/div/ul/li[5]/span/a")
	WebElement subCancelledOrder;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[5]/div[1]/div")
	WebElement lblsubCancelledOrder;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyOrders() throws InterruptedException {
		menuOrders.click();

		subOrders.click();

		//Verify Order Count
		if(lblNoOrder.isDisplayed()){
//			String txtOrderCounts = orderCount.getText().toString();
//			String[] SplitOrderCounts = txtOrderCounts.split(" ");
//			System.out.println("Order Count: "+ SplitOrderCounts[0]);

//			Assert.assertEquals(SplitOrderCounts[0], "orders","Home page title not matched");

			String lblNoOrderMessage = lblNoOrder.getText().toString();
			System.out.println(lblNoOrderMessage);
			boolean flag = lblNoOrderMessage.toString().contentEquals("Looks like you haven't placed an order in the last three months. View orders in 2022");

			return flag;

		}else{
			return false;
		}
	}

	public boolean VerifyBuyAgain() throws InterruptedException {
//		menuOrders.click();
		subBuyAgain.click();

		//Verify Order Count
		if(lblBuyAgain.isDisplayed()){
			String buyAgainMessage = lblBuyAgain.getText().toString();
			System.out.println(buyAgainMessage);

			boolean flag = lblBuyAgain.getText().toString().contentEquals("There are no recommended items for you to buy again at this time. Check Your Orders for items you previously purchased.");

			return flag;

		}else{
			return false;
		}
	}

	public boolean VerifyNotShipped() throws InterruptedException {
//		menuOrders.click();
		subNotYetShipped.click();

		//Verify Order Count
		if(lblNotYetShipped.isDisplayed()){
			String NotShippedMessage = lblNotYetShipped.getText().toString();
			System.out.println(NotShippedMessage);

			boolean flag = lblNotYetShipped.getText().toString().contentEquals("Looking for an order? All of your orders have shipped. View all orders");
			return flag;

		}else{
			return false;
		}
	}

	public boolean VerifyCancelledOrders() throws InterruptedException {
//		menuOrders.click();
		subCancelledOrder.click();

		//Verify Order Count
		if(lblsubCancelledOrder.isDisplayed()){
			String CancelledOrderMessage = lblsubCancelledOrder.getText().toString();
			System.out.println(CancelledOrderMessage);

			boolean flag = lblsubCancelledOrder.getText().toString().contentEquals("We aren't finding any cancelled orders (for orders placed in the last 6 months). View all orders");
			return flag;

		}else{
			return false;
		}
	}
}
