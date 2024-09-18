package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utilities {
	//Reusable code
	WebDriver driver;
	public void selectMethord(WebElement element,String element_Text)
	{
	Select select=new Select(element);
	select.selectByVisibleText(element_Text);
	}
	public void selectElementUsingValue(WebElement element,String element_Text)
	{
	Select select=new Select(element);
	select.selectByValue(element_Text);
	}
	public void drag_Drop_Elements(WebElement element1,WebElement element2) {
		Actions action=new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}
	public void javaScriptExecutorLocator(WebElement element,String element_Text)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("widow.scrollBy(0,document.body.scrolHeight","");
		js.executeScript("arguments[0].click()", element);
		element.click();
	}
	
	public void selectElementUsingIndex(WebElement element,int element_Num)
	{
	Select select=new Select(element);
	select.selectByIndex(element_Num);
	}
}
