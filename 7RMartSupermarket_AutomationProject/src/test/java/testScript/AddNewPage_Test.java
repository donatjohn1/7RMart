package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AddNewPage_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class AddNewPage_Test extends Base {
  @Test(description="Verify user able to add new Page")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToAddNewPage(String userNameValue,String passwordValue) throws IOException
  {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	AddNewPage_Page addNewPage=new AddNewPage_Page(driver);
	addNewPage.clickManageContent();
	addNewPage.clickManagePage();
	addNewPage.clickNewPage();
	String titleValue=ExcelUtilities.getStringData(1,0,"AddNewPage");
	String descriptionValue=ExcelUtilities.getStringData(1,1,"AddNewPage");
	String pageNameValue=ExcelUtilities.getStringData(1,2,"AddNewPage");
	String fileLocationValue=ExcelUtilities.getStringData(1,3,"AddNewPage");
	addNewPage.enterTitle(titleValue);
	addNewPage.enterDescription(descriptionValue);
	addNewPage.enterPageName(pageNameValue);
	addNewPage.uploadFile1(fileLocationValue);
	addNewPage.saveNewPage();
	boolean isAlertDisplayed=addNewPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWPAGECREATED);
  }
}
