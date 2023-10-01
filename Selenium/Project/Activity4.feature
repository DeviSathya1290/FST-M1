@activity4
  Feature: Logging into the site
    Scenario: Open the site and login with the credentials provided
      Given Open the browser
      When Navigate to URL
      Then Verify that the homepage has opened
      And Close the browser