package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority=1,description="verify user login with valid credentials.",groups= {"smoke"})
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

	@Test(priority=2,description="verify user login with valid username and invalid passwords.")
	public void verifyWhetherUserIsAbleToLoginWithValidUserNameAndInValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		String expected="7rmart supermarket";
		String actual=loginPage.getTheTitle();
		Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
		
	}

	@Test(priority=3,description="verify user login with invalid username and valid password.")
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		String expected="Sign in to start your session";
		String actual=loginPage.getTheLoginBoxMessage();
		Assert.assertEquals(actual,expected,"user was able to login with invalid username.");
	}

	@Test(priority=4,description="verify user login with invalid username and invalid password.",groups= {"smoke"})
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameAndInValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		boolean loginFormDisplayed=loginPage.isLoginFormDisplayed();
		Assert.assertTrue(loginFormDisplayed,"user was able to login with invalid username and password.");
		//String actual=loginPage.getTheLoginBoxMessage();
		//boolean verifyTitle=actual.equalsIgnoreCase("Sign in to start your session in the app.");
		//Assert.assertFalse(verifyTitle, "user was able to login with invalid username  and password.");
	}
	
	
}
