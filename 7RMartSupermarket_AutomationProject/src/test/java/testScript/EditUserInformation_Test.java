package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.EditUserInformation_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class EditUserInformation_Test extends Base{
  @Test(description="verifyUserIsAbleToEditUserInformation")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToEditUserInformation(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  EditUserInformation_Page editUser=new EditUserInformation_Page(driver);
	  editUser.openAdminUserPage();
	  editUser.clickEditUserInformationButton();
	  String newUserNameValue=ExcelUtilities.getStringData(1,0,"EditUser");
	  String newPasswordValue=ExcelUtilities.getStringData(1,1,"EditUser");
	  String newUserTypeValue=ExcelUtilities.getStringData(1,2,"EditUser");
	  editUser.enterEditUserNameField(newUserNameValue);
	  editUser.enterEditPasswordField(newPasswordValue);
	  editUser.selectUserType(newUserTypeValue);
	  editUser.clickUpdateUserButton();
	  boolean isAlertDisplayed=editUser.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFOREDITUSERINFORMATION);
	    
	  
  }
}
