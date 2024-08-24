package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.DeleteCategoryDetails_Page;
import pages.Login_Page;

public class DeleteCategoryDetails_Test extends Base
{
  @Test(description="Verify user able to Delete Category Details")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToDeleteCatagory(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  DeleteCategoryDetails_Page subCategory=new DeleteCategoryDetails_Page(driver);
	  subCategory.openCatagoryPage();
	  subCategory.clickDeleteCatagoryButton();
	  boolean isAlertDisplayed=subCategory.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORDELETECATEGORY);
  }
}
