package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class Manage_Product_Search_Page {
	WebDriver driver;
	public Manage_Product_Search_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	FileUpload_Utilities input=new FileUpload_Utilities();
	Page_Utilities page=new Page_Utilities();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement manageProductPage;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath="//input[@name='cd']")WebElement titleField;
	@FindBy(xpath="//input[@name='un']")WebElement productCodeField;
	@FindBy(xpath="//select[@id='cat_id']")WebElement categoryDropDown;
	@FindBy(xpath="//select[@id='sb']")WebElement subCategoryDropDown;
	@FindBy(xpath="//button[@value='sr']")WebElement searchButtonForResult;
	public void openManageProductPage(){
		manageProductPage.click();	
	}
	public void searchButtonClick() {
		searchButton.click();
	}
	public void enterTitleFieldValue(String title) {
		input.usingSendKeys(titleField, title);
	}
	public void enterProductCodeFieldValue(String pCode){
		input.usingSendKeys(productCodeField, pCode);
	}
	public void categoryDropDownSelect(String category) {
		page.selectMethord(categoryDropDown, category);
	}
	public void subCategoryDropDownSelect(String subCategory) {
		page.selectMethord(subCategoryDropDown, subCategory);
		}
	public void searchButtonClickForResult() {
		searchButtonForResult.click();
	}
	public boolean isAllValueSubmitted() {
		return searchButtonForResult.isDisplayed();
	}
	
	
}

