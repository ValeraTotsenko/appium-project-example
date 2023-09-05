@smoke
Feature: Wikipedia welcome screen

  As a regular user of the Wikipedia application, I want to be able to see the Welcome screen.

  @smoke
  @regression
  Scenario: Open application on the welcome screen
    Given user open application
    When welcome screen ready
    Then user can see Explore icon

  @newTests
  Scenario: Open History tab
    Given user open application
    When welcome screen ready
    Then user can see History icon
    When user click on History icon
    Then "History" is displayed on tab title

  @newTest
  Scenario: Open History tab in landscape orientation
    Given user open application
    When welcome screen ready
    When I rotate device to landscape orientation
    When user click on History icon
    Then "History" is displayed on tab title

  @newTest
  Scenario: Verification that user can see search icon after scrolling
    Given user open application
    When welcome screen ready
    When user scroll to "Sep 3, 2023" date
    Then search icon is displayed