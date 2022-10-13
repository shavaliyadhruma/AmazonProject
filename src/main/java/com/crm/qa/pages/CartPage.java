package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends TestBase {

	LoginPage loginPage;

	float OrderPrice = 0;

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement txtMainSearch;

	@FindBy(xpath = "//*[@id=\"searchDropdownBox\"]")
	WebElement dbMainList;

	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	WebElement btnMainSearch;

	@FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div/div[2]/div")
	List<WebElement> lblsuggestions;

	@FindBy(xpath = "/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")
	WebElement lblSearchResultHeader;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div/div/div/div/div/div/div/h2")
	List<WebElement> DivProductNames;

	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement lblProductTitle;

	@FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/span")
	WebElement lblProductPrice;

	@FindBy(xpath = "//select[@id='quantity']")
	WebElement lblProductQty;

	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	WebElement btnAddToCart;

	@FindBy(xpath = "//*[@id=\"buy-now-button\"]")
	WebElement btnBuyNow;

	@FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
	WebElement lblcountCart;

	@FindBy(xpath = "//span[@class='nav-line-2'][contains(text(),'Cart')]")
	WebElement iconCart;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/span")
	WebElement lblcartsuccess;

	@FindBy(xpath = "//span[@id='sw-gtc']//span[@class='a-button-inner']//a[@class='a-button-text'][contains(text(),'Go to cart')]")
	WebElement btnGotoCart;

	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	WebElement cartLblProductTitle;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/p/span")
	WebElement cartLblPrice;

	@FindBy(xpath = "//select[@id='quantity']")
	WebElement DpCartQty;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	WebElement ProductCartPrice;

	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement ResultProce;

	@FindBy(xpath = "//span[@id='sc-buy-box-ptc-button']//span[@class='a-button-inner']//input[@type='submit']")
	WebElement btnProcessCheckout;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement Address_FullName;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement Address_Phone;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement Address_Address1;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressLine2\"]")
	WebElement Address_Address2;

	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement Address_City;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div[3]/div[1]/div/div[1]/form/div/div[1]/div/div[14]/span/span/span/span")
	WebElement Address_State;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[1]/div[1]/ul[1]/li/a")
	List<WebElement> DpOptions;


	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement Address_Postal;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div[3]/div[1]/div/div[1]/form/div/span/span/span/input")
	WebElement btnUseThisAddress;

	@FindBy(xpath = "//div[@id='address-book-entry-0']//div[contains(@class,'')]//span[@class='a-button-inner']//a[contains(@class,'a-declarative a-button-text')][contains(text(),'Deliver to this address')]")
	WebElement BtnDeliverdToThisAddress;

	@FindBy(xpath = "//span[@id='pp-iCsht6-67-announce']")
	WebElement btnAddNewCard;

	@FindBy(xpath = "//td[@class='a-text-right aok-nowrap maple-mathbox__value']")
	WebElement lblFinalPriceOfOrder;

	@FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[1]")
	WebElement btnFinalReview;

	// Initializing the Page Objects:
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean CartResultTest(String SearchString) throws InterruptedException {
		boolean flag = false;

		txtMainSearch.clear();
		txtMainSearch.sendKeys(SearchString);

		btnMainSearch.click();

		if(lblSearchResultHeader.isDisplayed()){
			flag = true;
		}

		Thread.sleep(9000);
		DivProductNames.size();
		System.out.println(DivProductNames.size());

		String ProductName = DivProductNames.get(0).getText().toString();
		System.out.println(ProductName);

		DivProductNames.get(0).click();

		Thread.sleep(9000);

//		String ProductPrice = lblProductPrice.getText().toString();
//		System.out.println(ProductPrice);

//		String ProductQTY = lblProductPrice.getText().toString();
//		System.out.println(ProductQTY);

		Select select = new Select(lblProductQty);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);

		btnAddToCart.click();

		String countCart = lblcountCart.getText();
		System.out.println("Count "+countCart);

//		iconCart.click();

		if(lblcartsuccess.isDisplayed()){

			btnGotoCart.click();

			System.out.println((cartLblProductTitle.getText().substring(0, cartLblProductTitle.getText().length() - 2)).toLowerCase() +" // "+ProductName);

			if(cartLblProductTitle.isDisplayed() && (ProductName.toLowerCase()).startsWith((cartLblProductTitle.getText().substring(0, cartLblProductTitle.getText().length() - 2)).toLowerCase())){

				flag = true;
			}else {
				flag = false;
			}

		}else {
			flag = false;
		}

		return flag;
	}

	public boolean CartQtyTest(int MtlQty) throws InterruptedException {
		boolean flag = false;

		float Price = Float.parseFloat(ProductCartPrice.getText().replace("$", "").replace(",", ""));

		Select selectQty = new Select(DpCartQty);
		selectQty.selectByVisibleText(String.valueOf(MtlQty));

		Thread.sleep(2000);

		float ResultPrice = Float.parseFloat(((ResultProce.getText()).substring(1)).replace(",", "").replace("$", ""));

		System.out.println(Price+" // "+ResultPrice);

		if(ResultPrice == (Price * MtlQty)){
			OrderPrice = ResultPrice;
			System.out.println("Expected "+ (Price * MtlQty) +" Actual Price "+ResultPrice);
			flag = true;
		}else {
			flag = false;
		}

		Thread.sleep(1000);

		return flag;
	}

	public boolean CartCheckoutTest(String Address_fullname, String Address_phonenumber, String Address_address1, String Address_address2, String Address_city, String Address_state, String Address_zip, String Address_make_default_check, String Address_property_type, String Address_seciruty_code, String Address_callbox, String Address_instructions) throws InterruptedException {
		boolean flag = false;

		btnProcessCheckout.click();

		Thread.sleep(1000);
		loginPage = new LoginPage();
		loginPage.loginOnly(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("username"));

		//Add New Address Code.
//		Address_FullName.clear();
//		Address_FullName.sendKeys(Address_fullname);
//		Address_Phone.clear();
//		Address_Phone.sendKeys(Address_phonenumber);
//		Address_Address1.clear();
//		Address_Address1.sendKeys(Address_address1);
//		Address_Address2.clear();
//		Address_Address2.sendKeys(Address_address2);
//		Address_City.clear();
//		Address_City.sendKeys(Address_city);
//
//		Thread.sleep(1000);
//		Address_State.click();
//		int i=0;
//		for ( WebElement we: DpOptions) {
//			i++;
//			System.out.println(we.getText().toString());
//			if ((we.getText().toString()).equals(Address_State)) {
//
//				JavascriptExecutor je = (JavascriptExecutor) driver;
//				je.executeScript("arguments[0].scrollIntoView(true);", DpOptions.get(i) );
//				Thread.sleep(1000);
//				DpOptions.get(i).click();
//			}
//		}
//
//		Address_Postal.sendKeys(Address_zip);
//
//		btnUseThisAddress.click();

		BtnDeliverdToThisAddress.click();

		Thread.sleep(5000);
		btnFinalReview.click();

		flag = true;
		return flag;
	}

}
