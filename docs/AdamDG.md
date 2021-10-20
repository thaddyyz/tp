# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Orders Command

The purpose of the OrdersCommand is to display the list of current orders stored. The class diagram below shows the structure of
the OrdersCommand class and how it is related to the other classes.

<br>![OrdersCommand Diagram](https://github.com/mohamad-adam8991/tp/blob/AdamDG_MA/UMLdiagrams/OrderCommandDiagram/OrderCommand%20Diagram.jpg)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** This diagram only shows methods and attributes related to the OrdersCommand class.

</div>

Below is an example of how the OrdersCommand is used, assuming that there are orders currently stored.
1) Taking in the input `list`, the parser will instantiate an OrdersCommand object, which in turn is returned to the 
main duke program.
2) When the main duke program calls the `execute()` method of OrdersCommand, the `printOrdersList()` method of the UI 
class is executed.
3) Within the `printOrdersList()` method, the method loops through each person stored in the PeopleManager to print the 
names of all persons currently stored. On top of that, `printIndividualPersonOrder()` is called to print the `foodIndex` and
`quantity` data stored for each person.


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
