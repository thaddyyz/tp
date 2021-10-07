package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {

    /**
     * Checks if the specified index value will pass.
     * after being inputted into the addFoodToIndividualFoodOrders function.
     * @throws Exception when the output is incorrect.
     */
    @Test
    public void addFoodToIndividualFoodOrders_incrementIndex2ValueBy1_Index2ValueIncreasedBy1() throws Exception {
        Person trialPerson = initialisePersonClass();
        //FoodIndex = -2 is not within the array.
        assertEquals("Please enter the right menu number!",trialPerson.addFoodToIndividualFoodOrders(-2));
        //FoodIndex = 11 is not within the array.
        assertEquals("Please enter the right menu number!", trialPerson.addFoodToIndividualFoodOrders(11));
        //FoodIndex = 2 is within the array. Function should enter if() loop.
        assertEquals("Completed!",trialPerson.addFoodToIndividualFoodOrders(2));
    }

    /**
     * Checks if the specified index value will pass.
     * after being inputted into the removeFoodFromIndividualFoodOrders function.
     * @throws Exception if the value is not the same.
     */
    @Test
    public void removeFoodFromIndividualFoodOrders_remainsZero() throws Exception {
        Person trialPerson = initialisePersonClass();
        //FoodIndex = -3 is not within the array.
        assertEquals("Please enter the right menu number!", trialPerson.removeFoodFromIndividualFoodOrders(-3));
        //FoodIndex = 30 is not within the array.
        assertEquals("Please enter the right menu number!", trialPerson.removeFoodFromIndividualFoodOrders(30));
        //FoodIndex = 3 is within the array.
        assertEquals("Completed!", trialPerson.removeFoodFromIndividualFoodOrders(3));
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
