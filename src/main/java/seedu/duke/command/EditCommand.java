package seedu.duke.command;

import seedu.duke.exceptions.LotsException;
import seedu.duke.PeopleManager;
import seedu.duke.Person;
import seedu.duke.Ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditCommand extends Command {
    
    public static final String COMMAND_WORD = "edit";
    private int personIndex;
    private int foodIndex, quantity;

    /**
     * Splits the input given the regular expression of a whitespace and
     * initialise the personIndex, orderIndex and quantity.
     * 
     * @param input The entire line of command entered by the user.
     * @throws LotsException If there is no input after the edit command or when the personIndex,
     * foodIndex or quantity is not a positive integer.
     */
    public EditCommand(String input) throws LotsException {
        String[] splitInput = input.split(" ");
        if (!checkUserInput(input)) {
            throw new LotsException("Please enter a valid person's index followed by the order index and order quantity! i.e. edit 1/1 /q 8 (wrong input test)");
        }
        assert checkUserInput(input) == true : "Invalid edit input command";
        try {
            personIndex = getPersonIndex(splitInput[1]);
            foodIndex = getOrderIndex(splitInput[1]);
            quantity = getQuantity(splitInput[3]);
        } catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException e) {
            throw new LotsException("Please enter a valid person's index followed by the order index and order quantity! i.e. edit 1/1 /q 8");
        }
    }

    /**
     * Regex to check User Input before passing onto the class.
     * 
     * @param input The entire line of command entered by the user.
     * @return a boolean true if the user input passes the regex.
     * @throws IllegalArgumentException when the pattern for Regex is not able to be interpreted.
     */
    private boolean checkUserInput(String input) throws IllegalArgumentException {
        try {
            Pattern pattern = Pattern.compile(
                "^edit [1-9][0-9]?/[1-9][0-9]? /q [0-9][0-9]?$", //max 99 food orders and quantity per pax
                Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            return matcher.find();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Get the index of the person whose order is to be edited.
     * 
     * @param editParams String from the user input after the edit command word.
     * @return Returns the index of the person in the form of an integer.
     * @throws IndexOutOfBoundsException When "/" is not found in the string.
     * @throws NumberFormatException When the person index can't be parsed into an integer.
     */
    private int getPersonIndex(String editParams) throws IndexOutOfBoundsException, NumberFormatException {
        int slashIndex = editParams.indexOf('/');
        String personIndexInString = editParams.substring(0, slashIndex);
        return Integer.parseInt(personIndexInString) - 1;
    }

    /**
     * Get the index of the order to be edited.
     * 
     * @param editParams String from the user input after the edit command word.
     * @return Returns the index of the order to be edited in the form of an integer.
     * @throws IndexOutOfBoundsException When "/" is not found in the string.
     * @throws LotsException When the order index is out of range.
     */
    private int getOrderIndex(String editParams) throws IndexOutOfBoundsException, LotsException {
        int slashIndex = editParams.indexOf('/');
        String orderIndexInString = editParams.substring(slashIndex + 1);
        int orderIndexInInteger = Integer.parseInt(orderIndexInString) - 1;
        if (orderIndexInInteger < 0) {
            throw new LotsException("Please enter a valid order index!");
        }
        assert orderIndexInInteger >= 0 : "Order index cannot be negative.";
        return orderIndexInInteger;
    }

    /**
     * Get the edited quantity.
     * 
     * @param editParams String from the user input after /q.
     * @return Returns the edited quantity in the form of an integer.
     * @throws LotsException When the quantity is out of range.
     */
    private int getQuantity(String editParams) throws LotsException {
        int quantityInInteger = Integer.parseInt(editParams);
        if (quantityInInteger < 0) {
            throw new LotsException("Please enter a valid quantity number!");
        }
        assert quantityInInteger >= 0 : "Quantity number cannot be negative.";
        return quantityInInteger;
    }

    /**
     * Edits the quantity of a specific order from a particular person.
     *
     * @throws LotsException If the order or person's index to be deleted is out of bounds.
     */
    @Override
    public void execute() throws LotsException {
        try {
            editOrder(super.peopleManager);
        } catch (IndexOutOfBoundsException e) {
            throw new LotsException("Please enter a valid person's index followed by the order index and order quantity! i.e. edit 1/1 /q 8");
        }
    }

    /**
     * Change the quantity of that particular order index to the specified quantity.
     * 
     * @param manager The list of people that are ordering.
     * @throws IndexOutOfBoundsException Throws when personIndex given is larger than the number of people.
     * @throws LotsException When there is an error in editing the quanity in Person.
     */
    private void editOrder(PeopleManager manager) throws IndexOutOfBoundsException, LotsException {
        if (manager.isEmpty()) {
            Ui.printEmptyMessage();
        } else {
            Person personToEditFrom = manager.getPerson(personIndex);
            assert personToEditFrom != null : "Person does not exists.";
            personToEditFrom.editParticularOrder(foodIndex, quantity);
            Ui.printEditMessage(personToEditFrom, foodIndex);
            //delete order if quantity 0
            deletePersonIfEmpty(manager, personToEditFrom);
        }
    }

    /**
     * Removes the person the list if his individual order list is empty.
     *
     * @param manager The list of people that are ordering.
     * @param personToDeleteFrom Person whose order is to be deleted from.
     * @throws LotsException When there is an error in removing the person from the people manager.
     */
    private void deletePersonIfEmpty(PeopleManager manager, Person personToDeleteFrom) throws LotsException {
        if (personToDeleteFrom.isEmpty()) {
            manager.deletePerson(personIndex);
        }
    }
}
