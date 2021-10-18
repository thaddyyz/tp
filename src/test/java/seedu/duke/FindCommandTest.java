package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.FindCommand;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCommandTest {

    @Test
    public void inputRegex_emptyCommand_lotsExceptionThrown() {
        String input = "";
        assertThrows(LotsException.class, () -> new FindCommand(input));
    }

    @Test
    public void inputRegex_incompleteCommand_lotsExceptionThrown() {
        String input = "find";
        assertThrows(LotsException.class, () -> new FindCommand(input));
    }

    @Test
    public void inputRegex_emptySearch_lotsExceptionThrown() {
        String input = "find /n";
        assertThrows(LotsException.class, () -> new FindCommand(input));
    }

    @Test
    public void inputRegex_wrongSlashPosition_lotsExceptionThrown() {
        String input = "find n/";
        assertThrows(LotsException.class, () -> new FindCommand(input));
    }
}
