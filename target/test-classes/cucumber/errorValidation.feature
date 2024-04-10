
@tag
Feature: error Validation
  I want to use this template for my feature file

 

  @ErrorValidations
  Scenario Outline: Title of your scenario outline
   Given: I landed on Ecommerce website
  When login  with username <name> and password<password>
  Then "Incorrect email or password."msg is displayed

      Examples: 
      | name                                 | password               | 
      | snehaladsul@gmail.com                | Snehaladsul11@@@@      | 
