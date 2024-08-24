package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.Manage_Product_Search_Page;
import utilities.ExcelUtilities;

public class Manage_Product_Search_Test extends LoginPage_Test {
  @Test(description="Verify user able to search product in manage product")
  @Parameters({"User Name","Password"})
  public void verifyUserCanSearchProductInManagePage(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  Manage_Product_Search_Page searchProduct=new Manage_Product_Search_Page(driver);
	  searchProduct.openManageProductPage();
	  searchProduct.searchButtonClick();
	  String titleName=ExcelUtilities.getStringData(1,0,"SearchProduct");
	  String proCode=ExcelUtilities.getStringData(1,1,"SearchProduct");
	  String categoryValue=ExcelUtilities.getStringData(1,2,"SearchProduct");
	  String subCategoryValue=ExcelUtilities.getStringData(1,3,"SearchProduct");
	  searchProduct.enterTitleFieldValue(titleName);
	  searchProduct.enterProductCodeFieldValue(proCode);
	  searchProduct.categoryDropDownSelect(categoryValue);
	  searchProduct.subCategoryDropDownSelect(subCategoryValue);
	  searchProduct.searchButtonClickForResult();
	  boolean isAllValueSubmitted=searchProduct.isAllValueSubmitted();
	  assertTrue(isAllValueSubmitted,Constants.MANAGEPRODUCTSEARCH);
  }
}
