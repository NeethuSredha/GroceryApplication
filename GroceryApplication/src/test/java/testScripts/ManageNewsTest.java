package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "verify whether new news can be created.")
	public void verifyWhetherNewNewsCanBeCreated() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickOnNewButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterTheNewsInformation(news);
		newsPage.clickOnSaveButton();
		boolean newsCreatedAlert = newsPage.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, Constants.ADDNEWNEWSERROR);

	}

	@Test(description = "verify whether news can be searched.")
	public void verifyWhetherNewsCanBeSearched() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickOnSearchButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterTheNewsToSearch(news);
		newsPage.searchButtonClickToSearchNews();
		String expected = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actual = newsPage.newsDisplayedList();
		Assert.assertEquals(actual, expected, Constants.SEARCHNEWSERROR);
	}

	@Test(description = "verify whether news list can be reset.")
	public void verifyWhetherTheListCanBeReset() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.resetButtonClick();
		boolean newsResetListDisplayed = newsPage.isNewsResetListDisplayed();
		Assert.assertTrue(newsResetListDisplayed, Constants.NEWSLISTNOTRESETERROR);
	}
}
