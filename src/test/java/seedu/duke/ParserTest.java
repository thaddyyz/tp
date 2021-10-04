package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    @Test
    public void getCommand_emptyCommand_nullReturned() {
        String output = Parser.getCommand("");
        assertNull(output);
    }

    @Test
    public void getCommand_spaces_nullReturned() {
        String output = Parser.getCommand("     ");
        assertNull(output);
    }

}
