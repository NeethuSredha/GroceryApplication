package testScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constant.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homePage;

	@Test(description = "verify user logs out successfully.", retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToLogOutSuccessfully() throws IOException {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(userName).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		homePage.clickOnAdminIcon();
		loginPage = homePage.clickOnLogoutIcon();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitleOnLogin();
		Assert.assertEquals(actual, expected, Constants.LOGOUTERROR);
	}
}
