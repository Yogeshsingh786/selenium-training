Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario Outline: Login as a authenticated user
    Given user is  on homepage
    When user enters source as "<source>"
    And user enters destination as "<destination>"
    And user selects travel date as "<travelDate>"
    And user submits search details
    Then success message is displayed
  Examples:
  |source|destination|travelDate|
  |Thane West, Mumbai|Shirdi|13|
  