package Pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement loginLink;

	@FindBy(name="email")
	WebElement email;

	@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/div/div/div")
	WebElement emailError;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[2]/div/div")
	WebElement passwordError;

	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	WebElement btnSignin;

	@FindBy(xpath = "//*[@href=\"/gp/css/homepage.html/ref=nav_bb_ya\"]")
	WebElement loginPage;

	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement continueBtn;

	@FindBy(xpath="//*[@id=\"nav-logo-sprites\"]")
	WebElement crmLogo;

	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement txtUsername;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateCRMImage(){
		//Solution
		loginPage.click();

		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd, String uname) throws InterruptedException {
//		if(loginPage.isDisplayed()) {
//			loginPage.click();
//		}

		//Click on Signin
		loginLink.click();

		//Click btn to get error
		continueBtn.click();
		if(emailError.isDisplayed()){
			emailError.getText().toString().equals("Enter your e-mail address or mobile phone number");
		}

		email.sendKeys(un.toString());
		continueBtn.click();

		//Click Signin to get error
		btnSignin.click();
		if(passwordError.isDisplayed()){
			passwordError.getText().toString().equals("Enter your password");
		}
		password.sendKeys(pwd.toString());

		btnSignin.click();

		Thread.sleep(20000);
		if(txtUsername.isDisplayed()){
			txtUsername.getText().toString().equals("Hello, " + uname);
		}
		txtUsername.click();

		return new HomePage();
	}

	public HomePage loginOnly(String un, String pwd, String uname) throws InterruptedException {
		email.sendKeys(un.toString());
		continueBtn.click();

		//Click Signin to get error
		btnSignin.click();
		if(passwordError.isDisplayed()){
			passwordError.getText().toString().equals("Enter your password");
		}
		password.sendKeys(pwd.toString());

		btnSignin.click();

		return new HomePage();
	}
}
