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
