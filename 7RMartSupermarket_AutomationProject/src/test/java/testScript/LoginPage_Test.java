package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.NewAdminUser_Page;
import utilities.ExcelUtilities;

public class LoginPage_Test extends Base {
	Login_Page loginPage;
	NewAdminUser_Page adminUser;

	@DataProvider(name = "Credentials")
	public Object[][] testData() {// data provider
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;

	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginUsingValidCredentials()throws IOException
	{
		String userNameValue=ExcelUtilities.getStringData(5,0,"Login_Page");
		String passwordValue=ExcelUtilities.getStringData(5,1,"Login_Page");
		String newUserNameValue=ExcelUtilities.getStringData(1,0,"NewAdminUser");
		  String newPasswordValue=ExcelUtilities.getStringData(1,1,"NewAdminUser");
		  String newUserTypeValue=ExcelUtilities.getStringData(1,2,"NewAdminUser");
		loginPage = new Login_Page(driver);
		adminUser = loginPage.enterUserNameField(userNameValue).enterPasswordField(passwordValue).clickSubmitButton()
				.openAdminUserPage().clickaddNewAdminUserButton().enterNewUserNameInField(newUserNameValue).enterNewPasswordInField(newPasswordValue).selectUserType(newUserTypeValue).clickSaveButton();
		boolean isHomePageIsLoaded = loginPage.isDashboardisLoaded();
		assertTrue(isHomePageIsLoaded, Constants.ERRORMSGFORLOGIN);
	}

	@Test(groups = { "Smoke testing" })
	@Parameters({ "Invalid User Name", "Password" })
	public void verifyUserIsAbleToLoginUsingInvalidUsernameValidPassword(String userNameValue, String passwordValue)
			throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		loginPage.enterUserNameField(userNameValue);
		loginPage.enterPasswordField(passwordValue);
		loginPage.clickSubmitButton();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		assertTrue(isAlertDisplayed, Constants.ALERTMSGFORLOGIN);
	}

	@Test(dataProvider = "Credentials")
	public void verifyUserIsAbleToLoginUsingValidUsernameInvalidPassword(String userNameValue, String inpasswordValue)
			throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		loginPage.enterUserNameField(userNameValue);
		loginPage.enterPasswordField(inpasswordValue);
		loginPage.clickSubmitButton();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		assertTrue(isAlertDisplayed, Constants.ALERTMSGFORLOGIN);

	}

	@Test
	public void verifyUserIsAbleToLoginUsinginvalidCredentials() throws IOException {
		String userNameValue = ExcelUtilities.getStringData(4, 0, "Login_Page");
		String passwordValue = ExcelUtilities.getStringData(4, 1, "Login_Page");
		Login_Page loginPage = new Login_Page(driver);
		loginPage.enterUserNameField(userNameValue);
		loginPage.enterPasswordField(passwordValue);
		loginPage.clickSubmitButton();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		assertTrue(isAlertDisplayed, Constants.ALERTMSGFORLOGIN);
	}

}
