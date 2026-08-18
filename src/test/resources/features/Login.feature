Feature: Facebook login
  Scenario: Login with valid credentials
    Given I am on the facebook login page
    When I enter my email and password
    And I click the login button
    Then I should see the Facebook home page
