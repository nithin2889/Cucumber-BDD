#@endToEnd
Feature: The login page should allow someone to login
  As a returning customer
  I want to login to the application
  So that I can view my account balance

  Background:
    Given the user is on the login page

  #@goodLogin
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

  Scenario Outline: the user should be able to login
    When the user enters "<username>" and "<password>"
    Then the user should be able to view their account balance
    Examples:
      | username | password |
      | nithin@gmail.com | password |
      | ariadi@testemail.com | apass |

  Scenario: after a failed attempt, the user should be able to login again
    When the user enters a set of username and password
    | username | password |
    | ariadi@testemail.com | apass |
    | nithin@gmail.com | password |
    Then the user should be able to view their account balance
