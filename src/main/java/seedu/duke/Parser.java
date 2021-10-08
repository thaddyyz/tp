package seedu.duke;

public class Parser {

    /**
     * Returns a Command object based on the user's input
     * string, else unknown command Type.
     *
     * @param input The user's input in String.
     * @return The respective Command type.
     */
    public static Command getCommand(String input) {
        if (input.isBlank() || input.isEmpty()) {
            return new UnknownCommand();
        }
        String[] listOfInputs = input.split(" ");
        String commandInString = listOfInputs[0].toLowerCase();

        switch (commandInString) {
        case ("add"):
            return new Command();
        case (DeleteCommand.COMMAND_WORD):
            return new Command();
        case ("orders"):
            return new Command();
            try {
                return new DeleteCommand(input);
            } catch (LotsException e) {
                System.out.println(e.getMessage());
            }
        case (OrdersCommand.COMMAND_WORD):
            return new OrdersCommand();
        case ("menu"):
            return new Command();
        default:
            return new UnknownCommand();
        }
    }
}
