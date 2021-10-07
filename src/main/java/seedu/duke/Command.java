package seedu.duke;

public class Command {

    protected PeopleManager peopleManager;

    //Constructor
    public Command() {
    }

    /**
     * Initialise the person list to be edited by the user.
     */
    public void setData(PeopleManager peopleList) {
        peopleManager = peopleList;
    }

    /**
     * Execute different set of instructions in the subclass based on the user's command.
     */
    public void execute() throws LotsException {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

}
