package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SearchListPage_Page;
import utilities.ExcelUtilities;

public class SearchListPage_Test extends LoginPage_Test{
  @Test
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToSearchFromList(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  SearchListPage_Page searchPage=new SearchListPage_Page(driver);
	  searchPage.clickManageContent();
	  searchPage.clickManagePage();
	  searchPage.clickSearch();
	  String titleValue=ExcelUtilities.getStringData(1,0,"SearchListPage");
	  searchPage.enterTitle(titleValue);
	  searchPage.clickSearchButton();
	  boolean isSearchDisplayed=searchPage.isSearchResultNotDisplayed();
	  assertTrue(isSearchDisplayed,Constants.SEARCHELEMENTNOTFOUND);
	  
  }
}
