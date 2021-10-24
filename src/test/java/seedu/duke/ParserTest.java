package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.UnknownCommand;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void getCommand_emptyCommand_nullReturned() throws Exception {
        Command output = Parser.getCommand("");
        assertTrue(output instanceof UnknownCommand);
    }

    @Test
    public void getCommand_spaces_nullReturned() throws Exception {
        Command output = Parser.getCommand("     ");
        assertTrue(output instanceof UnknownCommand);
    }

    @Test
    public void addCommand_AddMoreThan99_ErrorThrown() throws Exception {
        String com;
        PeopleManager manager = new PeopleManager();
        PeopleManager.clearListOfPeople();
        for (int i = 1; i <= 99; i++) {
            com = "add /n " + i + " /i 1 /q 2";
            Command output = Parser.getCommand(com);
            output.setData(manager);
            output.execute();
        }
        com = "add /n 100 /i 1 /q 2";
        Command output = Parser.getCommand(com);
        output.setData(manager);
        assertThrows(LotsException.class,() -> output.execute());
    }
}
