package seedu.duke;

import org.junit.jupiter.api.Test;

import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteCommandTest {

    protected PeopleManager emptyPeopleManager;
    protected PeopleManager peopleManagerWithThreeOrders;

    void setUp() throws LotsException {
        String input1 = "add /n markus /i 1 /q 1";
        Command command1 = new AddCommand(input1);
        command1.setData(peopleManagerWithThreeOrders);
        command1.execute();

        String input2 = "add /n adam /i 4 /q 1";
        Command command2 = new AddCommand(input2);
        command2.setData(peopleManagerWithThreeOrders);
        command2.execute();

        String input3 = "add /n andrew /i 8 /q 1";
        Command command3 = new AddCommand(input3);
        command3.setData(peopleManagerWithThreeOrders);
        command3.execute();

    }


    @Test
    void execute_emptyOrderList_expectException() throws LotsException {
        String input = "delete 2/a";
        Command command = new DeleteCommand(input);
        command.setData(emptyPeopleManager);
        assertThrows(NullPointerException.class,
            () -> command.execute());
    }

}
