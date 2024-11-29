#Author: your.email@your.domain.com
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
Feature: Managing My Game Library
  In order to make my library meaningful
  As a gamer registering with MyGameLibrary
  I want to be able to add, modify, and remove games in my library
  
  
  @tag1
  Scenario: Initializing My Game library
   When Matthew lands on "gamesPage" 
   Then I should have 3 starter games.
  
  @tag2
  Scenario: Create a new game
    When Matthew wants to add "Halo 2"
    Then I should get "Halo 2" added to Games

	@tag3
	Scenario: Edit an existing game
		Given Matthew has "Halo 2"
		When Matthew wants upgrade the edition name to "Halo 2: Master Chief Edition"
		Then "Halo 2" should change to "Halo 2: Master Chief Edition" 

  @tag4
  Scenario: Deleting a Game 
   	Given Matthew has "Halo 3" registered in Games
   	When Matthew deletes "Halo 3"
   	Then Games should not contain "Halo 3"
