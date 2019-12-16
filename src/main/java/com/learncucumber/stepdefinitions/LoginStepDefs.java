package com.learncucumber.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.learncucumber.stepdefinitions.hooks.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
  // Use Cucumber to bind the feature file steps to the Java code.
  // Glue Code - Step Definitions or Step Implementations

  private WebDriver driver = Hooks.driver;

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
    String bodyText = driver.findElement(By.xpath("html/body")).getText();
    String message = "Logged in successfully";
    assertThat(bodyText).contains(message);
  }

  // When the user enters bad credentials
  @When(value = "^the user enters bad credentials$")
  public void userEntersBadCredentials() {
    System.out.println("2: the user user enters bad credentials");
    driver.findElement(By.id("MainContent_txtUserName")).sendKeys("nithin@gmail.com");
    driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password123");
    driver.findElement(By.id("MainContent_btnLogin")).click();
  }

  // Then the user should be not able to login
  @Then(value = "^the user should be not able to login$")
  public void userShouldNotBeAbleToLogin() {
    System.out.println("3: the user should be not able to login");
    String bodyText = driver.findElement(By.xpath("html/body")).getText();
    String message = "Logged in successfully";
    assertThat(bodyText).doesNotContain(message);
  }

  // And the user should get an invalid login message
  @And(value = "the user should get an invalid login message")
  public void userShouldGetAnInvalidLoginMessage() {
    System.out.println("4: the user should get an invalid login message");
    String bodyText = driver.findElement(By.xpath("html/body")).getText();
    String message = "Invalid password";
    assertThat(bodyText).contains(message);
  }

  // When the user enters username as "nithin@gmail.com"
  @When(value = "^the user enters username as \"(.*)\"$")
  public void enterUsername(String username) {
    driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
  }

  // And the user enters password as "password"
  @And(value = "^the user enters password as \"(.*)\"$")
  public void enterPassword(String password) {
    driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
  }

  // And user clicks on login
  @And(value = "user clicks on login")
  public void userClicksLogin() {
    driver.findElement(By.id("MainContent_btnLogin")).click();
  }

  // When the user enters "<username>" and "<password>"
  @When("^the user enters \"(.*)\" and \"(.*)\"$")
  public void userEntersUsernameAndPassword(String username, String password) {
    driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
    driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
    userClicksLogin();
  }

  // When the user enters a set of username and password
  @When("the user enters a set of username and password")
  public void userEntersSetOfUsernameAndPassword(DataTable credentials) {
    // Extract data into a map and iterate over it.
    String username;
    String password;

    for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
      // parse the map into a local variable
      username = data.get("username");
      password = data.get("password");

      // perform actions
      driver.findElement(By.id("MainContent_txtUserName")).clear();
      driver.findElement(By.id("MainContent_txtPassword")).clear();

      driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
      driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
      userClicksLogin();
    }
  }
}
