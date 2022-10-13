package Pom.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends TestBase {

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/a/div/div/div/div[2]/h2")
	WebElement menuOrders;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[3]/div/div/div/div[2]")
	WebElement addPayment;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div/div[1]/span/span[1]/span/input")
	WebElement btnAddPayment;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/iframe[1]")
	WebElement IframePayment;

	@FindBy(xpath = "//*[@id=\"pp-IUyez9-15\"]")
	WebElement txtCardNumber;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/form/div[1]/div[1]/div/div/div/div/ul/li[1]/span")
	WebElement errorCardNumber;

	@FindBy(xpath = "//*[@id=\"pp-IUyez9-17\"]")
	WebElement txtNameOfCard;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/form/div[1]/div[1]/div/div/div/div/ul/li[2]/span")
	WebElement errorNameOfCard;

	@FindBy(xpath = "//*[@id=\"pp-IUyez9-18\"]")
	WebElement dpMonth;

	@FindBy(xpath = "//*[@id=\"pp-IUyez9-20\"]")
	WebElement dpYear;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/form/div[1]/div[1]/div/div/div/div/ul/li[3]/span")
	WebElement errorExpired;

//	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/form/div[2]/div/span[2]/span/input")
	@FindBy(name = "ppw-widgetEvent:AddCreditCardEvent")
	WebElement btnAddYourCard;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/div/div/div/div/div[2]")
	WebElement lblAddedCard;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div/div/div/span[1]/span/input")
	WebElement AddAddress;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-18\"]")
	WebElement txtFullName;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-19\"]")
	WebElement txtAddress1;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div[1]/div[1]/div/div/div/div/ul/li[1]/span")
	WebElement errorAddress1;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-20\"]")
	WebElement txtAddress2;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-21\"]")
	WebElement txtCity;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div[1]/div[1]/div/div/div/div/ul/li[2]/span")
	WebElement errorCity;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-22\"]")
	WebElement txtState;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-23\"]")
	WebElement txtZIP;

	@FindBy(xpath = "//*[@id=\"pp-ds2G5T-26\"]")
	WebElement txtPhone;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div[1]/div[1]/div/div/div/div/ul/li[3]/span")
	WebElement errorPhone;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div[2]/div/span[2]/span/input")
	WebElement btnAddAddress;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div/div/div[1]/div[3]/span/span/input")
	WebElement btnUserAddress;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/form/div/div[2]/div/span[2]/span/input")
	WebElement btnSave;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/ul/li/span/span")
	WebElement lblSuccess;

	// Initializing the Page Objects:
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}


	public boolean VerifyAddCard() throws InterruptedException {
		menuOrders.click();

		addPayment.click();

		btnAddPayment.click();

		Thread.sleep(1000);

		driver.switchTo().frame(IframePayment);

		Thread.sleep(1000);

		btnAddYourCard.click();

		if (errorCardNumber.isDisplayed() && errorNameOfCard.isDisplayed() && errorExpired.isDisplayed()) {
			System.out.println(errorCardNumber.getText());
			boolean holderflag = errorCardNumber.getText().equals("Cardholder's name is required.");

			System.out.println(errorNameOfCard.getText());
			boolean nameflag = errorNameOfCard.getText().equals("Card number is required.");

			System.out.println(errorExpired.getText());
			boolean expiredflag = errorExpired.getText().equals("Expiration date is not valid.");

			if(holderflag && nameflag && expiredflag){
				return  true;
			}else {
				return false;
			}

		}else {
			return false;
		}
	}

	public boolean AddCard() throws InterruptedException {
		if (txtCardNumber.isDisplayed()) {
			txtCardNumber.sendKeys("Test");
			txtNameOfCard.sendKeys("5267318187975449");

			dpMonth.click();
			//*[@id="pp-xAg6xw-18_0"]
			Thread.sleep(5000);

			btnAddYourCard.click();

			if (lblAddedCard.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}

	public boolean VerifyAddAddress() throws InterruptedException {
		AddAddress.click();
		btnAddAddress.click();

		if(errorAddress1.isDisplayed() && errorCity.isDisplayed() && errorPhone.isDisplayed()){
			System.out.println(errorAddress1.getText());
			boolean addressflag = errorAddress1.getText().equals("Please fill in Address Line 1.");

			System.out.println(errorCity.getText());
			boolean cityflag = errorCity.getText().equals("Please fill in City.");

			System.out.println(errorPhone.getText());
			boolean phoneflag = errorPhone.getText().equals("Please fill in Phone number.");

			if(addressflag && cityflag && phoneflag){
				btnUserAddress.click();

				return  true;
			}else {
				return false;
			}

		}else {
			return false;
		}
	}

	public boolean AddAddress() throws InterruptedException {
			if (txtFullName.isDisplayed()) {
				txtFullName.clear();
				txtFullName.sendKeys("Test");
				txtAddress1.clear();
				txtAddress1.sendKeys("test");
				txtAddress2.clear();
				txtAddress2.sendKeys("test");
				txtAddress2.clear();
				txtCity.sendKeys("Edmonton");

				txtState.sendKeys("Alberta");
				txtZIP.sendKeys("T5J2R4");

				txtPhone.sendKeys("7809039758");

				btnAddAddress.click();


			btnUserAddress.click();
			if (btnUserAddress.isDisplayed()) {

				btnSave.click();

				if(lblSuccess.isDisplayed()){
					boolean flag = lblSuccess.getText().toString().equals("Payment method added");

					return flag;
				}else {
					return false;
				}
			} else {
				return false;
			}
		}else {
			return false;
		}
	}

}
