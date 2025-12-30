Feature: Booking Management

  Scenario: Update booking
    Given I logged into restful-booker with "admin" and "password123"
    When get the booking with ID 2
    And update the new firstname and lastname as "Juanito" "Perez"
    #Then the booking with ID 1 should be firstname "Juanito" and lastname "Perez"
