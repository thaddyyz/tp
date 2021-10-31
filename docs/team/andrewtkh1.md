# Andrew's - Project Portfolio Page

## Overview

### Project - Large Order Tracking System(LOTS)
LOTS is a CLI application that allows users to track large number of orders that consists of different food orders & orders belonging to different people.
It is written in Java and meant to run on `Java 11`

### Summary of Contributions

- **Code contributed**: [RepoSense Link](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/#breakdown=true&search=andrewtkh1)
- **New Features**: Added the feature `Find`.
    - `What it does`- Allows user to search the current list of orders for a specific name.
    - `Justification` - As the name suggest, this is meant to track large number of orders.
      As such, the find feature allows the user to easily find a person in the list.
    - `Highlights` - Decision was made to match the user's search input as a substring of
      name too. This would greatly improve the user's experience, as in the event that
      one of the entries name was too long, the user could just search for a substring of the
      name and it would still return as true.
- **New Features**: Implemented the `Parser` class.
    - `What it does` - Processes the user's input to determine what type of command was entered.
    - `Justification` - Allowed for a more `OOP` way of handling the other different commands.
    This led to a neater & more readable code.
- **Project Management**:
    - Managed Issue tracker
    - Managed Milestones  
    - Setup Team Org & Team Repo
    - Managed Releases
- **Enhancements to existing features**:
    - Designed `REGEX` needed for `Add`,`Find` & `Delete` Command.
        - Allowed for easy catching of incorrect input.
    - Designed `IO-Redirection` test based on `Equivalence partitioning`.
    - Fixed User Guide's `Anchor Links`.
- **Community**:
    - PR reviewed with non-trivial comments (#101)
- **Documentation**:
    - User Guide
        - Added documentation for find Feature.
    - Developer Guide
        - Added part of the explanation for the `Logical Component` under `Design`.
        - Contributed the brief overview of class [diagram](https://raw.githubusercontent.com/AY2122S1-CS2113-T13-2/tp/master/UMLdiagrams/ParserDiagrams/ParserClassDiag-Page-1.jpg) for `Parser`.
        - Added the implementation of `Parser` along with the diagrams & it's alternate implementation.
        - Imported the `Product Scope` which consisted of `Target User profile` & `Value Proposition`.
        - Imported the `User stories` & the `Non-functional Requirements`.
        - Added the `Instructions for manual testing`.
            - Designed test cases based on `Equivalence Partitioning`.
    - Added the `Setting Up and Getting Started` page for developers.