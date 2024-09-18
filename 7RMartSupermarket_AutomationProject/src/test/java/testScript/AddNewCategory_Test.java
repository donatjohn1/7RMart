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
	AddNewCategory_Page newCategory;
  @Test(description="Verify user able to add new Category")
  @Parameters({"User Name","Password","Catagory Value"})
  public void verifyUserAbleToAddNewCategory(String userNameValue,String passwordValue,String categoryValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue).enterPasswordField(passwordValue);
	  newCategory=loginPage.clickSubmitButton().goToCategory().clickNewButton().inputCategory(categoryValue).clickDiscount().clickRadioTopMenu().clickRadioLeftMenu().clickSave();
	  boolean isAlertDisplayed=newCategory.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWCATEGOYCREATED);
  }
}
