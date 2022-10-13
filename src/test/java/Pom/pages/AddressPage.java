package Pom.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends TestBase {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")
	WebElement menuPayment;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div[1]/a/div/div")
	WebElement btnAddAddress;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement txtFullName;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[4]/div/div[1]/div/div/div")
	WebElement lblFullName;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement txtPhoneNumber;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[6]/div/div[2]/div/div/div")
	WebElement lblPhoneNumber;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement txtAddress1;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressLine2\"]")
	WebElement txtAddress2;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[10]/div/div/div/div/div")
	WebElement lblAddress;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement txtCity;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[12]/div/div[1]/div/div/div")
	WebElement lblCity;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")
	WebElement dpState;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[14]/div/div[1]/div/div/div")
	WebElement lblState;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement txtZIP;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[1]/div/div[16]/div/div[1]/div/div/div")
	WebElement lblZIP;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-use-as-my-default\"]")
	WebElement checkdefaultaddress;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/a/span/span")
	WebElement linkAddNote;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[1]/span/div/span[1]/span/button")
	WebElement btnHouse;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[1]/span/div/span[2]/span/button")
	WebElement btnApartment;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[1]/span/div/span[3]/span/button")
	WebElement btnbusiness;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[1]/span/div/span[4]/span/button")
	WebElement btnother;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[1]/a/span/div/div[1]/span")
	WebElement lblPackages;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/a/span/div/div[1]/span")
	WebElement viewBuildingCode;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/div/div[2]/span/input")
	WebElement txtSecurityCode;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/div/div[3]/div[2]/span/input")
	WebElement txtCallBox;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[4]/a/span/div/div[1]/span")
	WebElement viewInstructions;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[4]/div/div/span/div/textarea")
	WebElement txtInstructions;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]")
	WebElement btnAddAddressSubmit;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/h4")
	WebElement lblSuccess;

	// Initializing the Page Objects:
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}


	public boolean VerifyAddAddress() throws InterruptedException {
		menuPayment.click();

		btnAddAddress.click();

		txtFullName.clear();

		btnAddAddressSubmit.click();

		Thread.sleep(5000);

//		if (lblFullName.isDisplayed() && lblPhoneNumber.isDisplayed() && lblAddress.isDisplayed() && lblCity.isDisplayed() && lblState.isDisplayed() && lblZIP.isDisplayed()) {
			System.out.println(lblFullName.getText());
			boolean nameflag = lblFullName.getText().equals("Please enter a name.");

			System.out.println(lblPhoneNumber.getText());
			boolean phoneflag = lblPhoneNumber.getText().equals("Please enter a phone number so we can call if there are any issues with delivery.");

			System.out.println(lblAddress.getText());
			boolean addressflag = lblAddress.getText().equals("Please enter an address.");

			System.out.println(lblCity.getText());
			boolean cityflag = lblCity.getText().equals("Please enter a city name.");

			System.out.println(lblState.getText());
			boolean stateflag = lblState.getText().equals("Please enter a province/territory.");

			System.out.println(lblZIP.getText());
			boolean zipflag = lblZIP.getText().equals("Please enter a postal code.");

			if(nameflag && phoneflag && addressflag && cityflag && stateflag && zipflag){
				return  true;
			}else {
				return false;
			}


	}

	public boolean AddAddress(String Address_fullname, String Address_phonenumber, String Address_address1, String Address_address2, String Address_city, String Address_state, String Address_zip, String Address_make_default_check, String Address_property_type, String Address_seciruty_code, String Address_callbox, String Address_instructions) throws InterruptedException {
			if (txtFullName.isDisplayed()) {
				txtFullName.clear();
				txtFullName.sendKeys(Address_fullname);
				txtPhoneNumber.clear();
				txtPhoneNumber.sendKeys(Address_phonenumber);
				txtAddress1.clear();
				txtAddress1.sendKeys(Address_address1);
				txtAddress2.clear();
				txtAddress2.sendKeys(Address_address2);
				txtCity.clear();
				txtCity.sendKeys(Address_city);

				Select s = new Select(dpState);
				s.selectByVisibleText(Address_state);

				txtZIP.sendKeys(Address_zip);

				if(Address_make_default_check.equals("true")){
					linkAddNote.click();
					System.out.println("======> "+ Address_make_default_check);
				}


				viewBuildingCode.click();

				txtSecurityCode.sendKeys(Address_seciruty_code);
				txtCallBox.sendKeys(Address_callbox);

				viewInstructions.click();

				txtInstructions.sendKeys(Address_instructions);

				btnAddAddressSubmit.click();

			if (lblSuccess.isDisplayed()) {
				System.out.println(lblSuccess.getText());
				boolean flag = lblSuccess.getText().toString().equals("Address saved");
				return flag;

			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
