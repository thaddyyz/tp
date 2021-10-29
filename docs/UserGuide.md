# User Guide
## Contents
- [Introduction](#introduction)
- [Quick Start](#quick-start)
- [Features](#features)
  - [Display food menu](#display-food-menu-menu)
  - [Adding orders](#adding-orders-add)
  - [Deleting orders](#deleting-orders-delete)
  - [Edit current orders](#edit-current-orders-edit)
  - [Finding person](#finding-person-find)
  - [List current orders](#list-current-orders-list)
  - [Exiting LOTS](#exiting-lots-bye)
- [Command Summary](#command-summary)
## Introduction

Large Order Tracking System (LOTS) is a Command Line (CLI) program that enables users to keep track of multiple food 
orders from a pre-set list of food items from different stores. The program helps users to collate the orders and 
displays a summary of all the orders along with other information such as each person’s order and special requirements 
(if any), cost of an individual’s order,  total cost of all the orders and more. As LOTS is a CLI program, this would 
greatly benefit any user that excels in typing.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `LOTS` from [here](https://github.com/AY2122S1-CS2113-T13-2/tp/releases).
3. Navigate to the folder where `LOTS` is located using terminal.
4. Start the `LOTS` program by executing `java -jar CS2113TP.jar` in the terminal.
5. You can start using the `LOTS` program by inputting commands into the command line. The list of commands and 
instructions on how to use them can be found in the following section.

## Features

### Display food menu: `menu`

### Adding orders: `add`

Adds a specific order for a particular person.

**Format:** `add /n [PERSON_NAME] /i [FOOD_INDEX] /q [QUANTITY]`
* `[PERSON_NAME]` refers to the person's name who ordered this set of food.
  * The length of `[PERSON_NAME]` must be between **1 character to 51 characters** including spaces.
  * `[PERSON_NAME]` can only be in **alphanumeric**.
* `[FOOD_INDEX]` refers to the index of the food in the menu.
  * To find out which `[FOOD_INDEX]` correspond to which food, hit the `menu` command.
  * Only accept **integers** 1,2,3...
* `[QUANTITY]` refers to the quantity of this particular order.
  * `[QUANTITY]` only accepts **integers**.
  * Range of `[QUANTITY]` is from **1 to 999**.

**Note:**
1) `[PERSON_NAME]` is **individualised**. 
   1) You can only use **1 name** as a reference to **1 person**.
   2) Any additional `add` command with the same name will be tagged under the same person's order.
2) Adding the same order to a person with different quantity will result to **increment of the original quantity** of the order.
   1) E.g. Refer to **Example of usage** points 3, 6 and 7.

**Example of usage:**
1) Start with empty list.
2) Adds a new order under person named Jeremy, ordering 1 Ban Mian.
3) Adds a new order under person David, ordering 682 Chicken Rice.
4) Adds a new order under Jeremy, who previously ordered, with a new order of 70 Nasi Lemak.
5) List the orders.

![Add1 Screenshot](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/UG_AddCommand_Example1.png)

6) Adds an order under person David, ordering 60 Chicken Rice.
7) List the orders.

![Add2 Screenshot](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/UG_AddCommand_Example2.png)

### Deleting orders: `delete`   

Deletes a specific order from a particular person. 

**Format:** `delete [PERSON_INDEX]/[FOOD_INDEX]`  
* Deletes the specific order of `FOOD_INDEX`  from the person of `PERSON_INDEX`.
* The `PERSON_INDEX` refers to the index number of a particular person shown in the displayed order list.
* The `FOOD_INDEX` refers to the index number of a specific order shown in the displayed order list.
* `PERSON_INDEX` & `FOOD_INDEX` **must be a positive integer** 1, 2, 3, …  

**Example of usage:** 
* `list` followed by `delete 1/2` deletes the order of index '`2`' from the person of index '`1`'.    
  
![Delete Screenshot](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/UG_DeleteCommand_Example.png)

### Edit current orders: `edit`

### Finding person: `find`

Find persons with names that contain a given string and print out their orders.

**Format:** `find /n [SEARCH_STRING]`

- `SEARCH_STRING` specifies the sub-string that you wish to search.
- The search is **case-insensitive**. Meaning that `ABcd = abcd = ABCD`.
- The `SEARCH_STRING` does not need to contain the exact name you wish to match.
**Any** sub-string of the name will be considered a match.
    - E.g) `find /n drew` will return the name `andrew` as a match.
    
**Example of usage**
- Assume our current list contains 3 people named `tom`, `kim` & `kimmy` as seen below.
- The command `find /n kim` will return both `kim` & `kimmy` as both names contain the string `"kim"`.

![Find Image](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/FindList.jpg)



### List current orders: `list`

Shows a list of all the orders that have been made.

**Format:** `list`

- Input **must not** contain any extra characters after `list`.

**Example of usage**
- Assume that the current stored order contains orders made by `Jerry`, `Lewis` & `Smith`.
- The `list` command will display everyone's orders, and a summary of the total number of people who have ordered and
the total quantity of food ordered.

![List Image](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/ListExample.JPG)

### Exiting LOTS: `bye`

Exits the LOTS program.

**Format:** `bye`

**Example of usage**

![Bye Image](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/docs/UG%20Images/ByeExample.JPG)

## Command Summary
|Actions|Format & Example|
|:---:|:---|
|Add|Format: `add /n [PERSON_NAME] /i [FOOD_INDEX] /q [QUANTITY]` <br>Example: `add /n Andrew /i 32 /q 2` (Adds 2 orders of item number 32 for Andrew)|
|Delete|Format: `delete [PERSON_INDEX]/[FOOD_INDEX]`<br>Example: `delete 2/1` (Deletes the order of index ‘1’ from the person of index ‘2’.)
|Edit|Format: `edit [PERSON_INDEX]/[FOOD_INDEX] /q [QUANTITY]` <br>Example: `edit 3/1 /q 8` (Changes the quantity of the order with index '1' from the person of index '3' to 8.) 
|Find|Format: `find /n [SEARCH_STRING]` <br>Example:`find /n drew` (Searches for names containing 'drew'.)
|Menu|Example: `menu`|
|List|Example: `list`|
|Bye|Example: `bye`|

