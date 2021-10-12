package seedu.duke;


public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    private int personIndex;
    private int orderIndex;

    /**
     * Splits the input given the regular expression of a whitespace and
     * initialise the personIndex and orderIndex.
     *
     * @param input The entire line of command entered by the user.
     * @throws LotsException If there is no input after the delete command or when the personIndex is not an integer.
     */
    public DeleteCommand(String input) throws LotsException {
        String[] splitInput = input.split(" ");
        try {
            personIndex = getPersonIndex(splitInput[1]);
            orderIndex = getOrderIndex(splitInput[1]);
        } catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException e) {
            throw new LotsException("Please enter a valid person's index followed by the order index!");
        }
    }

    /**
     * Get the index of the person whose order is to be deleted.
     *
     * @param deleteParams String from the user input after the delete command word.
     * @return Returns the index of the person in the form of an integer.
     * @throws IndexOutOfBoundsException When "/" is not found in the string.
     * @throws NumberFormatException     When the person index can't be parsed into an integer.
     */
    private int getPersonIndex(String deleteParams) throws IndexOutOfBoundsException, NumberFormatException {
        int slashIndex = deleteParams.indexOf('/');
        String personIndexInString = deleteParams.substring(0, slashIndex);
        return Integer.parseInt(personIndexInString) - 1;
    }

    /**
     * Get the index of the order to be deleted.
     *
     * @param deleteParams String from the user input after the delete command word.
     * @return Returns the idnex of the order to be deleted in the form of an integer.
     * @throws IndexOutOfBoundsException When "/" is not found in the string.
     * @throws LotsException             When the order index is out of range.
     */
    private int getOrderIndex(String deleteParams) throws IndexOutOfBoundsException, LotsException {
        int slashIndex = deleteParams.indexOf('/');
        int orderIndexInInteger = Character.getNumericValue(deleteParams.charAt(slashIndex + 1)) - 10;
        if (orderIndexInInteger < 0) {
            throw new LotsException("Please enter a valid order index!");
        }
        return orderIndexInInteger;
    }

    /**
     * Deletes a specific order from a particular person.
     *
     * @throws LotsException If the order or person's index to be deleted is out of bounds.
     */
    @Override
    public void execute() throws LotsException {
        try {
            deleteOrder(peopleManager);
        } catch (IndexOutOfBoundsException e) {
            throw new LotsException("Please enter a valid person's index followed by the order index! E.g) delete 1/a");
        }
    }

    /**
     * Change the quantity of that particular order index to 0.
     *
     * @param manager The list of people that are ordering.
     * @throws IndexOutOfBoundsException Throws when personIndex given is larger than the number of people.
     */
    private void deleteOrder(PeopleManager manager) throws IndexOutOfBoundsException, LotsException {
        Person personToDeleteFrom = manager.getPerson(personIndex);
        personToDeleteFrom.deleteParticularOrder(orderIndex);
        manager.deletePerson(personIndex);
        Ui.printDeleteMessage();
    }
}
