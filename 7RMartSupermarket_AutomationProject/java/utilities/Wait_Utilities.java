package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class Wait_Utilities {
public void waitForAnElementToBeClick(WebDriver driver,WebElement elementName)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(elementName));
}
public void waitforAnElementToBeSelected(WebDriver driver,WebElement elementName)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(elementName));
}
public void waitforVisibilityOf(WebDriver driver,WebElement elementName)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(elementName));
}
public void waitElem(WebDriver driver,WebElement elementName)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(elementName));
}
}
