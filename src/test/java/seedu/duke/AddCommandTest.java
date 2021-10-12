package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.exceptions.LotsException;


public class AddCommandTest {

    @Test
    public void execute_foodIndexIsNegative_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i -1 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index is Negative. \n");
        }
    }

    @Test
    public void execute_quantityIsNegative_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 2 /q -10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity is Negative. \n");
        }
    }

    @Test
    public void execute_foodIndexIsZero_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 0 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index is zero. \n");
        }
    }

    @Test
    public void execute_quantityIsZero_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 2 /q 0");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity is zero. \n");
        }
    }

    @Test
    public void execute_foodIndexPositiveButOutOfRange_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 13 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index Positive but out of range. \n");
        }
    }

    @Test
    public void execute_quantityPositiveButOutOfRange_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 2 /q 1000");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity Positive but out of range. \n");
        }
    }

    @Test
    public void execute_wrongNumberOfSlashes_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 2 ");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Missing Slash. \n");
        }
    }

    @Test
    public void execute_alphaNumericNamesOnly_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n J@cob! /i 2 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("There are other characters in Names. \n");
        }
    }

    @Test
    public void execute_inputForNameIsSpaces_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n          /i 2 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Name cannot be spaces. \n");
        }
    }

    @Test
    public void execute_inputForFoodIndexIsSpaces_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n Jenson /i     2    /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index cannot be spaces. \n");
        }
    }

    @Test
    public void execute_inputForQuantityIsSpaces_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n Jenson /i 3 /q        ");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity cannot be spaces. \n");
        }
    }

    @Test
    public void execute_foodIndexCannotBeInWord_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i Zero /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index is in Words. \n");
        }
    }

    @Test
    public void execute_quantityCannotBeInWord_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 3 /q two hundred");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity is in Words. \n");
        }
    }

    @Test
    public void execute_foodIndexContainsCharacters_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 2@1 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Food Index contains characters. \n");
        }
    }

    @Test
    public void execute_quantityContainsCharacters_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n jacob /i 9 /q 2!4");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Quantity contains characters. \n");
        }
    }

    @Test
    public void execute_inputForNameIsMoreThan50Characters_throwsLotsException()
            throws Exception {
        try {
            Command command;
            command = Parser.getCommand("add /n Jenson Jacob Jenson Jacob Jenson Jacob Jenson Jacob Jenson Jacob "
                    + "Jenson Jacob Jenson Jacob Jenson Jacob Jenson /i 2 /q 10");
            command.execute();
        } catch (LotsException | NumberFormatException e) {
            System.out.println("Name cannot be more than 50 spaces. \n");
        }
    }
}
