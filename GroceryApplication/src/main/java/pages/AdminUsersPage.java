package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();

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
	
	public AdminUsersPage clickOnAdminNewButton() {
		newLink.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage enterUserNameOnUserNameFieldOnAdmin(String newUserNameValue) {
		userName.sendKeys(newUserNameValue);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage enterPasswordOnPasswordFieldOnAdmin(String newPasswordValue) {
		password.sendKeys(newPasswordValue);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage selectTheUserTypeOnAdmin(String userTypeValue) {
		pageUtility.selectDropDownWithVisibleText(userType, userTypeValue);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage saveButtonClickOnAdmin() {
		saveButton.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage searchButtonClickOnAdmin() {
		searchLink.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage enterTheUserNameToSearchOnAdmin(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage searchButtonClickToCheckUserNameOnAdmin() {
		searchButton.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage resetButtonClickOnAdmin() {
		resetLink.click();
		return new AdminUsersPage(driver);
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
