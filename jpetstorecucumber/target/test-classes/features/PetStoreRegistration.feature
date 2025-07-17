Feature: PetStore User Registration

  Scenario: Register a new user with valid details
    Given the user is on the PetStore registration page
    When the user fills account info with username "deepan123", password "deepan@123", repeat password "deepan@123"
    And the user fills personal info with firstname "Deepan", lastname "MS", email "deepan@gmail.com", phone "9876543210", address1 "No 12 Gandhi Street", address2 "Anna Nagar", city "Chennai", state "TN", zip "600001", country "India"
    And the user fills profile info with language "english", category "DOGS", listOption "true", bannerOption "true"
    And the user submits the registration form
    Then the user should be redirected to the welcome page
