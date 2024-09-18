package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.DeleteAdminUser_Page;
import pages.Login_Page;

public class DeleteAdminUser_Test extends Base {
	DeleteAdminUser_Page adminUser;
  @Test(description="Verify user able to delete an admin user")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToDeleteUserFromList(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue).enterPasswordField(passwordValue);
	  adminUser=loginPage.clickSubmitButton().openAdminUserPageDelete().clickDeleteAdminUserButton();
	  boolean isAlertDisplayed=adminUser.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORDELETEADMINUSER);	  
}
}
