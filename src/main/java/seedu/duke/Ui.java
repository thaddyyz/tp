package seedu.duke;

import java.util.Scanner;

public class Ui {

    private static final String line = "--------------------------------------------------";
    private static final String BORDER = "=================================="
            + "============================="
            + "=============================";
    private static final Scanner SC = new Scanner(System.in);

    /**
     * Prints the string provided followed by the border.
     *
     * @param stringToPrint The string to output to user.
     */
    public static void printWithBorder(String stringToPrint) {
        System.out.println(stringToPrint);
        System.out.println(BORDER);
    }

    public static void printWithoutBorder(String stringToPrint) {
        System.out.println(stringToPrint);
    }

    /**
     * Returns the user's input with the leading and
     * trailing spaces stripped.
     *
     * @return The User's input in String.
     */
    public static String readInput() {
        String input = SC.nextLine();
        return input.strip();
    }

    public static void printWelcome() {
        String welcomeMsg = "Welcome to L.O.T.S! What would you like to track today?";
        printWithBorder(welcomeMsg);
    }

    public static void printGoodbye() {
        String byeMsg = "Thank you for using L.O.T.S! Good bye!";
        printWithBorder(byeMsg);
    }

    /**
     * Prints a list of all the orders made so far.
     */
    public static void printOrdersList() {
        int totalNumOfPeopleOrdered = PeopleManager.listOfPeople.size();
        if (totalNumOfPeopleOrdered == 0) {
            System.out.println("Your order list is empty!");
        } else {
            for (int i = 0; i < totalNumOfPeopleOrdered; i++) {
                String currentPersonName = PeopleManager.listOfPeople.get(i).personName;
                System.out.println((i + 1) + ". " + currentPersonName + ":");
                printIndividualPersonOrder(PeopleManager.listOfPeople.get(i));
            }
        }
    }

    /**
     * Prints a list of the food items that an individual person has ordered, and displays the total
     * cost of the items.
     *
     * @param currentPerson Person entry in the list that is currently being accessed.
     */
    private static void printIndividualPersonOrder(Person currentPerson) {
        double totalCost = 0;
        int currentItem = 1;
        int totalMenuItems = Menu.TOTAL_MENU_ITEMS;
        Integer[] currentIndividualOrders =  currentPerson.individualFoodOrders;
        for (int i = 0; i < totalMenuItems; i++) {
            if (currentIndividualOrders[i] != 0) {
                double currentCost = currentIndividualOrders[i] * getFoodCost(i);
                System.out.println("\t" + currentItem + ") " + getFoodName(i) + " | Quantity = "
                        + currentIndividualOrders[i] + " | Cost = $" + String.format("%.2f", currentCost));
                totalCost = totalCost + currentCost;
                currentItem++;
            }
        }
        System.out.println("[Total Cost = $" + String.format("%.2f", totalCost) + "]");
    }

    /**
     * Obtains the corresponding food name of the current food index.
     *
     * @param currentFoodIndex Index of food item currently accessed.
     * @return Name of food in String type.
     */
    private static String getFoodName(int currentFoodIndex) {
        String[] foodName = {"Ban Mian", "Chicken Rice", "Fried Prawn Noodles (Hokkien Mee)",
            "Minced Meat Noodles(Ba Chor Mee)", "Fried Carrot Cake", "Fried Kway Teow (Char Kway Teow)",
            "Pork Rib Soup (Bak Kut Teh)", "Nasi Lemak"};
        return foodName[currentFoodIndex];
    }

    /**
     * Obtains the corresponding cost of the current food index.
     *
     * @param currentFoodIndex Index of food item currently accessed.
     * @return Cost of food in Double type.
     */
    private static double getFoodCost(int currentFoodIndex) {
        double[] foodPrice = {3.0, 3.0, 3.5, 3.0, 3.0, 3.0, 5.0, 3.6};
        return foodPrice[currentFoodIndex];
    }

    public static void printMenuHeader() {
        System.out.println("index | Food Name                         | Price");
        System.out.println(line);
    }

    /**
     * Prints out the menu item that has been passed in
     * using the proper format followed by a small border.
     *
     * @param index The Index of the food item.
     * @param foodName The name of the food at the index in String.
     * @param foodPrice The price of the food in Double.
     */
    public static void printMenu(int index, String foodName, Double foodPrice) {
        System.out.format("%-8d%-33s%7.2f%n", index, foodName, foodPrice);
        System.out.println(line);
    }
}
