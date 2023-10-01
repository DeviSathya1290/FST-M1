@activity5
  Feature:Getting colors
    Scenario: Get the color of the navigation menu
      Given Open a browser
      When Navigate to URL and login using the credentials
      Then Get the color of the navigation menu and print it to the console
      And close a Browser