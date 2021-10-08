package seedu.duke;

public class OrdersCommand extends Command {

    public static final String COMMAND_WORD = "list";

    /**
     * Prints all the current orders
     */
    @Override
    public void execute() {
        Ui.printOrdersList();
    }
}
