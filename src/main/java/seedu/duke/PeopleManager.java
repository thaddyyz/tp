package seedu.duke;

import java.util.LinkedList;

public class PeopleManager {

    static LinkedList<Person> listOfPeople = new LinkedList<Person>();

    public PeopleManager() {
    }

    /**
     * Loops through the list and count the number of people in the list.
     * @return the counter of the number of people in the list.
     */
    public int countPeopleInList() {
        int counter = 0;
        for (int i = 0; i < listOfPeople.size(); i++) {
            counter++;
        }
        return counter;
    }
}