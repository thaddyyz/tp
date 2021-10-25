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

## Implementation
This section describes how the commands are implemented. Explanations and sequence diagrams are used to describe the implementation process.

###Implementation for Menu Command Class and Order Command Class

Command word to invoke the Menu and Order class: `menu` and `list`.

The purpose of Menu Command class is to instantiate the menu of which the user can order from. By invoking `menu`, the menu will be printed on the console for the user to see.

The purpose of Order Command class is to print the orders which the user has ordered onto the console. By invoking `list`, the order will be printed in a list format for the user to view. 

Hence, the sequence of which how Menu Command class and Order Command class are very similar. To prevent repeating of Sequence diagrams, a shared diagram will be listed below for the Menu Command Class and the Order Command class.

<br>![MenuAndOrdersSequenceDiagram3](https://raw.githubusercontent.com/WaiKit-nus/tp/AddCommandClassDG-WK/UMLdiagrams/MenuAndOrdersSequenceDiagram/MenuAndOrdersSequenceDiagram3.jpg)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** The diagram is shared between Menu Command Class and Orders Command Class.

</div>

The steps to using the `menu` and `list` command can be seen from the sequence diagram. In short: 
1) Invoke the Menu Command class by calling `menu`. The menu will display in the terminal.
2) After adding orders, invoke `list` command to see the orders added into the list.

**Note:** The command `menu` and `list` are just these two strings. Any edits to these two commands will result in an exception being thrown.


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
