package seedu.duke;

public class Person {

    protected int totalMenuItems = Menu.TOTAL_MENU_ITEMS;
    protected String personName;
    protected Integer[] individualFoodOrders = new Integer[totalMenuItems];

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
     * Used to populate the array with 0.
     */
    private void setupIndividualFoodOrders() {
        for (int i = 0; i < totalMenuItems; i++) {
            individualFoodOrders[i] = 0;
        }
    }

    /**
     * Add the quantity of the corresponding food index by 1.
     * @param foodIndex Index of food in the menu.
     */
    protected void addFoodToIndividualFoodOrders(int foodIndex) {
        individualFoodOrders[foodIndex] = individualFoodOrders[foodIndex] + 1;
    }

    /**
     * Minus the quantity of the corresponding food index by 1.
     * If the quantity of food is 0, the quantity remains 0.
     * @param foodIndex Index of food in the menu.
     */
    protected void removeFoodFromIndividualFoodOrders(int foodIndex) {
        if (individualFoodOrders[foodIndex] != 0) {
            individualFoodOrders[foodIndex] = individualFoodOrders[foodIndex] - 1;
        } else {
            individualFoodOrders[foodIndex] = 0;
        }
    }
}
