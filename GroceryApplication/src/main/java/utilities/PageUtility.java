package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropDownWithVisibleText(WebElement element, String visibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleText);
	}
	
	public void selectDropDownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}

	public void selectTheCheckBox(WebElement element) {
		element.click();
	}

	public void selectTheRadioButton(WebElement element) {
		element.click();
	}

	public void rightClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();

	}

	public void mouseHover(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void dragAndDrop(WebElement dragMe, WebElement dropHere, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMe, dropHere).build().perform();
	}

}
