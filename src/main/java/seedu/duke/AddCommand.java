package seedu.duke;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    private final String personName;
    private final int foodIndex;
    private final int foodQuantity;


    /**
     * Constructor with Regex checking input. If it does not match desirable input, then
     * variables will be initialised with a fixed input.
     * @param input will be returned by functions if it passes regex.
     *              will return fixed variables if it does not pass regex, and will throw exceptions.
     */
    public AddCommand(String input) throws Exception {
        if (checkUserInput(input)) {
            int[] indexOfSlashes = indexOfSlashes(input);
            this.personName = getPersonName(input, indexOfSlashes[0], indexOfSlashes[1]);
            this.foodIndex = getFoodIndex(input, indexOfSlashes[1], indexOfSlashes[2]);
            this.foodQuantity = getFoodQuantity(input, indexOfSlashes[2]);
        } else {
            //throw new lotsException();
            this.personName = "";
            this.foodIndex = -1;
            this.foodQuantity = -1;
        }
    }

    /**
     * Adds a new person with the given attributes into the list of people.
     * If it did not pass regex, it will throw new exception and no new addition of
     * person to the list of people will happen.
     */
    @Override
    public void execute() {
        if (personName != "" && foodIndex != -1 && foodQuantity != -1) {
            Person person = new Person(personName);
            person.addFoodToIndividualFoodOrders(foodIndex);
            PeopleManager.listOfPeople.add(person);
        } else {
            //throw new lotsException();
        }
    }

    /**
     * Regex to check User Input before passing onto the class.
     * @param input user input.
     * @return a boolean true if the user input passes the regex.
     */
    private boolean checkUserInput(String input) {
        Pattern pattern = Pattern.compile(
                "^add \\/n [a-zA-Z0-9][\\w \\d]{1,50} \\/i \\d{1,2} \\/q \\d{1,3}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    /**
     * Obtain index of "/" in the string to be use to split input strings into substrings.
     * @param input User input.
     * @return an array of index of "/".
     */
    private static int[] indexOfSlashes(String input) {

        int[] indexOfSlashes = new int[3];

        //Index firstSlashIndex to secondSlashIndex holds Person Name.
        int firstSlashIndex = input.indexOf("/");
        //Index secondSlashIndex to thirdSlashIndex holds index of Food.
        int secondSlashIndex = input.indexOf("/", firstSlashIndex + 1);
        //Index thirdSlashIndex to last index holds food quantity.
        int thirdSlashIndex = input.indexOf("/", secondSlashIndex + 1);

        indexOfSlashes[0] = firstSlashIndex;
        indexOfSlashes[1] = secondSlashIndex;
        indexOfSlashes[2] = thirdSlashIndex;

        return indexOfSlashes;
    }

    /**
     * Function used to parse the user input to get person name.
     * @param input User input.
     * @param indexOfFirstSlash First "/" index.
     * @param indexOfSecondSlash Second "/" index.
     * @return Person Name in String type.
     */
    private static String getPersonName(String input, int indexOfFirstSlash, int indexOfSecondSlash) {
        String tempPersonName = input.substring(indexOfFirstSlash + 1,indexOfSecondSlash - 1);
        return tempPersonName.trim();
    }

    /**
     * Function used to parse the user input to get food index.
     * @param input User input.
     * @param indexOfSecondSlash Second "/" index.
     * @param indexOfThirdSlash Third "/" index.
     * @return Food index in int type.
     */
    private static int getFoodIndex(String input, int indexOfSecondSlash, int indexOfThirdSlash) throws Exception {
        String subStringFoodIndex = input.substring(indexOfSecondSlash + 1, indexOfThirdSlash - 1).trim();
        try {
            int foodIndex = Integer.parseInt(subStringFoodIndex);
            if (foodIndex > Menu.TOTAL_MENU_ITEMS || foodIndex < 0) {
                //throw new lotsException
                return -1;
            } else {
                return foodIndex;
            }
        } catch (NumberFormatException e) {
            String errorMsg = "Please make sure the Food Index is keyed in correctly.";
            System.out.println(errorMsg);
            return -1;
        }
    }

    /**
     * Function used to parse the user input to get food index.
     * @param input User input.
     * @param indexOfThirdSlash Third "/" index.
     * @return Food Quantity in int type.
     */
    private static int getFoodQuantity(String input, int indexOfThirdSlash) throws Exception {
        String subStringFoodQuantity = input.substring(indexOfThirdSlash + 1, input.length()).trim();
        try {
            int foodQuantity = Integer.parseInt(subStringFoodQuantity);
            if (foodQuantity > 999 || foodQuantity < 0) {
                //throw new lotsException
                return -1;
            } else {
                return foodQuantity;
            }
        } catch (NumberFormatException e) {
            String errorMsg = "Please make sure the Food Quantity is keyed in correctly.";
            System.out.println(errorMsg);
            return -1;
        }
    }
}
