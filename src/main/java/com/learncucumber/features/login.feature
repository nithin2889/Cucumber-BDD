@endToEnd
Feature: The login page should allow someone to login
  As a returning customer
  I want to login to the application
  So that I can view my account balance

  Background:
    Given the user is on the login page

  @goodLogin
  Scenario: The user should be able to login with valid credentials
    When the user enters valid credentials
    Then the user should be able to view their account balance

  Scenario: The user should not be able to login with bad credentials
    When the user enters bad credentials
    Then the user should be not able to login
    And the user should get an invalid login message

  Scenario: The user should be able to login
    When the user enters username as "nithin@gmail.com"
    And the user enters password as "password"
    And user clicks on login
    Then the user should be able to view their account balance