import java.util.Scanner;

public class IO
{
    // Attributes
    boolean exit = false;
    //CONTROLLER OBJECT IS ATTRIBUTE OF IO CLASS
    private Controller ioController;


    // Constructor

    public IO()
    {
        //CREATES CONTROLLER INSTANCE WHEN IO OBJECT IS INSTANTIATED
        this.ioController = new Controller();
    }

    // Methods


    // Header for the menu
    private void printHeder()
    {
        // Creating the header for our menu
        System.out.println("------------------------------");
        System.out.println("|     Track and Trace        |");
        System.out.println("------------------------------");
    }

    // Header for the sub-menu
    private void printSubHeder()
    {
        // Creating the header for our menu
        System.out.println("------------------------------");
        System.out.println("|        Filters Menu         |");
        System.out.println("------------------------------");
    }

    // Main menu options
    private void printMenu()
    {
        // Creating options for our menu
        System.out.println("\nPlease make a selection");
        System.out.println("1) Record an Event");
        System.out.println("2) Add Establishment");
        System.out.println("3) Filters");
        System.out.println("4) Print Events");
        System.out.println("5) Print Establishments");
        System.out.println("6) Exit the program");
    }

    // Sub menu options
    private void printSubMenu()
    {
        // Creating options for our menu
        System.out.println("\nPlease make a selection");
        System.out.println("1) Records by Establishment");
        System.out.println("2) Records by Date");
        System.out.println("3) Records by Name");
        System.out.println("4) Go Back");

    }

    // Method to run the main menu
    private void runMenu()
    {
        // Show the header
        printHeder();

        // Show the menu unless in exit state
        while (!exit)
        {
            printMenu();

            // Get the menu choice from the user
            int choice = getInput();

            performAction(choice);
        }
    }

    // Method to run the sub menu
    private void runSubMenu ()
    {
        // Show the header
        printSubHeder();

        // Show the menu unless in exit state
        while (!exit)
        {
            printSubMenu();;

            // Get the menu choice from the user
            int subChoice = getSubMenuInput();

            performSubMenuAction(subChoice);
        }
    }


    // Method to handle the input menu choice of the user
    private int getInput()
    {
        Scanner scan = new Scanner(System.in);

        // Set variable to a number that won't conflict with the numbers of our menu options
        int choice = -1;

        while(choice < 0 || choice > 6)
        {
            try
            {
                System.out.print("\nPlease enter your choice:");

                // Int isn't a string so have to wrap it in a parse
                choice = Integer.parseInt(scan.nextLine());
            }
            catch(NumberFormatException e)
            {
                // If the menu selection number isn't valid then print out an error and ask for another number
                System.out.println("Invalid Selection.  Please try again");
            }

        }

        return choice;

    }

    // Method to handle the input of the sub menu choice of the user
    private int getSubMenuInput()
    {
        Scanner scanSub = new Scanner(System.in);

        // Set variable to a number that won't conflict with the numbers of our menu options
        int subChoice = -1;

        while(subChoice < 0 || subChoice > 4)
        {
            try
            {
                System.out.print("\nPlease enter your choice:");

                // Int isn't a string so have to wrap it in a parse
                subChoice = Integer.parseInt(scanSub.nextLine());
            }
            catch(NumberFormatException e)
            {
                // If the menu selection number isn't valid then print out an error and ask for another number
                System.out.println("Invalid Selection.  Please try again");
            }

        }

        return subChoice;

    }

    // Method to do something with the menu choice
    private void performAction(int choice)
    {
        switch (choice)
        {
            case 1:
                // Record an Event
                break;
            case 2:
                // Add an establishment
                break;
            case 3:
                runSubMenu();
                break;
            case 4:
                // Prints Events
                break;
            case 5:
                // Prints Establishments
                break;
            case 6:
                exit = true;
                System.out.print("Goodbye");
                break;
            default:
                System.out.print("Error has occured");

        }
    }

    // Method to do something with the sub menu choice
    private void performSubMenuAction(int subChoice)
    {
        switch (subChoice)
        {
            case 1:
                // Records by Establishment
                break;
            case 2:
                // Records by date
                break;
            case 3:
                // Records by Name
                break;
            case 4:
                runMenu();
                break;
            default:
                System.out.print("Error has occured");

        }
    }


    public static void main(String[] args)
    {
        IO menu = new IO();
        menu.runMenu();

    }
}
