package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.NewAdminUser_Page;
import utilities.ExcelUtilities;

public class NewAdminUser_Test extends Base{
  @Test(description="Verify wehether user can add new admin User")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToAddNewUser(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  NewAdminUser_Page adminUserPage=new NewAdminUser_Page(driver);
	  adminUserPage.openAdminUserPage();
	  adminUserPage.clickaddNewAdminUserButton();
	  String newUserNameValue=ExcelUtilities.getStringData(3,0,"NewAdminUser");
	  String newPasswordValue=ExcelUtilities.getStringData(3,1,"NewAdminUser");
	  String newUserTypeValue=ExcelUtilities.getStringData(3,2,"NewAdminUser");
	  adminUserPage.enterNewUserNameInField(newUserNameValue);
	  adminUserPage.enterNewPasswordInField(newPasswordValue);
	  adminUserPage.selectUserType(newUserTypeValue);
	  adminUserPage.clickSaveButton();
	  boolean isAlertDisplayed=adminUserPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWUSERCREATED);
	    
  }
}
