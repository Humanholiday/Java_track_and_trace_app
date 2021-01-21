import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


//CONTROLLER CLASS IS FINAL
public final class Controller
{

//   ATTRIBUTES AND METHODS PRIVATE AND IMMUTABLE

        // Attributes
 private String csv;
    //ADDED AS A CLASS ATTRIBUTE SO CAN BE RE-USED.
    // ADDED GETPROP USER.DIR SO ABSOLUTE PATH IS DEFINED IF COMPILED AND RUN FROM TERMINAL ON ANOTHER USERS MACHINE
 private String estabCsv = System.getProperty("user.dir") + "/data/establishments.csv";
 private String eventCsv = System.getProperty("user.dir") + "/data/events.csv";

   // Constructors

    protected Controller(String establishmentCSVFileURI)
    {
        this.csv = establishmentCSVFileURI;
    }

    protected Controller(){}


    //methods



    // ADD ESTABLISHMENT TO THE LIST OF ESTABLISHMENTS, THROW IO EXCEPTIONS
    protected boolean addEstablishment(Establishment establishment) throws IOException {

        //ASSIGN FILENAME VARIABLE
//        String fileName = "data/establishments.csv";

        //IF THE notDuplicate METHOD RETURNS TRUE DO THIS
            if (notDuplicate(establishment.getName(), estabCsv)) {

                //CREATE FILEWRITER OBJECT WHICH INCLUDES FILE PATH AND SETS APPEND TO TRUE
                FileWriter csvWriter = new FileWriter(estabCsv, true);

                //ADD THE DETAILS OF THE ESTABLISHMENT TO THE CSV, FLUSH AND CLOSE THEN RETURN TRUE
                csvWriter.append(establishment.getName());
                csvWriter.append(",");
                csvWriter.append(establishment.getFirstLineAddress());
                csvWriter.append(",");
                csvWriter.append(establishment.getPostcode());
                csvWriter.append(",");
                csvWriter.append(establishment.getMaxOccupancy().toString());
                csvWriter.append("\n");


                csvWriter.flush();
                csvWriter.close();

                return true;
            }

            else{
                //IF notDuplicate IS FALSE RETURN FALSE
                return false;
        }
    }


    // ADD EVENT TO THE LIST OF EVENTS, THROW IO EXCEPTIONS
    protected boolean addEvent(Event event) throws IOException
    {
        //ASSIGN FILENAME VARIABLE
//        String fileName = "data/events.csv";

        //IF THE notDuplicate() METHOD RETURNS TRUE DO THIS
        if (notDuplicate(event.getEventID().toString(), eventCsv)) {

            //CREATE FILEWRITER OBJECT WHICH INCLUDES FILE PATH AND SETS APPEND TO TRUE
            FileWriter csvWriter = new FileWriter(eventCsv, true);

            //ADD THE DETAILS OF THE EVENT TO THE CSV, FLUSH AND CLOSE THEN RETURN TRUE
            csvWriter.append(event.getEventID().toString());
            csvWriter.append(",");
            csvWriter.append(event.getUser().getName());
            csvWriter.append(",");
            csvWriter.append(event.getUser().getDob().toString());
            csvWriter.append(",");
            csvWriter.append(event.getUser().getEmailAddress());
            csvWriter.append(",");
            csvWriter.append(event.getUser().getPhoneNumber());
            csvWriter.append(",");
            csvWriter.append(event.getUser().getAge().toString());
            csvWriter.append(",");
            csvWriter.append(event.getEventDate().toString());
            csvWriter.append(",");
            csvWriter.append(event.getEventTime().toString());
            csvWriter.append(",");
            csvWriter.append(event.getPartyNumber().toString());
            csvWriter.append(",");
            csvWriter.append(event.getEstablishment().getName());
            csvWriter.append(",");
            csvWriter.append(event.getEstablishment().getFirstLineAddress());
            csvWriter.append(",");
            csvWriter.append(event.getEstablishment().getPostcode());
            csvWriter.append(",");
            csvWriter.append(event.getEstablishment().getMaxOccupancy().toString());
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();

            return true;
        }

        else{
            //IF notDuplicate() RETURNS FALSE RETURN FALSE
            return false;
        }
    }

    //retrieve the establishments from the csv as eastablishment object
    protected ArrayList<Establishment> getEstablishments() {

            // CREATE STRING ARRAYLIST OBJECT OF THE CSV CONTENTS. USE LOADCSVFILE METHOD FORM THE FILELOADER CLASS
            ArrayList<String> csvText = FileLoader.loadCSVFile(estabCsv);

            //CHECK IF THE ARRAYLIST IS EMPTY
            assert csvText != null;

            //CREATE AN EMPTY ESTABLISHMENTS ARRAYLIST
            ArrayList<Establishment> establishments = new ArrayList<Establishment>();

            //LOOP THROUGH THE STRING ARRAYLIST
            for (String line : csvText) {

                //IF THE CURRENT LINE IS NOT NULL DO THIS, IF IT IS NULL DO NOT EXECUTE
                if (line != null) {
                    //SPLIT THE STRING INTO SEPARATE VALUES, SEPARATE BY COMMAS AND SAVE INTO A STRING ARRAY
                    String[] strings = line.split(",");

                    //ADD THE SEPARATED STRINGS TO VARIABLES, CONVERTING TYPE IF NECESSARY
                    String name = strings[0];
                    String firstAddressLine = strings[1];
                    String postcode = strings[2];
                    Integer occupancy = Integer.parseInt(strings[3]);

                    //CREATE ESTABLISHMENT OBJECT USING ABOVE VARIABLES
                    Establishment establishment = new Establishment(name, firstAddressLine, postcode, occupancy);

                    //ADD ESTABLISHMENT OBJECT TO THE ESTABLISHMENTS ARRAYLIST
                    establishments.add(establishment);
                }
            }
            //RETURN THE ESTABLISHMENTS ARRAYLIST
            return establishments;

    }

