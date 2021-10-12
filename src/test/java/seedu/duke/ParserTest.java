package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.UnknownCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
}
