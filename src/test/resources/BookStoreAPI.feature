Feature: Book Store Web API
 
  Scenario: Authorization with valid credentials
    Given an existing user
    When the client calls /Account/v1/Authorized with username 'kikelink' and password 'Admin123!'
    Then the client receives status code of 200
    And the client receives response 'true'

  Scenario: Token Generation with valid credentials
    Given an existing user
    When the client calls /Account/v1/GenerateToken with username 'kikelink' and password 'Admin123!'
    Then the client receives status code of 200
    And a 'token' property is provided   

  Scenario: Token Generation with invalid credentials
   	Given an existing user
    When the client calls /Account/v1/GenerateToken with username 'kikelink' and password 'wrong'
    Then the client receives status code of 200
    And a 'token' property is 'null'
    
  Scenario: Find book by valid ISBN
    Given an existing book
    When the client calls /BookStore/v1/Book with ISBN '9781449325862'
    Then the client receives status code of 200
    And the book property 'title' is 'Git Pocket Guide'        
