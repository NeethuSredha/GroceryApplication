package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homePage;

	@Test(priority = 1, description = "verify user login with valid credentials.", groups = { "smoke" })
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		homePage = loginPage.signInButtonClick();
		boolean dashboardDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constants.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "verify user login with valid username and invalid passwords.")
	public void verifyWhetherUserIsAbleToLoginWithValidUserNameAndInValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).signInButtonClick();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, Constants.VALIDUSERNAMEINVALIDPASSWORDERROR);

	}

	@Test(priority = 3, description = "verify user login with invalid username and valid password.")
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).signInButtonClick();
		String expected = "Sign in to start your session";
		String actual = loginPage.getTheLoginBoxMessage();
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}

	@Test(priority = 4, description = "verify user login with invalid username and invalid password.", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndInValidPassword(String userName, String password)
			throws IOException {
		// String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).signInButtonClick();
		boolean loginFormDisplayed = loginPage.isLoginFormDisplayed();
		Assert.assertTrue(loginFormDisplayed, Constants.INVALIDUSERNAMEINVALIDPASSWORDERROR);
		// String actual=loginPage.getTheLoginBoxMessage();
		// boolean verifyTitle=actual.equalsIgnoreCase("Sign in to start your session in
		// the app.");
		// Assert.assertFalse(verifyTitle, "user was able to login with invalid username
		// and password.");
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
