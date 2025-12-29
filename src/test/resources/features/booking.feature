Feature: Booking Management

  @Regression
  Scenario: Successful login to the booking system
    Given I logged into restful-booker with "admin" and "password123"
    When the user authenticates with "admin" and "password123"
    Then the response status code should be 200