package com.learncucumber.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefs {
  // Use Cucumber to bind the feature file steps to the Java code.
  // Glue Code - Step Definitions or Step Implementations

  private WebDriver driver;

  @Before
  public void setup() {
    // Initiate the WebDriver
    System.setProperty(
        "webdriver.chrome.driver",
        "C:\\Users\\Nithin\\Downloads\\DevArea\\Dev "
            + "Softwares\\Selenium\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  // Given the user is on the login page
  @Given(value = "^the user is on the login page$")
  public void userOnLoginPage() {
    System.out.println("1: the user is on the login page");
    // Navigate to the login page
    driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
  }

  // When the user enters valid credentials
  @When(value = "^the user enters valid credentials$")
  public void userEntersValidCredentials() {
    System.out.println("2: the user enters valid credentials");
    driver.findElement(By.id("MainContent_txtUserName")).sendKeys("nithin@gmail.com");
    driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password");
    driver.findElement(By.id("MainContent_btnLogin")).click();
  }

  // Then the user should be able to view their account balance
  @Then(value = "^the user should be able to view their account balance$")
  public void userShouldBeAbleToViewAccountBalance() {
    System.out.println("3: the user should be able to view their account balance");
    assertThat(driver.findElement(By.id("conf_message")).getText())
        .isEqualTo("Logged in successfully");
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
