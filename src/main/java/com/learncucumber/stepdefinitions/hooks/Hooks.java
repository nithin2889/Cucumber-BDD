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
    System.setProperty(
        "webdriver.chrome.driver",
        "C:\\Users\\Nithin\\Downloads\\DevArea\\Dev "
            + "Softwares\\Selenium\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}