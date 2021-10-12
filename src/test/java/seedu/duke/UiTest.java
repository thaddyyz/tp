package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.exceptions.LotsException;

public class UiTest {

    @Test
    void execute_inputContainsExtraInputs_throwsLotsException() throws LotsException {
        try {
            Command command;
            command = Parser.getCommand("list a");
            command.execute();
        } catch (LotsException e) {
            System.out.println("Please make sure there is no inputs after the list command!");
        }
    }

}
