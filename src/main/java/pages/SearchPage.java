package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class SearchPage extends PageBase{
	
	@FindBy(xpath = "//div[@class='flightItem border-shadow pr']")
	public List<WebElement> flightResult;

	public SearchPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public Integer searchFlightDetails() {
		return flightResult.size();
	}
}
