@activity3
Feature: Get the copyright text
  Scenario: Print the first copyright text in the footer to the console
    Given User open the browser the given URL
    When Get the first copyright text in the footer
    Then User close the browser opened