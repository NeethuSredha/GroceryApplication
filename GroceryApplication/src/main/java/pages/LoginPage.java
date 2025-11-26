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
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signIn;
	
	
	
	
	public void enterUserNameOnUserNameField(String userNameValue) {
		userName.sendKeys(userNameValue);
	}
	public void enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
	}
	public void signInButtonClick() {
		signIn.click();
	}
}
