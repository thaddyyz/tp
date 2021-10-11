package seedu.duke;

public class Person {

    protected int totalMenuItems = Menu.TOTAL_MENU_ITEMS;
    protected String personName;
    protected Integer[] individualFoodOrders = new Integer[totalMenuItems];
    private String foodIndexOutOfBoundsErrorMessage = "Please enter the right menu number!";

    /**
     * Constructor for Person.
     * Individual Food order list will be populated with 0 on initialisation.
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
        for (int i = 1; i < totalMenuItems + 1; i++) {
            individualFoodOrders[i] = 0;
        }
    }

    /**
     * Add the quantity of the corresponding food index by 1.
     * @param foodIndex Index of food in the menu.
     */
    protected void addFoodToIndividualFoodOrders(int foodIndex) throws LotsException {
        if (foodIndex < totalMenuItems && foodIndex >= 0) {
            individualFoodOrders[foodIndex] = individualFoodOrders[foodIndex] + 1;
        } else {
            throw new LotsException(foodIndexOutOfBoundsErrorMessage);
        }
    }

    /**
     * Minus the quantity of the corresponding food index by 1.
     * If the quantity of food is 0, the quantity remains 0.
     * @param foodIndex Index of food in the menu.
     */
    protected void removeFoodFromIndividualFoodOrders(int foodIndex) throws LotsException {
        if (foodIndex < totalMenuItems && foodIndex >= 0) {
            if (individualFoodOrders[foodIndex] != 0) {
                individualFoodOrders[foodIndex] = individualFoodOrders[foodIndex] - 1;
            } else {
                individualFoodOrders[foodIndex] = 0;
            }
        } else {
            throw new LotsException(foodIndexOutOfBoundsErrorMessage);
        }
    }
}
