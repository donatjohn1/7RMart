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
	SearchAdminUser_Page searchUser;
  @Test(description="Verify User Is Able To SearchUser")
  @Parameters({"User Name","Password","Search UserName","Search User Type"})
  public void verifyUserIsAbleToSearchUser(String userNameValue,String passwordValue,String searchUserName,String srchUserType) throws IOException{
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue).enterPasswordField(passwordValue);
	  searchUser=loginPage.clickSubmitButton().openAdminUserPageSearch().clickSearchAdminUserButton().enterUserName(searchUserName).userType(srchUserType).clickSearchButton();
	  boolean isSearchDisplayed=searchUser.isSearchResultNotDisplayed();
	  assertTrue(isSearchDisplayed,Constants.SEARCHUSERNOTFOUND);
	  
  }
}
