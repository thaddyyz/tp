package seedu.duke.command;

import seedu.duke.Menu;
import seedu.duke.Ui;
import seedu.duke.exceptions.LotsException;

import java.util.ArrayList;

public class MenuCommand extends Command {

    public static final String COMMAND_WORD = "menu";

    private ArrayList<Double> priceList;
    private ArrayList<String> foodList;

    /**
     * MenuCommand calls access to file to retrieve stored menu.
     */
    public MenuCommand(String input) throws LotsException {
        String[] splitInput = input.split(" ");
        if (splitInput.length > 1) {
            throw new LotsException("Please make sure there is no inputs after the menu command!");
        } else {
            priceList = Menu.PRICELIST;
            foodList = Menu.FOODLIST;
        }
    }


    /**
     * Prints menu in the format of index, foodname and price with column headers.
     */
    @Override
    public void execute() {
        Ui.printMenuHeader();
        for (int i = 0; i < foodList.size(); i++) {
            Ui.printMenu(i + 1, foodList.get(i), priceList.get(i));
        }
        Ui.printWithBorder("");
    }
}
