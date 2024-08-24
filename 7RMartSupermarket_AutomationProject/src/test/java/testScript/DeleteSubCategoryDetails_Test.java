package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.DeleteSubCategoryDetails_Page;
import pages.Login_Page;

public class DeleteSubCategoryDetails_Test extends Base {
  @Test(description="verify User Is Able To Delete SubCatagory")
  @Parameters({"User Name","Password"})
	  public void verifyUserIsAbleToDeleteSubCatagory(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
		  DeleteSubCategoryDetails_Page subCategory=new DeleteSubCategoryDetails_Page(driver);
		  subCategory.openSubCatagoryPage();
		  subCategory.clickDeleteSubCatagoryButton();
		  boolean isAlertDisplayed=subCategory.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORDELETESUBCATEGORY);
		  
  }
}
