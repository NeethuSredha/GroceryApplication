package testScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homePage;
	AdminUsersPage adminUsersPage;

	@Test(priority = 1, description = "verify whether admin can add new user.")
	public void verifyWhetherAdminIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		adminUsersPage = homePage.clickOnMoreInfoAdminUsersLink();
		adminUsersPage.clickOnAdminNewButton();
		FakerUtility fakerUtility = new FakerUtility();
		String newUsername = fakerUtility.createRandomUsername();
		String newPassword = fakerUtility.createFakePassword();
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminUsersPage.enterUserNameOnUserNameFieldOnAdmin(newUsername).enterPasswordOnPasswordFieldOnAdmin(newPassword)
				.selectTheUserTypeOnAdmin(userType).saveButtonClickOnAdmin();
		boolean userAddedAlertDisplayed = adminUsersPage.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed, Constants.ADDNEWUSERERROR);

	}

	@Test(priority = 2, description = "verify whether admin can search the newly added user.")
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		adminUsersPage = homePage.clickOnMoreInfoAdminUsersLink();
		adminUsersPage.searchButtonClickOnAdmin();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterTheUserNameToSearchOnAdmin(newUsername).searchButtonClickToCheckUserNameOnAdmin();
		boolean adminUsersResultTabDisplayed = adminUsersPage.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed, Constants.SEARCHUSERERROR);
	}

	@Test(priority = 3, description = "verify whether admin can reset the users list.")
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		adminUsersPage = homePage.clickOnMoreInfoAdminUsersLink();
		adminUsersPage.resetButtonClickOnAdmin();
		boolean adminUsersListDisplayed = adminUsersPage.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed, Constants.USERLISTNOTRESETERROR);
	}
}
