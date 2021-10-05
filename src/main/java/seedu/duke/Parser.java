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
            return null;
            //return new Command();//To return unknown command.
        }
        String[] listOfInputs = input.split(" ");
        String commandInString = listOfInputs[0].toLowerCase();

        switch (commandInString) {
        case("add"):
            return new Command();
        case("delete"):
            return new Command();
        case("orders"):
            return new Command();
        case("menu"):
            return new Command();
        default:
            return null;//To return unknown command.
        }
    }
}
