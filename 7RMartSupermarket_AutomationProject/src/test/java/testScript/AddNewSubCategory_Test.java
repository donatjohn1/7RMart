package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AddNewSubCategory_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class AddNewSubCategory_Test extends Base {
  @Test(description="Verify user able to add new sub category")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToAddNewSubCatagory(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  AddNewSubCategory_Page subCategory=new AddNewSubCategory_Page(driver);
	  subCategory.openSubCatagoryPage();
	  subCategory.clickAddNewSubCatagoryButton();
	  String categoryValue=ExcelUtilities.getStringData(1,0,"AddNewSubCategory");
	  String subCatagoryValue=ExcelUtilities.getStringData(1,1,"AddNewSubCategory");
	  //String fileLocationValue=ExcelUtilities.getStringData(1, 2,"AddNewSubCategory");
	  subCategory.selectCatagoryValue(categoryValue);
	  subCategory.enterSubCatagory(subCatagoryValue);
	  //subCategory.uploadImgFile1(fileLocationValue);
	  subCategory.saveNewSubCatagory();
	  boolean isAlertDisplayed=subCategory.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWSUBCATEGORYADDED);
  }
}
