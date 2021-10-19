# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

###Add Command
The purpose of the AddCommand is to take in the user input and split the input to three different categories. 
The three categories are the input name, order index and quantity. These data will then be added into a new Person object, 
which will be added into the list of People.
The class diagram below is a brief overview of how the Parser is related to other classes.
<br>![AddCommandDiagram](https://raw.githubusercontent.com/WaiKit-nus/tp/AddCommandClassDG-WK/UMLdiagrams/AddCommandDiagram/AddCommandDiagram.jpg)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** Details of each specific command class & Duke have been omitted from this diagram.

</div>

Listed below is an example on the usage of Add Command.
1) Example Command: `add /n Jacob /i 3 /q 2`. This command translates into adding a person named Jacob, ordering the 3rd food on the menu with 2 quantity.
2) The Add command will take in this input from the Parser class, which will then split this input string into `personName`, `foodIndex` and `foodQuantity` respectively.
A new `Person` object will be instantiated and the data `personName`, `foodIndex` and `foodQuantity` is passed into this object. 
3) This `Person` object will be added into the `listOfPeople` in the `PeopleManager` class.  

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
