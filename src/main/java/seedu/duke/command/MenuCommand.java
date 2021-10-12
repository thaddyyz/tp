package seedu.duke.command;

import seedu.duke.exceptions.LotsException;
import seedu.duke.Menu;
import seedu.duke.Ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MenuCommand extends Command {

    public static final String COMMAND_WORD = "menu";

    private ArrayList<Double> priceList = new ArrayList<>();
    private ArrayList<String> foodList = new ArrayList<>();

    /**
     * MenuCommand calls access to file to retrieve stored menu.
     */
    public MenuCommand() throws LotsException {
        try {
            getMenu();
        } catch (FileNotFoundException e) {
            throw new LotsException("Menu file not found!");
        }
        extractLocalMenuData();
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

    /**
     * Get menu data from foodData.txt
     */
    private void getMenu() throws FileNotFoundException {
        extractLocalMenuData();
    }

    private void extractLocalMenuData() {
        priceList = Menu.PRICELIST;
        foodList = Menu.FOODLIST;
    }
}
