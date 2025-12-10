package testScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToLogOutSuccessfully() throws IOException {
		String userName = ExcelUtility.getStringData(10, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminIcon();
		homePage.clickOnLogoutIcon();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, "user was unable to logout from the home page.");
	}
}
