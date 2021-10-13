package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    private static final String TEST_NAME = "hello";

    @Test
    public void addFoodToIndividualFoodOrders_zeroOrLess_expectException() {
        Person person = new Person(TEST_NAME);
        assertThrows(LotsException.class, () -> {
            person.addFoodToIndividualFoodOrders(-1);
        });
        assertThrows(LotsException.class, () -> {
            person.addFoodToIndividualFoodOrders(0);
        });
    }

    @Test
    public void addFoodToIndividualFoodOrders_moreThantotalMenuItems_expectException() {
        Person person = new Person(TEST_NAME);
        assertThrows(LotsException.class, () -> {
            person.addFoodToIndividualFoodOrders(88);
        });
    }
    
    @Test
    public void removeFoodFromIndividualFoodOrders_zeroOrLess_expectException() {
        Person person = new Person(TEST_NAME);
        assertThrows(LotsException.class, () -> {
            person.removeFoodFromIndividualFoodOrders(-1,1);
        });
        assertThrows(LotsException.class, () -> {
            person.removeFoodFromIndividualFoodOrders(0,1);
        });
    }

    @Test
    public void removeFoodFromIndividualFoodOrders_moreThantotalMenuItems_expectException() {
        Person person = new Person(TEST_NAME);
        assertThrows(LotsException.class, () -> {
            person.removeFoodFromIndividualFoodOrders(88,1);
        });
    }

    /*@Test
    public void deleteParticularOrder_OutOfRange() {
        Person person = new Person(TEST_NAME);
        assertThrows(LotsException.class, () -> {
            person.deleteParticularOrder(person.numberOfOrders+1);
        } );
    }*/
 
}
