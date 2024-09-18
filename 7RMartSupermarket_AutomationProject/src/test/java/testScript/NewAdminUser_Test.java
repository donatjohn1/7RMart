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
	NewAdminUser_Page adminUserPage;
  @Test(description="Verify wehether user can add new admin User")
  @Parameters({"User Name","Password","New User Name","New Password","User Type"})
  public void verifyUserIsAbleToAddNewUser(String userNameValue,String passwordValue,String newUserNameValue,String newPasswordValue,String newUserTypeValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue).enterPasswordField(passwordValue);
	  //String newUserNameValue=ExcelUtilities.getStringData(1,0,"NewAdminUser");
	  //String newPasswordValue=ExcelUtilities.getStringData(1,1,"NewAdminUser");
	  //String newUserTypeValue=ExcelUtilities.getStringData(1,2,"NewAdminUser");
	  //NewAdminUser_Page adminUserPage=new NewAdminUser_Page(driver);
	  adminUserPage=loginPage.clickSubmitButton().openAdminUserPage().clickaddNewAdminUserButton().enterNewUserNameInField(newUserNameValue).enterNewPasswordInField(newPasswordValue).selectUserType(newUserTypeValue).clickSaveButton();
	  boolean isAlertDisplayed=adminUserPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWUSERCREATED);
	    
  }
}
