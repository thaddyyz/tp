package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    @Test
    public void getCommand_emptyCommand_nullReturned() {
        Command output = Parser.getCommand("");
        assertEquals(output == UnknownCommand.class);
    }

    @Test
    public void getCommand_spaces_nullReturned() {
        Command output = Parser.getCommand("     ");
        assertNull(output); //To be changed to expect unknown command
    }

}
