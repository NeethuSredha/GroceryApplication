package testScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationCore.Base;
import constant.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description="verify user logs out successfull.",retryAnalyzer = retry.Retry.class,dataProvider = "HomeProvider")
	public void verifyWhetherUserIsAbleToLogOutSuccessfully(String userName, String password) throws IOException {
		//String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		//String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signInButtonClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminIcon();
		homePage.clickOnLogoutIcon();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, Constants.LOGOUTERROR);
	}
	
	@DataProvider(name = "HomeProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { "admin", "admin" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
