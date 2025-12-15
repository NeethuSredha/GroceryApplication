package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	@Test(description = "verify whether admin can add new user.")
	public void verifyWhetherAdminIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoAdminUsersLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton();
		FakerUtility fakerUtility=new FakerUtility();
		String newUsername = fakerUtility.createRandomUsername();
		String newPassword = fakerUtility.createFakePassword();
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminUsersPage.enterUserNameOnUserNameField(newUsername);
		adminUsersPage.enterPasswordOnPasswordField(newPassword);
		adminUsersPage.selectTheUserType(userType);
		adminUsersPage.saveButtonClick();
		boolean userAddedAlertDisplayed=adminUsersPage.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed,"user not able to add new user.");

	}

	@Test(description = "verify whether admin can search the newly added user.")
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoAdminUsersLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterTheUserNameToSearch(newUsername);
		adminUsersPage.searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed=adminUsersPage.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed,"user not able to search for the user.");
	}

	@Test(description = "verify whether admin can reset the users list.")
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoAdminUsersLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.resetButtonClick();
		boolean adminUsersListDisplayed=adminUsersPage.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed,"user list is not reset.");
	}
}
