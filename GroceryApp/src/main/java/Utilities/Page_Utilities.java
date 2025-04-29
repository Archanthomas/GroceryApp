package Utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page_Utilities {
	
	WebDriver driver;
	//Drop down with value
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	//Date and time
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	//Drop down with Index
	public String selectDropdownWithIndex(WebElement element,int index) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);
		WebElement selectedElement = select.getFirstSelectedOption(); //it retrieve the first selected option in a drop down list.
		return selectedElement.getText();
		
	}
	//Drop down with visible text
	public String selectDropDownWithVisibletext(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement visible = select.getFirstSelectedOption();
		return visible.getText();
		
	}
	
	//Generic radio button click
	public void clickRadioButton(WebElement radioButton) {
	    if (!radioButton.isSelected()) {
	        radioButton.click();
	    }
	}

}
