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
    public void testcountPeopleInList() {
        assertEquals(3, peopleManager.countPeopleInList());
    }

    @Test
    public void testgetSize() {
        assertEquals(3, peopleManager.getSize());
    }

    @Test
    public void isEmpty_Test() {
        assertEquals(false, peopleManager.isEmpty());
    }

    @Test
    public void deletePerson_InvalidPersonIndex_expectException() {
        assertThrows(LotsException.class, () -> {
            peopleManager.deletePerson(8);
        });
    }

}
