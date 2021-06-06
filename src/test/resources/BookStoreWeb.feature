Feature: Book Store Web Log In
 
  Scenario: Login with valid credentials
  	Given a registered user
    When the client calls /login page with username 'kikelink' and password 'Admin123!'
    Then the client is redirected to the 'Profile' page