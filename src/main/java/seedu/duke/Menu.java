package seedu.duke;

public class Menu {

    public static final int TOTAL_MENU_ITEMS = 10;
    
    public Menu() {

    }

    /**
     * print menu prints a fixed list of prestored foo items.
     * */
    public static void printMenu() {
        String line = "--------------------------------------------------";
        double[] foodPrice = {3.0, 3.0, 3.5, 3.0, 3.0, 3.0, 5.0, 3.6};
        String[] foodName = {"Ban Mian                         ", "Chicken Rice                     ",
                             "Fried Prawn Noodles (Hokkien Mee)", "Minced MeatNoodles(Ba Chor Mee)  ",
                             "Fried Carrot Cake                ", "Fried Kway Teow (Char Kway Teow) ",
                             "Pork Rib Soup (Bak Kut Teh)      ", "Nasi Lemak                       "};
        System.out.println("index | Food Name                         | Price");
        System.out.println(line);
        for (int i = 0; i < foodPrice.length; i++) {
            System.out.println((i + 1) + "     | " + foodName[i] + " | $"
                    + String.format("%.2f", foodPrice[i]));
            System.out.println(line);
        }

    }
    // use map to store name and value
    // add items
    // show menu
    // Print menu functions

}
