@activity6
  Feature: Menu checking
    Scenario: Make sure that the “Activities” menu item exists and is clickable
      Given Open the browser with given URL
      When Navigate to URL given and login using the credentials
      Then Locate the navigation menu and ensure that the “Activities” menu item exists
      And Close the opened browser