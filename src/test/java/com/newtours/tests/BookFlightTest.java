package com.newtours.tests;

import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookFlightTest {
    WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "webDrivers/79/chromedriver");
        this.driver = new ChromeDriver();
    }


    @Test
    public void registrationPageTest() {
        Page1_RegistrationPage page1RegistrationPage = new Page1_RegistrationPage(driver);
        page1RegistrationPage.goTo();
        page1RegistrationPage.enterUserDetails("selenium", "docker");
        page1RegistrationPage.enteruserCredentials("selenium", "docker");
        page1RegistrationPage.submit();
    }


    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPage() {
        Page2_RegistrationConfirmationPage page2RegistrationConfirmationPage = new Page2_RegistrationConfirmationPage(driver);
        page2RegistrationConfirmationPage.gotoFlightDetailsPage();
    }


    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        Page3_FlightDetailsPage page3FlightDetailsPage = new Page3_FlightDetailsPage(driver);
        page3FlightDetailsPage.selectPassengers("2");
        page3FlightDetailsPage.goToFindFlightsPage();
    }


    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        Page4_FindFlightPage page4FindFlightPage = new Page4_FindFlightPage(driver);
        page4FindFlightPage.submitFindFlightPage();
        page4FindFlightPage.goToFlightConfirmationPage();
    }


    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmation() {
        Page5_FlightConfirmationPage page5FlightConfirmationPage = new Page5_FlightConfirmationPage(driver);
        page5FlightConfirmationPage.printConfirmation();
    }
}
