package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private static String[] FOODS = {"Ban Mian", "Chicken Rice", "Fried Prawn Noodles (Hokkien Mee)",
                                     "Minced MeatNoodles(Ba Chor Mee)", "Fried Carrot Cake",
                                     "Fried Kway Teow (Char Kway Teow)",
                                     "Pork Rib Soup (Bak Kut Teh)", "Nasi Lemak"};
    private static final Double[] PRICES = {3.0, 3.0, 3.5, 3.0, 3.0, 3.0, 5.0, 3.6};

    public static final int TOTAL_MENU_ITEMS = PRICES.length;
    public static final ArrayList<String> FOODLIST = new ArrayList<>(Arrays.asList(FOODS));
    public static final ArrayList<Double> PRICELIST = new ArrayList<>(Arrays.asList(PRICES));

}
