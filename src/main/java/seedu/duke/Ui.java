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
     *
     * @param peopleManager List of people who are ordering.
     */
    public static void printOrdersList(PeopleManager peopleManager) {
        int totalNumOfPeopleOrdered = peopleManager.getSize();
        if (totalNumOfPeopleOrdered == 0) {
            Ui.printWithBorder("Your order list is empty!");
        } else {
            for (int i = 0; i < totalNumOfPeopleOrdered; i++) {
                String currentPersonName = peopleManager.getPerson(i).personName;
                Ui.printWithoutBorder((i + 1) + ". " + currentPersonName + ":");
                printIndividualPersonOrder(peopleManager.getPerson(i));
            }
            Ui.printWithBorder("");
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
        int currentItem = 97; //97 is the ascii for 'a'.
        int totalMenuItems = Menu.TOTAL_MENU_ITEMS;
        int[] currentIndividualOrders = currentPerson.individualFoodOrders;
        for (int i = 0; i < totalMenuItems; i++) {
            if (currentIndividualOrders[i] != 0) {
                double currentCost = currentIndividualOrders[i] * Menu.PRICELIST.get(i);
                Ui.printWithoutBorder("\t" + (char) currentItem + ") " + Menu.FOODLIST.get(i) + " | Quantity = "
                        + currentIndividualOrders[i] + " | Cost = $" + String.format("%.2f", currentCost));
                totalCost = totalCost + currentCost;
                currentItem++;
            }
        }
        Ui.printWithoutBorder("[Total Cost = $" + String.format("%.2f", totalCost) + "]");
    }

    //To be further improved

    /**
     * Prints a message to notify the user of the deletion of an order.
     */
    public static void printDeleteMessage() {
        Ui.printWithoutBorder("Alright, that order has been deleted!");
    }

    public static void printAddedOrderMessage(Person person) {
        Ui.printWithoutBorder("We have updated the order list for: " + person.personName);
        printIndividualPersonOrder(person);
        Ui.printWithBorder("");
    }

    public static void printMenuHeader() {
        Ui.printWithoutBorder("index | Food Name                         | Price");
        Ui.printWithoutBorder(line);
    }

    /**
     * Prints out the menu item that has been passed in
     * using the proper format followed by a small border.
     *
     * @param index     The Index of the food item.
     * @param foodName  The name of the food at the index in String.
     * @param foodPrice The price of the food in Double.
     */
    public static void printMenu(int index, String foodName, Double foodPrice) {
        System.out.format("%-8d%-33s%7.2f%n", index, foodName, foodPrice);
        Ui.printWithoutBorder(line);
    }
}
