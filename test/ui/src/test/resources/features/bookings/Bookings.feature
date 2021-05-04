@addBooking
Feature: Bookings

  As an admin
  I want to manage room bookings
  So that I can keep all the room bookings updated

  Scenario: Add room booking
    Given I am on the 'B&B Booking management' page as a logged in user
      | Username | Password |
      | admin    | password |
    When I enter the booking details on the 'B&B Booking management' page to add a new booking
      | Room # | Type   | Accessible | Price | WiFi | TV | Radio | Refreshments | Safe | Views |
      | 105    | Single | true       | 100   | √    | √  | √     | √            | √    | √     |
    And I click the 'Create' button on the 'B&B Booking management' page
    Then the new room booking is displayed on the 'B&B Booking management' page
      | Room # | Type   | Accessible | Price | WiFi | TV | Radio | Refreshments | Safe | Views |
      | 100    | Single | true       | 100   | √    | √  | √     | √            | √    | √     |