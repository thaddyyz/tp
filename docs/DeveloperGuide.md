# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Parser
The purpose of the parser is to the command that the user has typed in and return its respective command
object. The class diagram below is a brief overview of how the Parser is related to other classes.  
<br>![Class Diagram](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/ParserClassDiag-Page-1.jpg)
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

Step 2)<br>
The method will then parse `commandInString` through the switch cases and try to match it with
one of the known commands. If it is able to match it with a command, the method will instantiate
it's respective command object and return it. Else it would return an `unnknownCommandClass` instead.
Below is a sequence diagram modeling how the function works.  
<br> ![Sqeuence Diagram of Parser](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/Parser%20Sequence%20Diag.jpg)

#### Alternate implementation

Initially we thought of having each command's respective functions to be executed inside the switch statement.
A rough example of the `delete` and `add` function can be seen below.
```
case "delete":
    functionToDeleteTask(input);
    break;
case "add":
    functionToAddTask(input);
    break;
```

The upside of doing would be that there is less code overall.
However, doing so would cause our code to have a higher amount of coupling and would also cause the code to be
messier and therefore harder to read. By having a command class for each respective command, this allows us
to segregate all the necessary functions for each command in their own respective class, therefore making
testing easier.  

### Delete Command

The purpose of the delete command is to delete a specific order from a particular person. The class diagram below shows the structure of the deleteCommand class and its relationship with other classes.  
<br>![Class Diagram](https://github.com/markuslyq/tp/blob/master/UMLdiagrams/DeleteCommandDiagram/DeleteCommand%20Diagram.jpg?raw=true)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** This is not a full representation of all the classes. Only methods and attributes associated with the deleteCommand class is being shown.

</div>

Below is an example of how the deleteCommand class behaves at each step.
Assume that there are 3 persons with 3 orders each.

Step 1:<br>
Assuming that the user execute `delete 1/2` command to delete the the order of index `‘2’` from the person of index `‘1’`, the parser would instantiate an object of deleteCommand class, which is a subclass of the Command class. In the constructor of the deleteCommand class, the input entered by the user would then be taken as a parameter.
<br>

Step 2:<br>
The input is then split and initialised to its respectively attributes using the `getPersonIndex()` and `getFoodIndex()` methods. In this case, `'1'` would be initialised as personIndex and `'2'` as foodIndex. The deleteCommand class is then returned to Duke, the main program, via the Parser class.
<br>

Step 3:<br>
Duke calls the `execute()` method of deleteCommand, which executes `deleteOrder()`. An instance of peopleManager, initialised in the Command class, is then parsed as a paramenter. 
<br>

Step 4:<br>
Within the `deleteOrder()` method, the person whose order is to be deleted is initialised and the deletion of the order is done via `deleteParticularOrder()` of the Person class as only the Person class has access to the Order class which holds the quantity of the order. The quantity of that particular order is then changed to 0 using `setQuantity()` in the Order class. This is to encapsulate the quantity attribute so as to prevent any unauthorised parties from accessing them directly. 
<br>

Step 5:<br>
`printDeleteMessage()` is called to notify the user of the deletion and if the person no longer has any orders tagged to him, that paricular person would be deleted from the list too.
<br>

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
