import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public final class Controller {

//     DO WE NEED TO MAKE THIS CLASS, ATTRIBUTES AND METHODS PRIVATE AND IMMUTABLE (FINAL)? - JH

        // Attributes

 private String CSV;

   // Constructors

    protected Controller(String establishmentCSVFileURI)
    {
        this.CSV = establishmentCSVFileURI;
    }

    protected Controller(){}

    //methods

    //add new establishment to csv

    protected boolean addEstablishment(Establishment establishment) throws IOException {

        String fileName = "data/establishments.csv";


            if (notDuplicate(establishment.getName(), fileName)) {

                FileWriter csvWriter = new FileWriter(fileName, true);


                csvWriter.append(establishment.getName());
                csvWriter.append(",");
                csvWriter.append(establishment.getFirstLineAddress()); // UNSURE HOW TO PULL FIRST LINE
                csvWriter.append(",");
                csvWriter.append(establishment.getPostcode()); // UNSURE HOW TO PULL POSTCODE
                csvWriter.append(",");
                csvWriter.append(establishment.getMaxOccupancy().toString());
                csvWriter.append("\n");


                csvWriter.flush();
                csvWriter.close();

                return true;
            }

            else{
                return false;
        }
    }


    protected boolean addEvent(Event event) throws IOException

    {
        String fileName = "data/events.csv";

        if (notDuplicate(event.getEventID().toString(), fileName)) {

            FileWriter csvWriter = new FileWriter(fileName, true);

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
            csvWriter.append(event.getEventDate());
            csvWriter.append(",");
            csvWriter.append(event.getEventTime().toString());
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
            return false;
        }
    }

    //retrieve the establishments from the csv as eastablishment object

    protected ArrayList<Establishment> getEstablishments() {

        ArrayList<String> csvText = FileLoader.loadCSVFile("data/establishments.csv");

        assert csvText != null;

        ArrayList<Establishment> establishments = new ArrayList<Establishment>();

        for (String line : csvText) {

            if (line != null) {
                String[] strings = line.split(",");

                String name = strings[0];
                String firstAddressLine = strings[1];
                String postcode = strings[2];
                Integer occupancy = Integer.parseInt(strings[3]);

                //need to convert occupancy to an Integer before addding as parameter below

                Establishment establishment = new Establishment(name, firstAddressLine, postcode, occupancy);

                establishments.add(establishment);
            }
        }
        return establishments;
    }

    //retrieve the events from the csv
        protected ArrayList<Event> getEvent() {

            ArrayList<String> csvText = FileLoader.loadCSVFile("data/events.csv");

            assert csvText != null;

            ArrayList<Event> events = new ArrayList<Event>();

            for (String line : csvText) {

                if (line != null) {
                    String[] strings = line.split(",");

                    String eventID = strings[0];
                    String username = strings[1];
                    LocalDate dob = LocalDate.parse(strings[2], User.formatter); //
                    String email = strings[3];
                    String contactNumber = strings[4];
                    Integer age = Integer.parseInt(strings[5]);
                    LocalDate eventDate = LocalDate.parse(strings[6], User.formatter);
                    LocalTime eventTime = LocalTime.parse(strings[7]);
                    Integer partySize = Integer.parseInt(strings[8]);
                    String establishmentName = strings[9];
                    String firstLineAddress = strings[10];
                    String postcode = strings[11];
                    Integer maxOccupancy = Integer.parseInt(strings[12]);

                    User user = new User(username, dob, email, contactNumber);
                    Establishment establishment = new Establishment(establishmentName, firstLineAddress, postcode, maxOccupancy);
                    Event event = new Event(user, eventDate, eventTime, partySize, establishment);
                    events.add(event);
                }
            }
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
}


