package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;
import utilities.Wait_Utilities;

public class EditSubCategoryDetails_Page {
WebDriver driver;
	public EditSubCategoryDetails_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement subCatagoryPageLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[5]//i[@class='fas fa-edit']")WebElement editSubCatagoryButton;
	@FindBy(xpath="//select[@id='cat_id']")WebElement selectCatagory;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subCatagoryField;
	@FindBy(xpath="//input[@name='main_img']")WebElement chooseImageFile;
	@FindBy(xpath="//button[@type='submit']")WebElement updateSubCatagoryButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	FileUpload_Utilities input=new FileUpload_Utilities();
	public void openSubCatagoryPage()
	{
		subCatagoryPageLink.click();
	}
	public void clickEditSubCatagoryButton()
	{
		editSubCatagoryButton.click();
	}
	public void selectCatagoryValue(String catagory)
	{
		Page_Utilities page=new Page_Utilities();
		page.selectMethord(selectCatagory,catagory);
	}
	public void enterSubCatagory(String subCatagory)
	{
		subCatagoryField.clear();
		subCatagoryField.sendKeys(subCatagory);
	}
	public void uploadImgFile1(String upload)
	{
		FileUpload_Utilities.fileUpload_RobertClass(chooseImageFile, upload);
	}
	public void updateNewSubCatagory() 
	{
		Wait_Utilities wait1=new Wait_Utilities();
		wait1.waitForAnElementToBeClick(driver,updateSubCatagoryButton);
		updateSubCatagoryButton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}

}
