package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteCommandTest {

    protected PeopleManager peopleManager = new PeopleManager();

    @BeforeEach
    void setUp() throws LotsException {
        String[] names = {"Markus", "Adam", "Andrew"};
        String[] foodIndex = {"1", "4", "8"};
        PeopleManager.clearListOfPeople();

        for (int i = 0; i < 3; i++) {
            String input = "add /n " + names[i] + " /i " + foodIndex[i] + " /q 1";
            Command command = new AddCommand(input);
            command.setData(peopleManager);
            command.execute();
        }
    }

    @Test
    void execute_validInput_expectException() throws LotsException {
        String input = "delete 2/1";
        Command command = new DeleteCommand(input);
        command.setData(peopleManager);
        command.execute();
        assertEquals(2, peopleManager.getSize());
    }

    @Test
    void execute_personIndexOutOfBounds_expectException() throws LotsException {
        String input = "delete 99/1";
        assertThrows(LotsException.class,
            () -> new DeleteCommand(input));
    }

    @Test
    void execute_orderIndexOutOfBounds_expectException() throws LotsException {
        String input = "delete 2/2";
        Command command = new DeleteCommand(input);
        command.setData(peopleManager);
        assertThrows(LotsException.class,
            () -> command.execute());
    }

    @Test
    void execute_inputWithoutFoodIndex_expectException() {
        String input = "delete 2";
        assertThrows(LotsException.class,
            () -> new DeleteCommand(input));
    }

    @Test
    void execute_invalidPersonIndex_expectException() {
        String input = "delete markus/1";
        assertThrows(LotsException.class,
            () -> new DeleteCommand(input));
    }

    @Test
    void execute_invalidOrderIndex_expectException() {
        String input = "delete 1/a";
        assertThrows(LotsException.class,
            () -> new DeleteCommand(input));
    }

    @Test
    void execute_invalidInput_expectException() {
        String input = "delete Markus/a";
        assertThrows(LotsException.class,
            () -> new DeleteCommand(input));
    }

}
