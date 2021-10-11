package seedu.duke;

import java.io.FileNotFoundException;

public class Parser {

    /**
     * Returns a Command object based on the user's input
     * string, else unknown command Type.
     *
     * @param input The user's input in String.
     * @return The respective Command type.
     */
    public static Command getCommand(String input) throws Exception {
        assert input != null : "Input to getCommand Cannot be NULL!";

        if (input.isBlank() || input.isEmpty()) {
            return new UnknownCommand();
        }
        String[] listOfInputs = input.split(" ");
        String commandInString = listOfInputs[0].toLowerCase();

        switch (commandInString) {
        case (AddCommand.COMMAND_WORD):
            return new AddCommand(input);
        case (DeleteCommand.COMMAND_WORD):
            try {
                return new DeleteCommand(input);
            } catch (LotsException e) {
                System.out.println(e.getMessage());
                return new UnknownCommand();
            }
        case (OrdersCommand.COMMAND_WORD):
            return new OrdersCommand();
        case (MenuCommand.COMMAND_WORD):
            return new MenuCommand();
        default:
            return new UnknownCommand();
        }
    }
}
