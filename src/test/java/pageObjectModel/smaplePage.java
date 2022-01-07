package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponent.BaseClass;

public class smaplePage extends BaseClass {

	@FindBy(id = "headingText")
	private WebElement value;
	
	public smaplePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getVal() {
		return getText(value);
	}
}
