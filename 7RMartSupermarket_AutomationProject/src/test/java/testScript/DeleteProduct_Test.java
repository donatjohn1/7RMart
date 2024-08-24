package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.DeleteProduct_Page;
import pages.Login_Page;


public class DeleteProduct_Test extends Base
{
  @Test(description="Verify user able to Delete a Product")
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToDeleteProduct(String userNameValue,String passwordValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  DeleteProduct_Page product=new DeleteProduct_Page(driver);
	  product.openManageProductPage();
	  product.clickDeleteProductButton();
	  boolean isAlertDisplayed=product.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORDELETEPRODUCT);
  }
}
