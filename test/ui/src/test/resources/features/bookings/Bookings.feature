@roomBooking
Feature: Bookings

  As an admin
  I want to manage room bookings
  So that I can keep all the room bookings updated

  Background:
    Given I am on the 'B&B Booking management' page as a logged in user
      | Username | Password |
      | admin    | password |

  Scenario Outline: Add room booking
    When I enter the booking details on the 'B&B Booking management' page to add a new booking
      | Room #   | Type   | Accessible   | Price   | WiFi   | TV   | Radio   | Refreshments   | Safe   | Views   |
      | <Room #> | <Type> | <Accessible> | <Price> | <WiFi> | <TV> | <Radio> | <Refreshments> | <Safe> | <Views> |
    And I click the 'Create' button on the 'B&B Booking management' page
    Then the new room booking is displayed on the 'B&B Booking management' page
      | <Room #> | <Type> | <Accessible> | <Price> | <WiFi> | <TV> | <Radio> | <Refreshments> | <Safe> | <Views> |

    Examples:
      | Room # | Type   | Accessible | Price | WiFi    | TV | Radio | Refreshments | Safe | Views |
      | 150    | Single | true       | 110   | √       | √  | √     | √            | √    | √     |
      | 151    | Suite  | false      | 115   | [blank] | √  | √     | √            | √    | √     |

  Scenario Outline: Delete room booking
    When I click the 'x' button for a room booking on the 'B&B Booking management' page
      | Room #   |
      | <Room #> |
    Then the room booking is not displayed on the 'B&B Booking management' page
      | <Room #> |

    Examples:
      | Room # |
      | 120    |
      | 125    |