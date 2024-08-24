package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SearchCatagory_Page;

public class SearchCatagory_Test extends Base{
	  @Test(description="verify User Able To Add New Category")
	  @Parameters({"User Name","Password","Catagory"})
	  public void verifyUserAbleToSearchCategory(String userNameValue,String passwordValue,String categoryValue) throws IOException {
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  
		  SearchCatagory_Page searchCategory=new SearchCatagory_Page(driver);
		  searchCategory.goToCategory();
		  searchCategory.clickSearhButtonToOpenSearchPage();
		  //String categoryValue=ExcelUtilities.getStringData(1,0,"SearchCategory");
		  searchCategory.inputCategory(categoryValue);
		  searchCategory.clickSearchButton();
		  boolean isSearchDisplayed=searchCategory.isSearchResultNotDisplayed();
		  assertTrue(isSearchDisplayed,Constants.SEARCHCATEGORYNOTFOUND);
  }
}
