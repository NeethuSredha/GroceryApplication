package constant;

public class Constants {

	public static final String EXCELFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public static final String VALIDCREDENTIALERROR = "user was unable to login with valid credentials.";
	public static final String VALIDUSERNAMEINVALIDPASSWORDERROR = "user was able to login with invalid password.";
	public static final String INVALIDUSERNAMEVALIDPASSWORDERROR = "user was able to login with invalid username.";
	public static final String INVALIDUSERNAMEINVALIDPASSWORDERROR = "user was able to login with invalid username and password.";

	public static final String LOGOUTERROR = "user was unable to logout from the home page.";

	public static final String ADDNEWUSERERROR = "user not able to add new user.";
	public static final String SEARCHUSERERROR = "user not able to search for the user.";
	public static final String USERLISTNOTRESETERROR = "user list is not reset.";

	public static final String ADDNEWNEWSERROR = "unable to create new news information.";
	public static final String SEARCHNEWSERROR = "Unable to search the news.";
	public static final String NEWSLISTNOTRESETERROR = "News list is not reset.";

}
