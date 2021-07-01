package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
import utils.TestUtil;

public class HomePage extends PageBase {

	
	@FindBy(id = "BE_flight_origin_city")
	public WebElement clickOnFromCity;
	

	@FindBy(id = "BE_flight_arrival_city")
	public WebElement clickOnToCity;
	

	
	@FindBy(xpath = "//input[@id='BE_flight_origin_date']")
	public WebElement clickOnDate;
	@FindBy(xpath = "//td[contains(@title,'Sunday,')]")
	public WebElement clickOnDay;
	
	
	@FindBy(xpath = "//div[@class='ripple-parent search-height demo-icon icon-go']//input[@id='BE_flight_flsearch_btn']")
	public WebElement searchBtn;
	
	
	
	public HomePage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void selectFromCity(String City) throws InterruptedException {
		TestUtil.returnStringName(City);
		clickOnFromCity.click();	
		clickOnFromCity.clear();
		
		jsExecutortypetoElement(clickOnFromCity, TestUtil.returnStringName(City));
		System.out.println("//span[normalize-space()='("+TestUtil.returnStringName(City)+")']");
		Thread.sleep(2000);
		pbDriver.findElement(By.xpath("//span[normalize-space()='("+TestUtil.returnStringName(City)+")']")).click();
	}
	
	
	public void selectToCity(String city) throws InterruptedException {
		
		clickOnToCity.click();
		clickOnToCity.clear();
		
		jsExecutortypetoElement(clickOnToCity, TestUtil.returnStringName(city));
		System.out.println("//span[normalize-space()='("+TestUtil.returnStringName(city)+")']");
		
		Thread.sleep(2000);
		pbDriver.findElement(By.xpath("//span[normalize-space()='("+TestUtil.returnStringName(city)+")']")).click();
			
	}
	
	
	public void selectDate() {

		clickOnDate.click();
		jsExecutorClickOn(clickOnDay);
	}
	
	
	public String searchFlights(String strFromCity,String strToCity) throws InterruptedException {
		
		waitForPageLoad();
		selectFromCity(strFromCity);
		selectToCity(strToCity);
		selectDate();
		jsExecutorClickOn(searchBtn);
		waitForPageLoad();
		return pbDriver.getTitle();
	}
}
