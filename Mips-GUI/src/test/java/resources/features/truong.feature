#Author: truong.phan@modec.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: test abc feature
  I want to use this template for my feature file

  @tag1
  Scenario: enter a form
    Given I go to demo
    When I want to register a new account
    Then I am at register form

  @tag2
  Scenario: enter a form
    Given I enter to register form
    Then I am at register form
  #@tag2
  #Scenario Outline: Title of your scenario outline ##block code by control+/
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | Success |
      #| name2 |     7 | Fail    |