    //retrieve the events from the csv
        protected ArrayList<Event> getEvents() {

            // CREATE STRING ARRAYLIST OBJECT OF THE CSV CONTENTS. USE LOADCSVFILE METHOD FORM THE› FILELOADER CLASS
            ArrayList<String> csvText = FileLoader.loadCSVFile(eventCsv);

            //CHECK IF THE ARRAYLIST IS EMPTY
            assert csvText != null;

            //CREATE AN EMPTY EVENTS ARRAYLIST
            ArrayList<Event> events = new ArrayList<Event>();

            //LOOP THROUGH THE STRING ARRAYLIST
            for (String line : csvText) {

                //IF THE CURRENT LINE IS NOT NULL DO THIS, IF IT IS NULL DO NOT EXECUTE
                if (line != null) {
                    //SPLIT THE STRING INTO SEPARATE VALUES, SEPARATE BY COMMAS AND SAVE INTO A STRING ARRAY
                    String[] strings = line.split(",");

                    //ADD THE SEPARATED STRINGS TO VARIABLES, CONVERTING TYPE IF NECESSARY
                    String eventID = strings[0];
                    String username = strings[1];
                    LocalDate dob = LocalDate.parse(strings[2]);
                    String email = strings[3];
                    String contactNumber = strings[4];
                    Integer age = Integer.parseInt(strings[5]);
                    LocalDate eventDate = LocalDate.parse(strings[6]);
                    LocalTime eventTime = LocalTime.parse(strings[7]);
                    Integer partySize = Integer.parseInt(strings[8]);
                    String establishmentName = strings[9];
                    String firstLineAddress = strings[10];
                    String postcode = strings[11];
                    Integer maxOccupancy = Integer.parseInt(strings[12]);

                    //CREATE USER OBJECT
                    User user = new User(username, dob, email, contactNumber);
                    //CREATE ESTABLISHMENT OBJECT
                    Establishment establishment = new Establishment(establishmentName, firstLineAddress, postcode, maxOccupancy);
                    //CREATE EVENT OBJECT USING THE 2 OBJECTS ABOVE AND EVENT VARIABLES
                    Event event = new Event(user, eventDate, eventTime, partySize, establishment);
                    //ADD EVENT OBJECT TO EVENTS ARRAYLIST
                    events.add(event);
                }
            }
            //RETURN ARRAYLIST OF EVENTS
            return events;
        }

    //****** NEW - METHOD TO CHECK IF ENTERED ESTABLISHMENT/EVENT ALREADY EXISTS IN THE CSV FILE - JH

    private static boolean notDuplicate(String input, String filename) throws IOException {

        //CREATE STRING ARRAYLIST AND LOAD THE CSV FILE GIVEN BY THE FILENAME PARAMETER
        ArrayList<String> csvText = FileLoader.loadCSVFile(filename);

        // ASSERT THAT THE ARRAYLIST IS NOT EMPTY/NULL
        assert csvText != null;

        //LOOP THROUGH THE ARRAYLIST
        for (String line : csvText)
        {
            //IF THE CURRENT LINE IS NOT NULL DO THIS, IF IT IS NULL DO NOT EXECUTE
            if (line != null)
            {
                //SPLIT THE STRING INTO SEPARATE VALUES, SEPARATE BY COMMAS AND SAVE INTO A STRING ARRAY
                String[] values = line.split(",");

                //IF VALUES[0] (THE STORED EVENT ID) IS THE SAME AS THE NEW EVENT ID RETURN FALSE
                if (values[0].equalsIgnoreCase(input))
                {
                    return false;
                }
            }
        }
        // RETURN TRUE IF THE EVENT ID'S ARE DIFFERENT
        return true;
    }

    // method to take a user inputted establishment and return a collection of users who have visited that establishment
    protected ArrayList<User> filterEventByEstablishment(String estabName, Controller ioController)
    {
        //save an arraylist of all the saved event objects using the controllers getEvents() method
        ArrayList<Event> events = ioController.getEvents();

        //initialise an empty ArrayList of user objects
        ArrayList<User> users = new ArrayList<User>();

        // for each event in the events ArrayList do this -
        for (Event event:events)
        {
            //if the events establishment matches the user inputted establishment after ignoring case do this
            if(event.getEstablishment().getName().equalsIgnoreCase(estabName)) {

                //add the user to the users ArrayList
                users.add(event.getUser());

            }
        }

        //return the collection of users
        return users;
    }

    protected void filterEventByUserAndEmail(String name, String emailAdd)
    {
        try
        {
            //Read the csv file that contains the list of events
            ArrayList<Event> events = getEvents();

            for (Event event:events)  // for each event listed in the array
            {
                // if the event in the csv file matches the name and email address variable passed in, then use the displayEvent method in the Event class to output the event
                if(event.getUser().getName().equalsIgnoreCase(name) && event.getUser().getEmailAddress().equalsIgnoreCase(emailAdd))
                {
                    // Display the event
                    System.out.println(event.displayEvent());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }

    }

    protected void filterEventByDate(LocalDate date)
    {
        try
        {
            //Read the csv file that contains the list of events
            ArrayList<Event> events = getEvents();
            for (Event event:events)  // for each event listed in the array
            {
                //For some reason I can't get the date to pass into the if without creating a new variable
                LocalDate newDate = event.getEventDate();

                // if the event in the csv file matches the name and email address variable passed in, then use the displayEvent method in the Event class to output the event
                if(newDate.equals(date))
                {
                    // Display the event
                    System.out.println(event.displayEvent());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }

    }


}


