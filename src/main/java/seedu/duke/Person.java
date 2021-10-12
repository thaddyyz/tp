package seedu.duke;

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
    protected void addFoodToIndividualFoodOrders(int foodIndex) throws LotsException {
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
    protected void removeFoodFromIndividualFoodOrders(int foodIndex, int quantity) throws LotsException {
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

}
