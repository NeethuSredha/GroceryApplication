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
	@FindBy(xpath="//p[text()='Admin Users']/parent::div//following-sibling::a") WebElement moreInfoAdminLink;

	
	public void clickOnAdminIcon() {
		admin.click();
	}

	public void clickOnLogoutIcon() {
		
		logoutButton.click();
	}
	
	public void clickOnMoreInfoLink() {
		moreInfoAdminLink.click();
	}
}
