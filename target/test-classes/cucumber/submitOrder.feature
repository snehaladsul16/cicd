
@tag
Feature: purchase the order from Ecommerce website       
  I want to use this template for my feature file

Background: 
Given: I landed on Ecommerce website

  @Regg
  Scenario Outline: positive test of submitting order
    Given login  with username <name> and password<password>
    When I add product <productName> in Cart
    And checkout  <productName> and submit the order
    Then  "THANK YOU FOR THE ORDER." msg is displayed ON confirmationPage

    Examples: 
      | name                                 | password            | productName|
      | snehaladsul@gmail.com                | Snehaladsul11@@     | ZARA COAT 3|
     