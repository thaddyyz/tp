# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Parser
The purpose of the parser is to handle the obtaining of the command that the user has typed in.
This class diagram is a brief overview of how the Parser is related to other classes.<br>
Image of class Diag here.

Below is a step by step example on how the parser is used when a user keys in an input.
Assuming the input is not going to be **null** or **blank**,

Step 1)<br>
Lets assume the input passed in is `delete 1/2`. The method `getCommand()` would then split the user's
input into an array of strings along the spaces and store them in the array `listOfInputs`. After which,
it will get the user's command from the 0th array element and store it in another variable called `commandInString`.
<br> insert Obj Diag here.<br>

Step 2)<br>
The method will then parse `commandInString` through the switch cases and try to match it with
one of the known commands. If it is able to match it with a command, the method will instantiate
it's respective command object and return it. Else it would return an `unnknownCommandClass` instead.
Below is a sequence diagram modeling how the function works.
<br> Insert sequence diagram here


## Product scope
### Target user profile

* User has good typing skills.
* Is comfortable without GUI.
* Tends to make large orders of food.
* Wishes to track multiple different orders of food.

### Value proposition

* Large orders can be confusing to keep track, especially if orders are to different stores.
* Allows users to keep track of bulk orders easily.
* Easily keep track of costs.
* Ensures that no orders are left out.
* Knows which order belongs to which store.
* Allow flexibility and control over what description you would like of your friends.  
* Users are able to delete/edit entries quickly.
* Comments on the food can also be described by you (e.g. No meat for BanMian).

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
