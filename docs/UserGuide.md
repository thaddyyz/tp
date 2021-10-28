# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

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
  
![Delete Screenshot](https://raw.githubusercontent.com/markuslyq/tp/master/docs/UG%20Images/UG_DeleteCommand_Example.png)

### Edit current orders: `edit`

### Finding person: `find`

### List current orders: `list`


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
