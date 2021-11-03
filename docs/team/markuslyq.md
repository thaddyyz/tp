## Markus Lim Yi Qin's Project Portfolio Page
### Project Overview: LOTS (Large Order Tracking System)
Large Order Tracking System (LOTS) is a Command Line (CLI) program that enables users to keep track of multiple food orders from a pre-set list of food items from different stores. The program helps users to collate the orders and displays a summary of all the orders along with other information such as an individual person’s order and the corresponding cost, total cost of all the orders and more.
### Summary of Contributions
#### Code Contributed: [RepoSense Link](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-25&tabOpen=true&tabType=authorship&tabAuthor=markuslyq&tabRepo=AY2122S1-CS2113-T13-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)
#### Enhancements Implemented:
* **Delete Feature:**
  * **Function:** Added the feature to delete a specific order from a particular person.
  * **Justification:** It is a necessary feature as it allows the user to remove their orders if there was an accidental addition or mistake made to an order, which is a common occurrence.  
* **Storage Feature:**
  * **Function:** Saves the user's orders whenever the orders list changes.
  * **Justification:** This feature value adds to the product because it fulfils the purpose of tracking multiple food orders by allowing the user to preserve his orders even after the program exits for editing or referencing in the future. Also, it ensures that the user's inputs would not be completely wiped in the unfortunate event that the computer shuts down unexpectly and would have to start afresh. 
  * **Highlight:** Introducing this enhancement opens up the opportunity for many more bugs as the user would have direct access to the orders file. Hence, the implementation was rather challenging as it requires careful handling of unexpected file alterations to prevent any bugs from being introduced to the program. 

* **Other Enhancements:**
  * Wrote the JUnit test for `deleteCommand`. (Pull Request [#53](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/53))
  * Fixed several bugs. (Issues [#51](https://github.com/AY2122S1-CS2113-T13-2/tp/issues/51), [#119](https://github.com/AY2122S1-CS2113-T13-2/tp/issues/119), [#124](https://github.com/AY2122S1-CS2113-T13-2/tp/issues/124))

#### Documentation:
* **User Guide**
  * Added usage guide for `delete` feature. (Pull Request [#151](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/151))

* **Developer Guide**
  * Design section of `logical compoenent`, excluding parser class diagram.
  * Class diagram for the `'Add, Delete, Edit, Orders and Find Command Classes'` section.
  * Sequence Diagram for `Storage` implementation section.

#### Team-based Tasks:
* **Project Management**
  * Co-owner of the team repository.
  * Updated the .jar file for release `v2.0`.
  * PRs reviewed: [#18](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/18), [#38](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/38), [#57](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/57), [#68](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/68), [#100](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/100), [#105](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/105), [#111](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/111), [#133](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/133), [#136](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/136), [#137](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/137), [#143](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/143), [#144](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/144), [#147](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/147), [#162](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/162), [#216](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/216), [#217](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/217), [#221](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/221), [#222](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/222), [#238](https://github.com/AY2122S1-CS2113-T13-2/tp/pull/238)
  * Maintained issue tracker.
* **Necessary Code Enhancement** 
  * Contributed to the structure of the program by setting up the `PeopleManager`,`Command`, `LotsException` and `Order` class.

#### Beyond Project Team:
  * DG bugs and suggestions for other teams. (Examples: )
  * Function bugs and suggestions for other teams. (Examples can be seen [here](https://github.com/markuslyq/ped/issues))
