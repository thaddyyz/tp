package seedu.duke;

public class Parser {

    /**
     * Returns the command from the user's input
     * string in all small cases, Null if input is empty/blank.
     *
     * @param input The user's input in String.
     * @return The command in String. Null otherwise.
     */
    public static String getCommand(String input) {
        if (input.isBlank() || input.isEmpty()) {
            return null;
        }
        String[] listOfInputs = input.split(" ");
        return listOfInputs[0].toLowerCase();
    }
}
