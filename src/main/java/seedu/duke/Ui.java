package seedu.duke;


import java.util.Scanner;

public class Ui {

    private static final String line = "--------------------------------------------------";
    private static final String BORDER = "=================================="
            + "============================="
            + "=============================";
    private static final Scanner SC = new Scanner(System.in);

    public static void printWelcome() {
        String welcomeMsg = "Welcome to L.O.T.S! What would you like to track today?";
        printWithBorder(welcomeMsg);
    }

    public static void printGoodbye() {
        String byeMsg = "Thank you for using L.O.T.S! Good bye!";
        printWithBorder(byeMsg);
    }

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

    /**
     * Prints a list of all the orders made so far.
     *
     * @param peopleManager List of people who are ordering.
     */
    public static void printOrdersList(PeopleManager peopleManager) {
        int totalNumOfPeopleOrdered = peopleManager.getSize();
        if (totalNumOfPeopleOrdered == 0) {
            printWithBorder("Your order list is empty!");
        } else {
            assert totalNumOfPeopleOrdered != 0 : "Order list cannot be empty.";
            for (int i = 0; i < totalNumOfPeopleOrdered; i++) {
                String currentPersonName = peopleManager.getPerson(i).personName;
                assert currentPersonName != null : "Person must exist.";
                printWithoutBorder((i + 1) + ") " + currentPersonName + ":");
                printIndividualPersonOrder(peopleManager.getPerson(i));
            }
            printWithBorder("");
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
        Order[] currentIndividualOrders = currentPerson.individualFoodOrders;
        assert currentIndividualOrders != null : "Person must have food orders.";
        int index = 1;
        for (int i = 0; i < totalMenuItems; i++) {
            Order currentOrder = currentIndividualOrders[i];
            if (currentOrder.getQuantity() != 0) {
                double currentCost = currentOrder.getCost();
                printWithoutBorder("\t(" + index + ") " + currentOrder);
                totalCost = totalCost + currentCost;
                currentItem++;
                index++;
            }
        }
        printWithoutBorder("[Total Cost = $" + String.format("%.2f", totalCost) + "]");
    }

    /**
     * Prints a message to notify the user of the deletion of an order.
     */
    public static void printDeleteMessage(Person person) {
        printWithBorder("Alright, that order has been deleted from " + person.personName + "!");
    }

    /**
     * Prints a message to notify the user of the edit made to his order.
     * Additionally, user's edited orders will printed to show changes made.
     */
    public static void printEditMessage(Person person, int foodIndex) {
        printWithBorder("Order " + (foodIndex + 1) + " from " + person.personName + "'s order has been edited");
        printIndividualPersonOrder(person);
    }

    /**
     * Prints a message to notify the user of an empty order list.
     */
    public static void printEmptyMessage() {
        printWithBorder("There are currently no orders!");
    }

    /**
     * Prints the details of the order that has just been added.
     *
     * @param person The person object that just added an order.
     */
    public static void printAddedOrderMessage(Person person) {
        assert person != null : "Person object cannot be null when adding!";
        printWithoutBorder("We have updated the order list for: " + person.personName);
        printIndividualPersonOrder(person);
        printWithBorder("");
    }

    public static void printMenuHeader() {
        printWithoutBorder("index | Food Name                         | Price");
        printWithoutBorder(line);
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
        printWithoutBorder(line);
    }

}
