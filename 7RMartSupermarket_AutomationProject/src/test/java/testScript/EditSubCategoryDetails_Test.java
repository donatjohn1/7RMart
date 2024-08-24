package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.EditSubCategoryDetails_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class EditSubCategoryDetails_Test extends LoginPage_Test {
  @Test(description="verify User Is Able To Edit Sub Catagory")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToEditSubCatagory(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  EditSubCategoryDetails_Page subCategory=new EditSubCategoryDetails_Page(driver);
	  subCategory.openSubCatagoryPage();
	  subCategory.clickEditSubCatagoryButton();
	  String categoryValue=ExcelUtilities.getStringData(1,0,"EditSubCategory");
	  String subCatagoryValue=ExcelUtilities.getStringData(1,1,"EditSubCategory");
	  //String fileLocationValue=ExcelUtilities.getStringData(1, 2,"EditSubCategory");
	  subCategory.selectCatagoryValue(categoryValue);
	  subCategory.enterSubCatagory(subCatagoryValue);
	  //subCategory.uploadImgFile1(fileLocationValue);
	  subCategory.updateNewSubCatagory();
	  boolean isAlertDisplayed=subCategory.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFOREDITSUBCATEGORY);  
  }
}
