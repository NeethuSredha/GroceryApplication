package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    }
	@FindBy(xpath="//input[@name='username']") WebElement userName;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signIn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement loginBoxMessage;
	@FindBy(id="login-form") WebElement loginForm;
	
	
	
	
	public LoginPage enterUserNameOnUserNameField(String userNameValue) {
		userName.sendKeys(userNameValue);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage signInButtonClick() {
		signIn.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public String getTheTitle() {
		return title.getText();
	}
	
	public String getTheLoginBoxMessage() {
		return loginBoxMessage.getText();
	}
	
	public boolean isLoginFormDisplayed() {
		return loginForm.isDisplayed();
	}
	
}
