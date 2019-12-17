package com.learncucumber.stepdefinitions.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

  public static WebDriver driver;

  @Before
  public void setup() {
    // Initiate the WebDriver
    System.out.println("setup");
    System.setProperty(
        "webdriver.chrome.driver",
        "/home/xu97pc/Downloads/chromedriver");
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}