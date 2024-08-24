package testScript;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddNewProduct_Page;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class AddNewProduct_Test extends LoginPage_Test {
  @Test(description="Verify user able to Add New Product")
  @Parameters({"User Name","Password"})
  public void verifyIfUserAbleToAddNewProduct(String userNameValue,String passwordValue) throws IOException 
  {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  AddNewProduct_Page newProduct=new AddNewProduct_Page(driver);
	  newProduct.openManageProductPage();
	  newProduct.clickAddNewProductButton();
	  String title=ExcelUtilities.getStringData(1,0,"AddProduct");
	  String tag=ExcelUtilities.getStringData(1,1,"AddProduct");
	  String category=ExcelUtilities.getStringData(1,2,"AddProduct");
	  String subCategory=ExcelUtilities.getStringData(1,3,"AddProduct");
	  String group=ExcelUtilities.getStringData(1,4,"AddProduct");
	  String weightValue=ExcelUtilities.getIntegerData(1,5,"AddProduct");
	  String weightUnit=ExcelUtilities.getIntegerData(1,6,"AddProduct");
	  String maxQuantityCanBeOrdered=ExcelUtilities.getIntegerData(1,7,"AddProduct");
	  String price=ExcelUtilities.getIntegerData(1,8,"AddProduct");
	  String mrp=ExcelUtilities.getIntegerData(1,9,"AddProduct");
	  String stockAvail=ExcelUtilities.getIntegerData(1,10,"AddProduct");
	  String purchasePrice=ExcelUtilities.getIntegerData(1,11,"AddProduct");
	  String description=ExcelUtilities.getStringData(1,12,"AddProduct");
	  String img=ExcelUtilities.getStringData(1,13,"AddProduct");
	  String sub_Img=ExcelUtilities.getStringData(1,14,"AddProduct");
	  newProduct.enterTitleValue(title);
	  newProduct.clickRadioProductType();
	  newProduct.enterTagFieldValue(tag);
	  newProduct.selectCategoryValue(category);
	  newProduct.selectSubCategoryValue(subCategory);
	  newProduct.selectGroup(group);
	  newProduct.clickPriceType();
	  newProduct.enterWeightValue(weightValue);
	  newProduct.selectWeightUnit(weightUnit);
	  newProduct.enterMaxWeight(maxQuantityCanBeOrdered);
	  newProduct.enterPrice(price);
	  newProduct.enterMRP(mrp);
	  newProduct.enterStockAvailable(stockAvail);
	  newProduct.enterPurchasePrice(purchasePrice);
	  newProduct.checkUnlimitedStockBox();
	  newProduct.enterDescription(description);
	  newProduct.checkStock();
	  newProduct.selectImage(sub_Img);
	  newProduct.selectSubImage(img);
	  newProduct.clickFeatured();
	  newProduct.clickComboPack();
	  newProduct.clickSaveButton();
  }
}
