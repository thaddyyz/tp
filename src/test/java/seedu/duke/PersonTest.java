package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {

    /**
     * Test case to check if the individualFoordOrders Array is populated with
     * int 0 at the start.
     * @throws Exception thrown when the array is not populated with int 0.
     */
    @Test
    public void setupIndividualFoodOrders_emptyArray() throws Exception {
        for (int i = 0; i < Menu.TOTAL_MENU_ITEMS; i++) {
            assertEquals(0, initialisePersonClass().individualFoodOrders[i]);
        }
    }

    /**
     * Checks if the personName is null or not.
     * @throws Exception if the personName variable is Null.
     */
    @Test
    public void personName_notNull() throws Exception {
        assertNotNull(initialisePersonClass().personName);
    }

    /**
     * Checks if the increment is 1 when using the addFoodToIndividualFoodOrders function.
     * Checks if the increment is at the right index.
     * @throws Exception when the increment is not increased by 1 and is at the wrong index.
     */
    @Test
    public void addFoodToIndividualFoodOrders_increment() throws Exception {
        Person trialPerson = initialisePersonClass();
        trialPerson.addFoodToIndividualFoodOrders(2);
        assertEquals(1,trialPerson.individualFoodOrders[2]);
    }

    /**
     * Checks if the specified index value will remain 0
     * after using the removeFoodFromIndividualFoodOrders function.
     * @throws Exception if the value is not 0.
     */
    @Test
    public void removeFoodFromIndividualFoodOrders_remainsZero() throws Exception {
        Person trialPerson = initialisePersonClass();
        trialPerson.removeFoodFromIndividualFoodOrders(2);
        assertEquals(0, trialPerson.individualFoodOrders[2]);
    }

    /**
     * Function to initialise Person class with a person variable.
     * @return variable of Person class.
     */
    public Person initialisePersonClass() {
        Person personA = new Person("Charles");
        return  personA;
    }
}
