package seedu.duke;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    private final String personName;
    private final int foodIndex;
    private final int foodQuantity;

    public AddCommand(String input) {
        int[] indexOfSlashes = indexOfSlashes(input);
        this.personName = getPersonName(input, indexOfSlashes[0], indexOfSlashes[1]);
        this.foodIndex = getFoodIndex(input, indexOfSlashes[1], indexOfSlashes[2]);
        this.foodQuantity = getFoodQuantity(input, indexOfSlashes[2]);
    }

    /**
     * Adds a new person with the given attributes into the list of people.
     */
    @Override
    public void execute() {
        Person person = new Person(personName);
        person.addFoodToIndividualFoodOrders(foodIndex);
        PeopleManager.listOfPeople.add(person);
    }

    /**
     * Regex to check User Input before passing onto the class.
     * @param input
     * @return
     */
    public boolean checkUserInput(String input) {
        Pattern pattern = Pattern.compile(
                "^add \\/n [a-zA-Z1-9][\\w \\d]{1,50} \\/i \\d{1,2} \\/q \\d{1,3}$",
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
    private static int getFoodIndex(String input, int indexOfSecondSlash, int indexOfThirdSlash) {
        String subStringFoodIndex = input.substring(indexOfSecondSlash + 1, indexOfThirdSlash - 1).trim();
        int foodIndex = Integer.parseInt(subStringFoodIndex);
        return foodIndex;
    }

    /**
     * Function used to parse the user input to get food index.
     * @param input User input.
     * @param indexOfThirdSlash Third "/" index.
     * @return Food Quantity in int type.
     */
    private static int getFoodQuantity(String input, int indexOfThirdSlash) {
        String subStringFoodQuantity = input.substring(indexOfThirdSlash + 1, input.length()).trim();
        int foodQuantity = Integer.parseInt(subStringFoodQuantity);
        return foodQuantity;
    }
}
