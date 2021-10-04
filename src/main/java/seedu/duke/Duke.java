package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {

        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = null;
        String input;
        try {
            in = new Scanner(System.in);
            System.out.println("Hello " + in.nextLine());
            System.out.println("Welcome to LOTS");
            /* Call printmenu method from Menu class */
            // Menu menu = new Menu();
            int runcode = 0;
            while (runcode == 0) {
                input = in.nextLine();
                if (input.indexOf("menu") != -1) {
                    Menu.printmenu();
                }
            }
        } finally {
            if (in != null)
                in.close();
        }
    }
}
