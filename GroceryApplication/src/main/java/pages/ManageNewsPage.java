package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),' New')]") WebElement newButton;
	@FindBy(id="news") WebElement newsTextBox;
	@FindBy(xpath="//button[@type='submit' and @name='create']") WebElement saveButton;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement searchButton;
	@FindBy(xpath="//input[@name='un' and @placeholder='Title']") WebElement newsTitlePlaceHolder;
	@FindBy(name="Search") WebElement buttonToSearchNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newsCreatedSuccessAlert;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") WebElement newsDisplayedList;
	@FindBy(xpath="//a[contains(text(),' Reset')]") WebElement resetLink;
	@FindBy(xpath="//table[@class=\"table table-bordered table-hover table-sm\"]") WebElement resetDisplayedTab;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterTheNewsInformation(String news) {
		newsTextBox.sendKeys(news);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void enterTheNewsToSearch(String news) {
		newsTitlePlaceHolder.sendKeys(news);
	}
	
	public void searchButtonClickToSearchNews() {
		buttonToSearchNews.click();
	}
	
	public void resetButtonClick() {
		resetLink.click();
	}
	public boolean newsCreatedAlert() {
		return newsCreatedSuccessAlert.isDisplayed();
	}
	
	public String newsDisplayedList() {
		return newsDisplayedList.getText();
	}
	
	public boolean isNewsResetListDisplayed() {
		return resetDisplayedTab.isDisplayed();
	}
	
}
