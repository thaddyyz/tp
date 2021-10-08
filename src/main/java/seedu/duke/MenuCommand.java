package seedu.duke;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class MenuCommand extends Command {

    ArrayList<Double> priceList = new ArrayList<>();
    ArrayList<String> foodList = new ArrayList<>();

    /**
     * MenuCommand calls access to file to retrieve stored menu and 
     * prints menu in the format of index, foodname and price.
     * */
    public MenuCommand() throws FileNotFoundException { 
        try {
            getMenu();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Menu file not found!");
        }
        Ui.printMenuHeader();
        for (int i = 0; i < foodList.size(); i++) {
            Ui.printMenu(i + 1, foodList.get(i), priceList.get(i));
        }
    }

    /**
     * Get menu data from foodData.txt
     * */
    private void getMenu() throws FileNotFoundException {
        File myObject = new File("data/foodData.txt");
        Scanner myReader = new Scanner(myObject);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            foodList.add(data.substring(0,data.indexOf("|")));
            priceList.add(Double.parseDouble(data.substring(data.indexOf("|") + 1)));
        }
        myReader.close();
    }
}
