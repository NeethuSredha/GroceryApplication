package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),' New')]") WebElement newLink;
	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="user_type") WebElement userType;
	@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement saveButton;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement searchLink;
	@FindBy(id="un") WebElement searchUserName;
	@FindBy(name="Search") WebElement searchButton;
	@FindBy(xpath="//a[contains(text(),' Reset')]") WebElement resetLink;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' or @class='alert alert-danger alert-dismissible']")WebElement userAddAlert;
	@FindBy(xpath="//h4[text()='Admin Users']") WebElement searchAdminUsersResultTab;
	@FindBy(xpath="//h4[text()='Admin Users']//ancestor::div[@class='card']") WebElement adminUsersList;
	
	public void clickOnNewButton() {
		newLink.click();
	}
	
	public void enterUserNameOnUserNameField(String newUserNameValue) {
		userName.sendKeys(newUserNameValue);
	}
	
	public void enterPasswordOnPasswordField(String newPasswordValue) {
		password.sendKeys(newPasswordValue);
	}
	
	public void selectTheUserType(String userTypeValue) {
		Select select=new Select(userType);
		select.selectByVisibleText(userTypeValue);
	}
	public void saveButtonClick() {
		saveButton.click();
	}
	
	public void searchButtonClick() {
		searchLink.click();
	}
	
	public void enterTheUserNameToSearch(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
	}
	
	public void searchButtonClickToCheckUserName() {
		searchButton.click();
	}
	
	public void resetButtonClick() {
		resetLink.click();
	}
	
	public boolean userAddedAlertMessage() {
		return userAddAlert.isDisplayed();
	}
	
	public boolean isSearchAdminUsersResultTabDisplayed() {
		return searchAdminUsersResultTab.isDisplayed();
	}
	
	public boolean isAdminUsersListDisplayed() {
		return adminUsersList.isDisplayed();
	}
	
}
