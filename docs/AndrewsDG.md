# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}
## Architecture

## Design

### Logical Component
The logical component of the program consists multiple classes. Namely: `Parser`,`Command` &
the various child class of `Command`.
The class diagram below is a brief overview of how the `Parser` & the various `Command` class
are related to one another.
<br>![Class Diagram](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/ParserClassDiag-Page-1.jpg)
<div markdown="span" class="alert alert-primary">

:information_source: **Note:** Details of each specific command class & Duke have been omitted from this diagram.

</div>

Below is a brief explanation on how the logical component works.

1) When the user key's in an input, `Duke.class` passes the entire String into the `Parser` class to be processed.
2) The `Parser` class will then decide based on the input, which specific command type to be returned.
   (e.g. `AddCommand`,`EditCommand`, etc...)
3) The `PeopleManager` for each Command Class is then setup by calling the 
   `setData(People Manager)` function.
4) Next, the `execute()` function is called to perform whatever operation the
   command is supposed to do.
5) Depending on the which specific Command type it is, the `Command` might be able to 
   communicate with other components such as the `Menu` & `Ui` class to perform it's respective
   tasks. (e.g. Printing the Menu)
<br>

All the specific types of command class are a child class of `Command` to allow the program
to treat all commands the same when they return from the `Parser` class. Below is a quick overview
of how the `Parser` class works.

1) `Parser` checks to make sure input is neither blank nor empty.
2) The command word of the input (e.g.`"add"`, `"edit"`) is put through a switch statement.
3) The return item is then determined by which case of the switch statement the command word
falls into.
   
<br>
Below is a sequence diagram modeling how the `Parser` class works.

![Squence Diagram of Parser](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/Parser%20Sequence%20Diag.jpg)

### Delete Command

The purpose of the delete command is to delete a specific order from a particular person. The class diagram below shows the structure of the deleteCommand class and its relationship with other classes.  
<br>![Class Diagram](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/DeleteCommandDiagram/DeleteCommand%20Diagram.jpg?raw=true)
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

### Orders Command

The purpose of the OrdersCommand is to display the list of current orders stored. The class diagram below shows the structure of
the OrdersCommand class and how it is related to the other classes.

<br>![OrdersCommand Diagram](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/OrderCommandDiagram/OrderCommand%20Diagram.jpg)
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

### Add Command
The purpose of the AddCommand is to take in the user input and split the input to three different categories.
The three categories are the input name, order index and quantity. These data will then be added into a new Person object,
which will be added into the list of People.
The class diagram below is a brief overview of how the AddCommand is related to other classes.

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

### Logical Components

Below is a step by step example on how the Logical components interact when a user keys in an input.

Step 1)<br>
Lets assume the user input is `delete 1/2`. `Duke` will then call the method 
`Parser.getCommand("delete 1/2")`. The method would split the user's input into an array of
strings along the spaces and store them in the array `listOfInputs`. After which,
it will get the string `"delete"` from the 0th element of `listOfInputs` and store 
it in `commandInString`.
<br>

Step 2)<br>
The method will then parse `commandInString` through the switch cases and try to match it with
one of the known commands words stored in each respective command's class attribute called `COMMAND_WORD`.
In this case, the `"delete"` command will cause the parser to return a `DeleteCommand` object.
The image below shows the codes for the switch statement.

![Switch case Code](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/SwitchClassCode.jpg)

Step 3)<br>
Next, `Duke` will then use the returned command to call `Command.execute()` which will interact
with the `Manager Components` of the program who will then remove the 2nd order from the first
person in the list.

Below is a Sequence diagram for the entire process mentioned above.

![Squence Diagram of Logic](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/LogicSequenceDiag.jpg)


#### Alternate implementation
For the `Parser` class, we initially had thought of having each command's respective 
functions to be executed inside the switch statement.
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
However, doing so would cause our code to have a higher amount of coupling and would also 
cause the code to be messier and therefore harder to read. By having a command class
for each respective command, this allows us to segregate all the necessary functions
for each command in their own respective class, therefore making testing easier too.

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
