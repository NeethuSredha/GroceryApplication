package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@src,'avatar5.png')]") WebElement admin;
	@FindBy(linkText = "Logout") WebElement logoutButton;
	@FindBy(xpath="//p[text()='Admin Users']/parent::div//following-sibling::a") WebElement moreInfoAdminUsersLink;
	@FindBy(xpath="//p[text()='Manage News']/parent::div//following-sibling::a") WebElement moreInfoManageNewsLink;

	
	public HomePage clickOnAdminIcon() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogoutIcon() {
		
		logoutButton.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickOnMoreInfoAdminUsersLink() {
		moreInfoAdminUsersLink.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageNewsPage clickOnMoreInfoManageNewsLink() {
		moreInfoManageNewsLink.click();
		return new ManageNewsPage(driver);
	}
}
