package seedu.duke;

import seedu.duke.exceptions.LotsException;

public class Person {

    protected int totalMenuItems = Menu.TOTAL_MENU_ITEMS;
    protected String personName;
    protected int[] individualFoodOrders = new int[totalMenuItems];
    private String foodIndexOutOfBoundsErrorMessage = "Please enter the right menu number!";

    /**
     * Constructor for Person.
     * Individual Food order list will be populated with 0 on initialisation.
     *
     * @param personName Name of the person.
     */
    public Person(String personName) {
        this.personName = personName;
        setupIndividualFoodOrders();
    }

    /**
     * Used to populate the array with 0 from index 1 to total_menu_items(10).
     */
    private void setupIndividualFoodOrders() {
        for (int i = 0; i < totalMenuItems; i++) {
            individualFoodOrders[i] = 0;
        }
    }

    /**
     * Add the quantity of the corresponding food index by 1.
     *
     * @param foodIndex Index of food in the menu.
     */
    public void addFoodToIndividualFoodOrders(int foodIndex) throws LotsException {
        if (foodIndex <= totalMenuItems && foodIndex > 0) {
            individualFoodOrders[foodIndex - 1] = individualFoodOrders[foodIndex - 1] + 1;
        } else {
            throw new LotsException(foodIndexOutOfBoundsErrorMessage);
        }
    }

    /**
     * Minus the quantity of the corresponding food index by 1.
     * If the quantity of food is 0, the quantity remains 0.
     *
     * @param foodIndex Index of food in the menu.
     */
    public void removeFoodFromIndividualFoodOrders(int foodIndex, int quantity) throws LotsException {
        if (foodIndex <= totalMenuItems && foodIndex > 0) {
            if (individualFoodOrders[foodIndex - 1] != 0) {
                individualFoodOrders[foodIndex - 1] = individualFoodOrders[foodIndex - 1] - quantity;
            } else {
                individualFoodOrders[foodIndex - 1] = 0;
            }
        } else {
            throw new LotsException(foodIndexOutOfBoundsErrorMessage);
        }
    }

    /**
     * Sets the quantity of a particular food order in the order array to 0.
     *
     * @param foodIndex Index of the order whose quantity is getting set to 0.
     * @throws LotsException When order index is more than the number of orders.
     */
    public void deleteParticularOrder(int foodIndex) throws LotsException {
        int numberOfOrders = 0;
        for (int i = 0; i < totalMenuItems; i++) {
            if (individualFoodOrders[i] > 0) {
                numberOfOrders++;
            }
            if (foodIndex + 1 == numberOfOrders) {
                individualFoodOrders[i] = 0;
            }
        }
        if (foodIndex + 1 > numberOfOrders) {
            throw new LotsException("Please enter a valid order index!");
        }
    }

    /**
     * Sets the quantity of a particular food to quantity requested by user.
     * 
     * @param foodIndex Index of the order whose quantity is to be changed.
     * @param quantity Quantity of food to be set.
     * @throws LotsException When foodIndex is more than number of food in menu or
     *     order quantity is less than 0.
     */
    public void editParticularOrder(int foodIndex, int quantity) throws LotsException {
        int numberOfOrders = 0;
        if (foodIndex <= totalMenuItems && foodIndex >= 0) {
            for (int i = 0; i < totalMenuItems; i++) {
                findAndEditParticularOrder(numberOfOrders, foodIndex, quantity, i);
            }
        } else {
            throw new LotsException(foodIndexOutOfBoundsErrorMessage);
        }
    }

    /**
     * Extention of editParticularOrder() to find the particular order to edit.
     * 
     * @param numberOfOrders Number of orders tagged to the person of interest.
     * @param foodIndex Index of the order whose quantity is to be changed.
     * @param quantity Quantity of food to be set.
     * @param i Current index of individualFoodOrders array to search.
     * @throws LotsException When foodIndex is more than number of food in menu or
     *     order quantity is less than 0.
     */
    private void findAndEditParticularOrder(int numberOfOrders, int foodIndex, int quantity, int i) 
        throws LotsException {
        if (individualFoodOrders[i] > 0) {
            numberOfOrders++;
        }
        if (foodIndex + 1 == numberOfOrders) {
            if (quantity == 0) {
                deleteParticularOrder(foodIndex);
            } else {
                individualFoodOrders[i] = quantity;
            }
        }
    }

    /**
     * Checks if the individual order of this person is empty by checking
     * if the quantity of food orders are 0.
     *
     * @return Returns true if all the quantity of the food orders are 0, else returns false.
     */
    public boolean isEmpty() {
        int numberOfOrders = 0;
        for (int i = 0; i < totalMenuItems; i++) {
            if (individualFoodOrders[i] > 0) {
                numberOfOrders++;
            }
        }
        if (numberOfOrders == 0) {
            return true;
        }
        return false;
    }

}
