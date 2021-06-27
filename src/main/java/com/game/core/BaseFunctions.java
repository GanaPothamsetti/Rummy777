package com.game.core;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunctions extends Base {

	public void wait(int sec,String elementId) {
		
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById(elementId)));
	}
	
	public boolean isElementDispayedById(String element) {
		boolean isElementDisplayed=driver.findElementById(element).isDisplayed();		
		return isElementDisplayed;
	}
	
	
	
}
