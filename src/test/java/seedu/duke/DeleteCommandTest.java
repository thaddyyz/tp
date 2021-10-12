package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteCommandTest {

    protected PeopleManager emptyPeopleManager;

    @Test
    void execute_emptyOrderList_expectException() throws LotsException {
        String input = "delete 2/a";
        Command command = new DeleteCommand(input);
        command.setData(emptyPeopleManager);
        assertThrows(NullPointerException.class,
            () -> command.execute());
    }
}
