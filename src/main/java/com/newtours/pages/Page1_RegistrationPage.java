package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page1_RegistrationPage {


    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(name = "firstName")
    private WebElement firstnameTxt;

    @FindBy(name = "lastName")
    private WebElement lastnameTxt;

    @FindBy(name = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;


    public Page1_RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void goTo() {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstnameTxt));
    }


    public void enterUserDetails(String firstName, String lastName) {
        this.firstnameTxt.sendKeys(firstName);
        this.lastnameTxt.sendKeys(lastName);
    }


    public void enteruserCredentials(String username, String password) {
        this.userNameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);

    }


    public void submit() {
        this.submitBtn.click();
    }
}
