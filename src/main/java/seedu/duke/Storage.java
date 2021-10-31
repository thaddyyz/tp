package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exceptions.LotsException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Storage {

    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static final java.nio.file.Path FILE_PATH = java.nio.file.Paths.get(CURRENT_DIRECTORY);
    private static final PeopleManager FILE_PEOPLE_MANAGER = new PeopleManager();

    /**
     * Initialises the PeopleManager according to the contents of the file.
     * Returns the PeopleManager.
     *
     * @return Returns the PeopleManager initialised based on the contents of the file.
     */
    public static PeopleManager initialiseFile() {
        try {
            //get the file, else create file if it does not exist.
            File ordersFile = getOrdersFile();
            Scanner fileList = new Scanner(ordersFile);

            //read and extract the data in the file to store it in listOfPeople in PeopleManager.
            readAndExtractFile(fileList);
        } catch (IOException | LotsException e) {
            e.printStackTrace();
        }
        clearOutput();
        return FILE_PEOPLE_MANAGER;
    }

    /**
     * Clears the output and start a fresh command line screen.
     */
    private static void clearOutput() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Reads the file if it exists or creates the file if it does not.
     * Returns a File type of the file containing the existing list of people and their respective orders.
     *
     * @return Returns a File type of the file containing the list of people and their respective orders.
     * @throws IOException If the file cannot be read or created.
     */
    private static File getOrdersFile() throws IOException {
        File taskFile = new File(FILE_PATH + "/.orders.txt");
        System.out.println("loading...");
        return taskFile;
    }

    /**
     * Reads and initialises the PeopleManager based on the content of the file.
     *
     * @param fileList The content of the file.
     * @throws LotsException If there is an error initialising the PeopleManager.
     */
    private static void readAndExtractFile(Scanner fileList) throws LotsException {
        while (fileList.hasNextLine()) {
            String data = fileList.nextLine();
            String[] splitData = data.split(",");
            if (splitData.length == (Menu.TOTAL_MENU_ITEMS + 1)) {
                executeLoad(splitData);
            }
        }
    }

    /**
     * Interprets the content of a single line and initialise it to PeopleManager.
     *
     * @param splitData Array consisting the data needed such as name and quantity.
     * @throws LotsException If there is an error initialising the PeopleManager.
     */
    private static void executeLoad(String[] splitData) throws LotsException {
        String personName = splitData[0];
        for (int i = 1; i < splitData.length; i++) {
            int quantityToAdd = Integer.parseInt(splitData[i]);
            if (quantityToAdd > 0 && quantityToAdd < 1000) {
                String orderCommand = "add /n " + personName + " /i " + i + " /q " + quantityToAdd;
                if (checkFileLineInput(orderCommand)) {
                    Command command;
                    command = Parser.getCommand(orderCommand);
                    command.setData(FILE_PEOPLE_MANAGER);
                    command.execute();
                }
            }
        }
    }

    /**
     * Regex to check the contents of a particular line in the file before loading it.
     *
     * @param input file input.
     * @return a boolean true if the file input passes the regex.
     * @throws IllegalArgumentException when the pattern for Regex is not able to be interpreted.
     */
    private static boolean checkFileLineInput(String input) throws IllegalArgumentException {
        try {
            Pattern pattern = Pattern.compile(
                "^add \\/n [a-zA-Z0-9][\\w \\d]{0,50} \\/i \\d{1,2} \\/q \\d{1,3}$",
                Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            boolean matchFound = matcher.find();
            return matchFound;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Updates and overwrites the existing file with a updated listOfPeople with their respective orders.
     *
     * @param manager PeopleManager containing the updated listOfPeople
     * @throws IOException If the write operation to the file fails.
     */
    public static void updateFile(PeopleManager manager) throws IOException {
        FileWriter taskWriter = new FileWriter(FILE_PATH + "/.orders.txt", false);
        for (Person person : manager.getEntireListOfPeople()) {
            String personName = person.getPersonName();
            int[] quantityPerFood = getQuantityPerFood(person);
            String quantityPerFoodInString = getQuantityPerFoodInString(quantityPerFood);
            String dataWritten = personName + quantityPerFoodInString + System.lineSeparator();
            taskWriter.write(dataWritten);
        }
        taskWriter.close();
    }

    /**
     * Returns an array containing the quantity per food.
     * If there is no quantity for that particular food, it will be set as '0'.
     *
     * @param person Person whose list is getting updated in the file.
     * @return Array containing the quantity per food order.
     */
    private static int[] getQuantityPerFood(Person person) {
        int foodIndex = 0;
        int[] quantityArray = new int[Menu.TOTAL_MENU_ITEMS];
        for (Order order : person.getEntireFoodOrdersOfPerson()) {
            quantityArray[foodIndex] = order.getQuantity();
            foodIndex++;
        }
        return quantityArray;
    }

    /**
     * Returns the quantity per food order in a string format.
     * The array would be represented in a string format using ',' as its separator.
     *
     * @param quantityPerFood Array containing the quantity per food.
     * @return A string consisting of all the quantity from each food.
     */
    private static String getQuantityPerFoodInString(int[] quantityPerFood) {
        String quantityPerFoodString = "";
        for (int i = 0; i < quantityPerFood.length; i++) {
            quantityPerFoodString = quantityPerFoodString + "," + quantityPerFood[i];
        }
        return quantityPerFoodString;
    }
}
