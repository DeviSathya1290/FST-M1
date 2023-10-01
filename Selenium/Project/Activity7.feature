@activity7
  Feature: Reading additional information
    Scenario: Reading a popup that contains additional information about the account/lead
      Given Open the browser to the Alchemy CRM site and login
      When Navigate to Sales -> Leads find the Additional information icon and click it
      Then Read the popup and print the phone number displayed in it.
      And Close a browser opened