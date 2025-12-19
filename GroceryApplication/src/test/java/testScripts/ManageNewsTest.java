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
	HomePage homePage;
	ManageNewsPage manageNewsPage;

	@Test(priority = 1, description = "verify whether new news can be created.")
	public void verifyWhetherNewNewsCanBeCreated() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		manageNewsPage = homePage.clickOnMoreInfoManageNewsLink();
		manageNewsPage.clickOnNewButtonOnManageNews();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		manageNewsPage.enterTheNewsInformationOnManageNews(news).clickOnSaveButtonOnManageNews();
		boolean newsCreatedAlert = manageNewsPage.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, Constants.ADDNEWNEWSERROR);

	}

	@Test(priority = 2, description = "verify whether news can be searched.")
	public void verifyWhetherNewsCanBeSearched() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		manageNewsPage = homePage.clickOnMoreInfoManageNewsLink();
		manageNewsPage.clickOnSearchButtonOnManageNews();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		manageNewsPage.enterTheNewsToSearchOnManageNews(news).searchButtonClickToSearchNewsOnManageNews();
		String expected = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actual = manageNewsPage.newsDisplayedList();
		Assert.assertEquals(actual, expected, Constants.SEARCHNEWSERROR);
	}

	@Test(priority = 3, description = "verify whether news list can be reset.")
	public void verifyWhetherTheListCanBeReset() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFieldOnLogin(username).enterPasswordOnPasswordFieldOnLogin(password);
		homePage = loginPage.signInButtonClickOnLogin();
		manageNewsPage = homePage.clickOnMoreInfoManageNewsLink();
		manageNewsPage.resetButtonClickOnManageNews();
		boolean newsResetListDisplayed = manageNewsPage.isNewsResetListDisplayed();
		Assert.assertTrue(newsResetListDisplayed, Constants.NEWSLISTNOTRESETERROR);
	}
}
