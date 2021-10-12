package seedu.duke;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static Logger log = Logger.getLogger("LOTS");

    public static void main(String[] args) {
        Ui.printWelcome();
        runDuke();
        Ui.printGoodbye();
    }

    /**
     * The main function that duke runs on.
     */
    private static void runDuke() {
        Command currentCommand;
        PeopleManager manager = new PeopleManager();
        boolean isEnd = false;
        while (!isEnd) {
            try {
                String userInput = Ui.readInput();
                currentCommand = Parser.getCommand(userInput);
                assert currentCommand != null : "Command returned cannot be null!";
                currentCommand.setData(manager);
                currentCommand.execute();
                if (currentCommand instanceof ByeCommand) {
                    isEnd = true;
                }
            } catch (LotsException e) {
                Ui.printWithBorder(e.getMessage());
            } catch (Exception x) {
                Ui.printWithBorder("Oops! Unknown error. Please try again.");
                log.log(Level.SEVERE,x.getMessage());
                log.log(Level.SEVERE,x.getStackTrace().toString());
            }
        }
    }
}