package seedu.duke;

public class Command {

    /* Declare a person/people list variable to know which list to edit
    e.g. protected PersonList personList;
    */

    //Constructor
    public Command() {
    }

    /**
     * Initialise the person list to be edited by the user.
     */
    public void setData(/*Person List. i.e. PersonList personList*/) {
        /*
        Initialise the person/people list
        e.g. personList = personList
        */
    }

    /**
     * Execute different set of instructions in the subclass based on the user's command.
     */
    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

}
