package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import constants.Constants;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class LoginPage_Test extends Base {
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
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToLoginUsingValidCredentials(String userNameValue,String passwordValue) throws IOException {
	  //String userNameValue="admin";
	  //String passwordValue="admin";
	  //String userNameValue=ExcelUtilities.getStringData(1,0,"Login_Page");
	  //String passwordValue=ExcelUtilities.getStringData(1,1,"Login_Page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  boolean isHomePageIsLoaded=loginPage.isDashboardisLoaded();
	  assertTrue(isHomePageIsLoaded,Constants.ERRORMSGFORLOGIN);
  }
	  @Test(groups= {"Smoke testing"})
	  @Parameters({"Invalid User Name","Password"})
	  public void verifyUserIsAbleToLoginUsingInvalidUsernameValidPassword(String userNameValue,String passwordValue) throws IOException {
		  //String userNameValue="4567admin";
		  //String passwordValue="admin";
		  //String userNameValue=ExcelUtilities.getStringData(2,0,"Login_Page");
		  //String passwordValue=ExcelUtilities.getStringData(2,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
	  }
	  
	  @Test(dataProvider="Credentials")
	  public void verifyUserIsAbleToLoginUsingValidUsernameInvalidPassword(String userNameValue,String inpasswordValue) throws IOException {
		  //String userNameValue=ExcelUtilities.getStringData(3,0,"Login_Page");
		  //String passwordValue=ExcelUtilities.getStringData(3,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(inpasswordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
		 
	  }
	  @Test
	  @Parameters({"Invalid User Name","InvalidPassword"})
	  public void verifyUserIsAbleToLoginUsinginvalidCredentials() throws IOException {
		  String userNameValue=ExcelUtilities.getStringData(4,0,"Login_Page");
		  String passwordValue=ExcelUtilities.getStringData(4,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
	  }
	 
}
