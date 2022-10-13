package Pom.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GuestSearchPage extends TestBase {


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

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div")
	List<WebElement> DivProductCount;

	@FindBy(xpath = "/html/body/div/div/div/div/div/span/div/div/div/div/div/div/div/div/div/a/span[1]/span[2]/span[1]")
	List<WebElement> DivDollerSign;

	@FindBy(xpath = "/html/body/div/div/div/div/div/span/div/div/div/div/div/div/div/div/div/a/span[1]/span[2]/span[2]")
	List<WebElement> DivPrice;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div/div/div/div/div/div/div/h2")
	List<WebElement> DivProductNames;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span/div/div/div/div/div/div/div/div[2]/div/span[1]/span/a/i[1]")
	List<WebElement> DivRating;

	@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
	WebElement btnNextPage;

	@FindBy(xpath = "//*[@id=\"low-price\"]")
	WebElement txtLowPrice;

	@FindBy(xpath = "//*[@id=\"high-price\"]")
	WebElement txtMaxPrice;

	@FindBy(xpath = "//span[@id='a-autoid-1']//span[@class='a-button-inner']")
	WebElement btnGo;

	@FindBy(xpath = "/html/body/div/div/div/div/div/span/div/div/div/div/div/div/div/div/div/a/span[1]/span[2]/span[2]")
	List<WebElement> DivProductPrice;

	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	WebElement DPSort;

	// Initializing the Page Objects:
	public GuestSearchPage() {
		PageFactory.initElements(driver, this);
	}


	public boolean SearchSuggestionTest(String SearchString) throws InterruptedException {
		boolean flag = false;

		txtMainSearch.clear();
		txtMainSearch.sendKeys(SearchString);

		Thread.sleep(4000);

		for ( WebElement we: lblsuggestions) {
			System.out.println(we.getText().toString().toLowerCase()+" // "+SearchString.toLowerCase() + " // "+ (we.getText().toString().toLowerCase()).contains(SearchString.toString().toLowerCase()));
			if ((we.getText().toString().toLowerCase()).contains(SearchString.toLowerCase())) {
				System.out.println(we.getText().toString().toLowerCase()+" // "+SearchString.toLowerCase() + " // "+ (we.getText().toString().toLowerCase()).contains(SearchString.toLowerCase()));
				flag = true;
			}else {
				System.out.println("Goto Else");
				flag = false;
				break;
			}
		}
			return flag;
	}


	public boolean SearchResultTest(String SearchString) throws InterruptedException {
		boolean flag = false;

		txtMainSearch.clear();
		txtMainSearch.sendKeys(SearchString);

		btnMainSearch.click();

		if(lblSearchResultHeader.isDisplayed()){
			flag = true;
		}

		Thread.sleep(2000);

		DivProductCount.size();
		DivPrice.size();
		DivProductNames.size();

		System.out.println("Product "+ DivProductCount.size()+" // Pirce "+ DivPrice.size()+" //Name "+ DivProductNames.size() + "//Rating"+ DivRating.size());

		for (int i = 0; i < 2; i++) {
			if(DivPrice.size() <= DivProductNames.size()){

				if(btnNextPage.isDisplayed()){

					Thread.sleep(2000);

					DivProductCount.size();
					DivPrice.size();
					DivProductNames.size();

					System.out.println("Product "+ DivProductCount.size()+" // Pirce "+ DivPrice.size()+" //Name "+ DivProductNames.size() + "//Rating"+ DivRating.size());

//					if(i<1){
//						btnNextPage.click();
//					}

				}else {
					System.out.println("Elase Not display net btn");
				}

				flag = true;
			}else{
				flag = false;
				System.out.println("else Not");
				break;
			}
		}
		return flag;
	}

	public boolean filterResultTest(String Min, String Max) throws InterruptedException {
		boolean flag = false;
//		txtMainSearch.clear();
//		txtMainSearch.sendKeys("mobile");
//
//		btnMainSearch.click();

		txtLowPrice.sendKeys(Min);
		txtMaxPrice.sendKeys(Max);

		btnGo.click();

		Thread.sleep(9000);

		for ( WebElement we: DivProductPrice) {
			System.out.println(we.getText().toString()+" >= "+ Min +" && " + we.getText().toString() + " <= "+Max);

			if ( Integer.parseInt(we.getText().toString())>=Integer.parseInt(Min) && Integer.parseInt(we.getText().toString())<=Integer.parseInt(Max)) {
				System.out.println(we.getText().toString()+" >= "+ Min +" && " + we.getText().toString() + " <= "+Max);

				Thread.sleep(9000);
				flag = true;
			}else {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public boolean SortingResultTest(String Sort) throws InterruptedException {
		boolean flag = false;

		Select dpSort = new Select(DPSort);
		dpSort.selectByVisibleText(Sort);

		Thread.sleep(9000);

		int lastPrice = 0;
		for ( WebElement we: DivProductPrice) {
			System.out.println(we.getText().toString());
			System.out.println(lastPrice +" // "+we.getText().toString() + " Result " + (lastPrice<=Integer.parseInt(we.getText().toString())));
			if (lastPrice<=Integer.parseInt(we.getText().toString())) {

				Thread.sleep(9000);
				flag = true;
				lastPrice = Integer.parseInt(we.getText().toString());
			}else {
				flag = false;
				break;
			}
		}

		return flag;
	}
}
