package seedu.duke;

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    /**
     * Prints the goodbye message when the user exits the program.
     */
    @Override
    public void execute() {
        Ui.printGoodbye();
    }
}
