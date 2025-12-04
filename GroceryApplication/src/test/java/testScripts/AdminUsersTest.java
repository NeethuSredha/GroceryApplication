package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test
	public void verifyWhetherAdminIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		String newPassword = ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminUsersPage.enterUserNameOnUserNameField(newUsername);
		adminUsersPage.enterPasswordOnPasswordField(newPassword);
		adminUsersPage.selectTheUserType(userType);
		adminUsersPage.saveButtonClick();
		boolean userAddedAlertDisplayed=adminUsersPage.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed,"user not able to add new user.");

	}

	@Test
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterTheUserNameToSearch(newUsername);
		adminUsersPage.searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed=adminUsersPage.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed,"user not able to search for the user.");
	}

	@Test
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.resetButtonClick();
		boolean adminUsersListDisplayed=adminUsersPage.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed,"user list is not reset.");
	}
}
