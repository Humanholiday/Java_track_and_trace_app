import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        System.out.println("1) Show users who have visited an establishment");
        System.out.println("2) Records by Date");
        System.out.println("3) Records by Name");
        System.out.println("4) Go Back");

    }

    // Method to run the main menu
    protected void runMenu()
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
                newEvent();
                break;
            case 2:
                // Record an establishment
                newEstablishment();
                break;
            case 3:
                runSubMenu();
                break;
            case 4:
               printEvents(ioController);
                break;
            case 5:
                printEstablishments(ioController);
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
    protected void performSubMenuAction(int subChoice)
    {
        switch (subChoice)
        {
            case 1:
                //Present a list of users who have visited a given establishment
                printUsersByEstablishment();
                break;
            case 2:
                // Records by date4
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

    //Print events method
    private void printEvents(Controller ioController)
    {
        // initialise an integer for numbering the list
        int i = 1;

        //save an arraylist of events objects using the controllers getEvents() method
        ArrayList<Event> events = ioController.getEvents();

        //loop through the events arraylist and for each event do this-
        for (Event event:events)
        {
            //print out a numbered displayEvent() string
            System.out.println(i + "." + "\n" + event.displayEvent() + "\n");

            // increment the integer
             i++;
        }
    }

    //Print establishments method
    private void printEstablishments(Controller ioController)
    {
        // initialise an integer for numbering the list
        int i = 1;

        //save an arraylist of establishment objects using the controllers method
        ArrayList<Establishment> establishments = ioController.getEstablishments();

        //loop through the events arraylist and for each event do this-
        for (Establishment establishment:establishments)
        {
            //print out a numbered displayEstablishment() string
            System.out.println(i + "." + "\n" + establishment.displayEstablishment() + "\n");

            // increment the integer
            i++;
        }

    }

    // Print users who have visited a given establishment
    private void printUsersByEstablishment()
    {

        Scanner in  = new Scanner(System.in);//Create a scanner object and pass System.in into the constructor.
                                             // this tells the scanner object to get its information from the console (System.in)

        //try and catch
        try
        {
            System.out.println("Enter establishment name:");// Print instruction for user
            String rawEstablishment = in.nextLine();// get the next line the user types and store in a variable
            String establishment = rawEstablishment.trim(); //trim whitespace from beginning and end of the string

            //pass the user entered establishment string and the ioController instance into the controllers filter method
            //save the returned collection of users in an ArrayList
            ArrayList<User> users = ioController.filterEventByEstablishment(establishment, ioController);

            // initialise an integer for numbering the list
            int i = 1;

            //if the ArrayList of users is not empty do this -
            if(!users.isEmpty())
            {
                //loop through the users in the arraylist and do this for each user
                for (User user : users) {

                    //print out a numbered displayUser() string
                    System.out.println(i + "." + "\n" + user.displayUser() + "\n");

                    // increment the integer
                    i++;
                }
            }

            // if the ArrayList of users is empty do this -
            else
            {
                //print this message
                System.out.println("There are no users saved for this establishment.");
            }
        }

        // for caught exceptions do this
        catch (Exception e)
        {
            System.out.println("\nInvalid entry, please start again -");
        }

    }

    protected void newEvent()
    {

        // Set up a new scanner to read the input from the console
        Scanner scanner = new Scanner(System.in);

        // Set up the variables to store the results of the user input
        String name = "";
        //String dob = "";
        LocalDate DateOfBirth = LocalDate.parse("1900-01-01");
        String email = "";
        String contactNumber = "";
        //Integer age = -1;         //Don't need to enter this as it is calculated?
        String eventDate = "";
        String eventTime = "";
        Integer partySize = -1;
        String establishmentName = "";
        String firstLineAdd = "";
        String postCode = "";
        Integer occ = -1;

        // Get the user name from user input
        System.out.println("Enter lead party member name: ");
        String user = scanner.nextLine();
        name = user;

        // Get the dob from user input
        //System.out.println("Enter dob in format yyyy-mm-dd: ");
        //String dateOfBirth = scanner.nextLine();
        //dob = dateOfBirth;
        //LocalDate localDateDOB = LocalDate.parse(dob);      // Convert the string dob to a local date

        // Get the dob from user input and validate dob is not in the future
        LocalDate dob = LocalDate.parse("2000-12-10");

        LocalDate today = LocalDate.now();

        System.out.println("Enter dob in format yyyy-mm-dd: ");

        do
        {


            if (scanner.hasNext())
            {
                dob = LocalDate.parse(scanner.nextLine());
            }

            if (dob.isAfter(today))
            {
                System.out.println("Date of birth is in the future, please re-enter date of birth");
            }
        }

        while (dob.isAfter(today));


        // Get the email address from user input and validate it contains an @
        System.out.println("Enter email address: ");

        String emailAdd = "";

        do
        {
            if (scanner.hasNext())
            {
                emailAdd = scanner.nextLine();
            }
            if (!emailAdd.contains("@"))
            {
                System.out.println("The email address should contain an @ character, please re-enter");
            }
        }
        while (!emailAdd.contains("@"));

        email = emailAdd;

        // Get the contact number from user input (with validation of an 11 digit number)
        System.out.println("Enter contact number: ");

        String tel = "";

        do
        {
            if (scanner.hasNext())
            {
                tel = scanner.nextLine();
            }
            if (tel.length() != 11)
            {
                System.out.println("The contact number must be 11 digits in length, please re-enter contact number");
            }
        }
        while (tel.length() != 11);

        contactNumber = tel;

        // Get the event date from user input
        System.out.println("Enter event date in format yyyy-mm-dd: ");
        String dateOfEvent = scanner.nextLine();
        eventDate = dateOfEvent;
        LocalDate localDateEventDate = LocalDate.parse(eventDate);   // Convert the string dob to a local date

        // Get the event time from user input
        System.out.println("Enter event time in format 00:00: ");
        String timeOfEvent = scanner.nextLine();
        eventTime = timeOfEvent;
        LocalTime localTimeOfEvent = LocalTime.parse(eventTime);

        // Get the establishment name from user input
        System.out.println("Enter Establishment Name: ");
        String estabName = scanner.nextLine();
        establishmentName = estabName;

        // Get the first line of the establishment address from user input
        System.out.println("Enter First Line Address: ");
        String firstLineAddress = scanner.nextLine();
        firstLineAdd = firstLineAddress;

        // Get the establishment postcode from user input
        System.out.println("Enter Postcode: ");
        String postcode = scanner.nextLine();
        postCode = postcode;

        // Get the occupancy of the establishment - this is an int - from user input
        System.out.println("Enter establishment occupancy: ");
        Integer occupancy = scanner.nextInt();
        occ = occupancy;

        // Get the party size - this is an int - from user input
        System.out.println("Enter party size: ");
        Integer sizeOfParty = scanner.nextInt();
        partySize = sizeOfParty;

        // Add variables to user constructor
        User newUser = new User(name, dob, email, contactNumber);

        // Add variables to establishment constructor
        Establishment newEstablishment = new Establishment(establishmentName, firstLineAdd, postCode, occ);

        // Add variables to event constructor
        Event newEvent = new Event (newUser, localDateEventDate, localTimeOfEvent, partySize, newEstablishment);

        // Create a new controller object and try to add the new establishment to the establishments.csv
        Controller controller = new Controller();
        try
        {
            controller.addEvent(newEvent);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // Message to the user to tell them that a new event has been added
        System.out.println("New event for " + name + " on " + dateOfEvent + " at " + establishmentName + " for " + partySize + " people has now been added");

    }

    protected void newEstablishment()
    {

        Scanner scanner = new Scanner(System.in);

        // Set up the variables to store the results of the establishment
        String establishmentName = "";
        String firstLineAdd = "";
        String postCode = "";
        Integer occ = -1;

        // Get the establishment name from user input
        System.out.println("Enter Establishment Name: ");
        String estabName = scanner.nextLine();
        establishmentName = estabName;

        // Get the first line of the establishment address from user input
        System.out.println("Enter First Line Address: ");
        String firstLineAddress = scanner.nextLine();
        firstLineAdd = firstLineAddress;

        // Get the establishment postcode from user input
        System.out.println("Enter Postcode: ");
        String postcode = scanner.nextLine();
        postCode = postcode;

        // Get the occupancy of the establishment - this is an int - from user input
        System.out.println("Enter establishment occupancy: ");
        Integer occupancy = scanner.nextInt();
        occ = occupancy;

        // Add variables to establishment constructor
        Establishment newEstablishment = new Establishment(establishmentName, firstLineAdd, postCode, occ);

        // Create a new controller object and try to add the new establishment to the establishments.csv
        Controller controller = new Controller();
        try
        {
            controller.addEstablishment(newEstablishment);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // Message to the user to tell them that a new event has been added
        System.out.println("New establishment, " + establishmentName + ", has been added");

    }


}
