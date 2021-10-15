package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PeopleManagerTest {
    static PeopleManager peopleManager;

    @BeforeAll
    public static void setUp() {
        peopleManager = new PeopleManager();
        String[] names = {"Markus", "Adam", "Andrew"};
        for (int i = 0; i < 3; i++) {
            Person person = new Person(names[i]);
            peopleManager.addPerson(person);
        }
    }

    @Test
    public void isEmpty_listOfPeopleNotEmpty_falseReturned() {
        assertEquals(false, peopleManager.isEmpty());
    }

}
