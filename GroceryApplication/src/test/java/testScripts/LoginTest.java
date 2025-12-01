package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
	}

	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidUserNameAndInValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		String expected="7rmart supermarke";
		String actual=loginPage.getTheTitle();
		Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
		
	}

	@Test
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
	}

	@Test
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndInValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
	}
}
