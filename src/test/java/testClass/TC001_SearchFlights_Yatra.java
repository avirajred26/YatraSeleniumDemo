package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.SearchPage;
import report.ExcelLibraries;

public class TC001_SearchFlights_Yatra extends TestBase {
	
	
	HomePage objHomes;
	SearchPage objSearch;
	String testValue;
	int flightNumber;
	
	@Test
	public void searchFlightTest() throws Throwable {
		try {
		Assert.assertEquals(driver.getTitle(), "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		reporting("Application Launch Validation", "User shall be able to lauch the URl", "User Suucceslly Launch the URL", "Pass");
		
		objHomes = new HomePage(driver);
		testValue = 	objHomes.searchFlights(ExcelLibraries.getTestColValue("fromCity"), ExcelLibraries.getTestColValue("toCity"));
		}
		catch(AssertionError e) {
			reporting("Application Launch Validation", "User shall be able to lauch the URl", "User not able to luanch URL", "Fail");
			closeBrowser();
		}
		
		
		try {
			
			Assert.assertEquals(testValue, "Yatra.com | Bengaluru to Delhi flights");
			reporting("Search Flight Validation", "User shall be able to search flight betwwen "+ExcelLibraries.getTestColValue("fromCity")+" and "+ExcelLibraries.getTestColValue("toCity"), "user Suucceslly search the flightL", "Pass");
			objSearch = new SearchPage(driver);
			
			flightNumber = 	objSearch.searchFlightDetails();
			
			if(flightNumber!=0) {
				reporting("Flight List Validation", "User Shall be ablt to see flight list after Search ", "User able to see "+flightNumber +" flight list after search ", "Pass");;
			}else {
				reporting("Flight List Validation", "User Shall be ablt to see flight list after Search ", "User not able to see flight list " , "Fail");
				closeBrowser();
			}
			
			
		}catch(AssertionError e) {
			reporting("Search Flight Validation", "User shall be able to search flight betwwen "+ExcelLibraries.getTestColValue("fromCity")+" and "+ExcelLibraries.getTestColValue("toCity"), "user fail to search ", "Fail");
			
			closeBrowser();
		}
		
		
	}

}
