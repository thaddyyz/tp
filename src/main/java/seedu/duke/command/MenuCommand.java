package seedu.duke.command;

import seedu.duke.exceptions.LotsException;
import seedu.duke.Menu;
import seedu.duke.Ui;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
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
        File myObject = new File("data/foodData.txt");
        Scanner myReader = new Scanner(myObject);
        extractMenuData(myReader);
        myReader.close();
    }

    /**
     * extractMenuData seperates txt file content into individual lines
     * and further seperates each line into food name and price to be
     * stored in seperate arraylists.
     *
     * @param myReader contains menu data collected from the txt file.
     */
    private void extractMenuData(Scanner myReader) {
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            foodList.add(data.substring(0, data.indexOf("|")));
            priceList.add(Double.parseDouble(data.substring(data.indexOf("|") + 1)));
        }
    }

    private void extractLocalMenuData() {
        priceList = Menu.PRICELIST;
        foodList = Menu.FOODLIST;
    }
}