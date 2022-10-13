package Pom.pages;

import org.testng.Assert;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase{
    @FindBy(xpath = "//*[@href=\"/gp/css/homepage.html/ref=nav_bb_ya\"]")
    WebElement loginPage;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
    WebElement signupLink;

    @FindBy(xpath="//*[@id=\"continue\"]")
    WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    WebElement txtName;

    @FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[1]/div/div/div")
    WebElement nameError;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElement txtEmail;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[2]/div[3]/div/div")
    WebElement emailError;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[6]/span/span/span/span[2]")
    WebElement txtMobileSpan;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[6]/span/span/span/span[3]")
    WebElement txtEmailSpan;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElement txtPassword;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div[1]/div[2]/div/div")
    WebElement passwordError;

    @FindBy(xpath = "//*[@id=\"ap_password_check\"]")
    WebElement txtPassword2;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[1]/form/div[4]/div[1]/h1")
    WebElement headerVerify;

    //Initializing the Page Objects:
    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage signup(String name, String email, String password){
        loginPage.click();

        loginLink.click();
        signupLink.click();

        //Click btn to get error
        continueBtn.click();
        if(nameError.isDisplayed()){
            boolean flag = nameError.getText().toString().equals("Enter your name");
            Assert.assertTrue(flag);
        }

        if(emailError.isDisplayed()){
            boolean flag = emailError.getText().toString().equals("Enter your e-mail address or mobile phone number");
            Assert.assertTrue(flag);
        }

        if(passwordError.isDisplayed()){
            boolean flag = passwordError.getText().toString().equals("Minimum 6 characters required");
            Assert.assertTrue(flag);
        }

        txtName.sendKeys(name.toString());
        txtEmail.sendKeys("12356");
        txtPassword.click();
        if(continueBtn.isDisplayed()){
            boolean flag = txtMobileSpan.getText().toString().equals("Verify mobile number");
            Assert.assertTrue(flag);
        }
        txtEmail.clear();
        txtEmail.sendKeys(email.toString());
        txtPassword.click();
        if(continueBtn.isDisplayed()){
            boolean flag = txtEmailSpan.getText().toString().equals("Verify email");
            Assert.assertTrue(flag);
        }

        txtPassword.sendKeys(password.toString());
        txtPassword2.sendKeys(password.toString());

        //Click
        continueBtn.click();

        if(headerVerify.isDisplayed()){
            boolean flag = headerVerify.getText().toString().equals("Verify email address");
            Assert.assertTrue(flag);
        }

        return new HomePage();
    }
}
