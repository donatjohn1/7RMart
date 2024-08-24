package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AddNewCategory_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class AddNewCategory_Test extends Base {
  @Test(description="Verify user able to add new Category")
  @Parameters({"User Name","Password"})
  public void verifyUserAbleToAddNewCategory(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  AddNewCategory_Page newCategory=new AddNewCategory_Page(driver);
	  newCategory.goToCategory();
	  newCategory.clickNewButton();
	  String categoryValue=ExcelUtilities.getStringData(1,0,"AddNewCategory");
	  String selectGroupValue=ExcelUtilities.getStringData(1,1,"AddNewCategory");
	  String image=ExcelUtilities.getStringData(1,2,"AddNewCategory");
	  newCategory.inputCategory(categoryValue);
	  newCategory.clickDiscount();
	  //newCategory.imageUpload(image);
	  newCategory.clickRadioTopMenu();
	  newCategory.clickRadioLeftMenu();
	  newCategory.clickSave();
	  boolean isAlertDisplayed=newCategory.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWCATEGOYCREATED);
  }
}
