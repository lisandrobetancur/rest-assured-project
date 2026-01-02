Feature: Booking Management

  Scenario: Update booking
    Given I logged into restful-booker with "admin" and "password123"
    When get the booking with ID 2
    Then updated the new firstname and lastname as "Juanito" and "Perez"