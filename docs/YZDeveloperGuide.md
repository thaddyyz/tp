# Developer Guide

## Acknowledgements

## Design & implementation

### Edit Command
The purpose of the edit is allow the user to edit his order quantity.
The class diagram below is a brief overview of how the EditCommand class is related to other classes.
<br>![Class Diagram](https://raw.githubusercontent.com/thaddyyz/tp/master/UMLdiagrams/EditCommandDiagrams/editCommandClassDiagram.jpg)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** Details of each specific command class & Duke have been omitted from this diagram.

</div>

Below is a step by step example on how the parser is used when a user keys in an input.
Assuming the input is not going to be **null** or **blank**,

Step 1)<br>
Lets assume the input passed in is `delete 1/2`. The method `getCommand()` would then split the user's
input into an array of strings along the spaces and store them in the array `listOfInputs`. After which,
it will get the user's command from the 0th array element and store it in another variable called `commandInString`.
<br>

#### Alternate implementation

The EditCommand function can be integrated with the deleteCommand class.
```

```

The upside of doing would be that there is less code overall.
However, doing so would result in multiple functions being in the same class which would:
1. Make the code messier.
2. Make the code more vulnerable to functionality bugs.
3. Make the code more complex to debug.
4. Make testing process more complicated.

## Product scope
### Target user profile

### Value proposition

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
