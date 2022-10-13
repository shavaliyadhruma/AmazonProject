package Pom.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSecurityPage extends TestBase {

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[2]/a/div/div/div/div[2]/h2")
	WebElement tabLoginSecurity;

	@FindBy(xpath = "//input[@id='auth-cnep-edit-name-button']")
	WebElement btnEditName;

	@FindBy(xpath = "//input[@id='ap_customer_name']")
	WebElement txtEditName;

	@FindBy(xpath = "//input[@id='cnep_1C_submit_button']")
	WebElement btnEditNameSave;

	@FindBy(xpath = "//span[contains(text(),'You successfully changed your account!')]")
	WebElement lblEditSuccess;

	@FindBy(xpath = "//input[@id='auth-cnep-edit-email-button']")
	WebElement btnEditEmail;

	@FindBy(xpath = "//a[@id='auth-cnep-done-button']")
	WebElement btnDone;

	// Initializing the Page Objects:
	public LoginSecurityPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean EditName(String Name) throws InterruptedException {
		boolean flag = false;
		tabLoginSecurity.click();

			btnEditName.click();
			txtEditName.clear();
			txtEditName.sendKeys(Name);

			btnEditNameSave.click();
			if(lblEditSuccess.isDisplayed()){
				flag = true;
			}else {
				return false;
			}
			btnDone.click();
		return flag;
	}

}
