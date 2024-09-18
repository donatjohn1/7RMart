package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class AddNewProduct_Page {
WebDriver driver;
public AddNewProduct_Page(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement manageProductPage;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")WebElement addNewProductButton;
@FindBy(xpath="//input[@id='title']")WebElement titleField;
@FindBy(xpath="//input[@value='Veg']")WebElement radioProductType;
@FindBy(xpath="//input[@id='tag']")WebElement tagField;
@FindBy(xpath="//select[@id='grp_id']")WebElement categoryField;
@FindBy(xpath="//select[@id='sub_id']")WebElement subCategoryField;
@FindBy(xpath="//select[@id='grp_id']")WebElement groupField;
@FindBy(xpath="//input[@value='weight']")WebElement radioPriceType;
@FindBy(xpath="//input[@id='m_weight']")WebElement weightValueField;
@FindBy(xpath="//select[@id='w_unit']")WebElement weightUnit;
@FindBy(xpath="//input[@id='max_weight']")WebElement maxWeightField;
@FindBy(xpath="//input[@id='w_price']")WebElement priceField;
@FindBy(xpath="w_mrp")WebElement productMRP_Field;
@FindBy(xpath="//input[@id='w_stock']")WebElement stockAvailableField;
@FindBy(xpath="//input[@id='w_pp']")WebElement purchasePriceField;
@FindBy(xpath="//input[@value='yes'][@name='unlimitw[]']")WebElement checkUnlimitedStock;
@FindBy(xpath="//div[@class='note-editable card-block']")WebElement Description;
@FindBy(xpath="//input[@name='stock'][@value='yes']")WebElement radioStock;
@FindBy(xpath="//input[@id='main_img']")WebElement chooseImage;
@FindBy(xpath="//input[@id='main_imgs']")WebElement chooseSubImage;
@FindBy(xpath="//input[@value='no'][@name='featured']")WebElement radioFeatured;
@FindBy(xpath="//input[@value='no'][@name='combo']")WebElement radioComboPack;
@FindBy(xpath="//button[@type='submit']")WebElement saveProductButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
FileUpload_Utilities input=new FileUpload_Utilities();
Page_Utilities page=new Page_Utilities();
public void openManageProductPage()
{
	manageProductPage.click();
}
public void clickAddNewProductButton()
{
	addNewProductButton.click();
}
public void enterTitleValue(String title)
{
	input.usingSendKeys(titleField, title);
}
public void clickRadioProductType()
{
radioProductType.click();
}
public void enterTagFieldValue(String tag)
{
	input.usingSendKeys(tagField, tag);
}
public void selectCategoryValue(String category)
{
	page.selectMethord(categoryField,category);
}
public void selectSubCategoryValue(String subCategory)
{
	page.selectMethord(subCategoryField, subCategory);
}
public void selectGroup(String group)
{
	page.selectMethord(groupField, group);
}
public void clickPriceType()
{
	radioPriceType.click();
}
public void enterWeightValue(String weight)
{
	input.usingSendKeys(weightValueField, weight);
}
public void selectWeightUnit(String unit)
{
	page.selectMethord(weightUnit, unit);
}
public void enterMaxWeight(String maxWeight)
{
	input.usingSendKeys(maxWeightField, maxWeight);
}
public void enterPrice(String price)
{
	input.usingSendKeys(priceField, price);
}
public void enterMRP(String mrp)
{
	input.usingSendKeys(productMRP_Field, mrp);
}
public void enterStockAvailable(String stockAvailable)
{
	input.usingSendKeys(stockAvailableField, stockAvailable);
}
public void enterPurchasePrice(String purchasePrice)
{
	input.usingSendKeys(purchasePriceField, purchasePrice);
}
public void checkUnlimitedStockBox()
{
	if(checkUnlimitedStock.isEnabled()==false)
	{
	checkUnlimitedStock.click();
	}
}
public void enterDescription(String description)
{
	input.usingSendKeys(Description, description);
}
public void checkStock()
{
	radioStock.click();
}
public void selectImage(String img)
{
	input.usingSendKeys(chooseImage, img);
}
public void selectSubImage(String subImg)
{
	input.usingSendKeys(chooseSubImage, subImg);
}
public void clickFeatured()
{
	radioFeatured.click();
}
public void clickComboPack()
{
	radioComboPack.click();
}
public void clickSaveButton()
{
	saveProductButton.click();
}

}