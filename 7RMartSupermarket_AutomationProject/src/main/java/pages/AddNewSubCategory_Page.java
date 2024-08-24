package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utilities;
import utilities.Wait_Utilities;

public class AddNewSubCategory_Page {
WebDriver driver;
public AddNewSubCategory_Page(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement subCatagoryPageLink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewSubCatagoryButton;
@FindBy(xpath="//select[@id='cat_id']")WebElement selectCatagory;
@FindBy(xpath="//input[@id='subcategory']")WebElement subCatagoryField;
@FindBy(xpath="//input[@id='main_img']")WebElement chooseImageFile;
@FindBy(xpath="//button[@type='submit']")WebElement saveSubCatagoryButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
Page_Utilities page=new Page_Utilities();
public void openSubCatagoryPage()
{
	subCatagoryPageLink.click();
}
public void clickAddNewSubCatagoryButton()
{
	addNewSubCatagoryButton.click();
}
public void selectCatagoryValue(String catagory)
{
	page.selectMethord(selectCatagory,catagory);
}
public void enterSubCatagory(String subCatagory)
{
	subCatagoryField.sendKeys(subCatagory);
}
public void uploadImgFile1(String upload)
{
	chooseImageFile.sendKeys(upload);
}
public void saveNewSubCatagory() 
{
	Wait_Utilities wait1=new Wait_Utilities();
	wait1.waitForAnElementToBeClick(driver,saveSubCatagoryButton);
	saveSubCatagoryButton.click();
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
}
