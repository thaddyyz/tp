package seedu.duke;

import jdk.jshell.spi.ExecutionControlProvider;
import org.junit.jupiter.api.Test;

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
