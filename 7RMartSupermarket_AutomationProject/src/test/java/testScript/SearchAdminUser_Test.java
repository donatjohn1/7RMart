package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SearchAdminUser_Page;
import utilities.ExcelUtilities;
public class SearchAdminUser_Test extends Base {
  @Test(description="Verify User Is Able To SearchUser")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToSearchUser(String userNameValue,String passwordValue) throws IOException
  {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  SearchAdminUser_Page searchUser=new SearchAdminUser_Page(driver);
	  searchUser.openAdminUserPage();
	  searchUser.clickSearchAdminUserButton();
	  String searchUserName=ExcelUtilities.getStringData(1,0,"SearchUser");
	  String srchUserType=ExcelUtilities.getStringData(1, 1,"SearchUser");
	  searchUser.enterUserName(searchUserName);
	  searchUser.userType(srchUserType);
	  searchUser.clickSearchButton();
	  boolean isSearchDisplayed=searchUser.isSearchResultDisplayed();
	  assertTrue(isSearchDisplayed,Constants.SEARCHUSERNOTFOUND);
	  
  }
}
