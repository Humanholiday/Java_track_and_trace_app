import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //Attributes

    //constructor


    //methods

    //add new establishemnts to csv

    public static boolean addEstablishment(Establishment establishment) throws IOException {

        String fileName = "data/establishments.csv";

//        try {
            if (notDuplicate(establishment.getName(), fileName)) {

                FileWriter csvWriter = new FileWriter(fileName, true);
//
//            // create "header" row first
//            csvWriter.append("name");
//            csvWriter.append(",");               // comma separators
//            csvWriter.append("firstAddressLine");
//            csvWriter.append(",");
//            csvWriter.append("postcode");
//            csvWriter.append(",");
//            csvWriter.append("occupancy");
//            csvWriter.append("\n");             // new line character

                // create a new line in the file for each Establishment

//            for (int i = 0; i < Establishments.length; i++) {
//                Establishment Establishments = Establishment[i];

                csvWriter.append(establishment.getName());
                csvWriter.append(",");
                csvWriter.append(establishment.getFirstLineAddress()); // UNSURE HOW TO PULL FIRST LINE
                csvWriter.append(",");
                csvWriter.append(establishment.getPostcode()); // UNSURE HOW TO PULL POSTCODE
                csvWriter.append(",");
                csvWriter.append(establishment.getMaxOccupancy().toString());
                csvWriter.append("\n");
//            }

                csvWriter.flush();
                csvWriter.close();

//            catch(Exception e)         // Catch ANY Exception
//                {
//                    System.out.println(e.getMessage());     // Print the Exception message
//                    System.out.println(e.getStackTrace());  // Print the Stack Trace
//                    System.exit(1);                         // (Optionally) Exit (with code 1 to indicate an error has occurred)
//                }
                return true;
            }

            else{
                return false;
        }
    }

    //add new events to csv

    //retrieve the establishments from the csv as eastablishment object


    public static void getEstablishments() {

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
    }

    //retrieve the events from the csv
//    public Event[] getEvent() {
//
//        try {
//            String csvFile = "data/event.csv"; //moved the csv to this location within the project
//
//            FileReader fileReader = new FileReader(csvFile);
//
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//            System.out.println(e.getStackTrace());
//        }
//
//        Event[] event = new Event[];

//        for (int i = 0; i < event.length; i++)
//        {
//            nextLine = bufferedReader.readLine();
//
//            if (nextLine != null)
//            {
//                String[] strings = nextLine.split(",");
//
//                String name = strings[0];
//                String firstAddressLine = strings[1];
//                String postcode = strings[2];
//                String occupancy = strings[3];
//
//                //need to convert occupancy to an Integer before addding as parameter below
//
//                event[i] = new Event();
//            }
//        }
//        return event;
//    }

    //****** NEW - METHOD TO CHECK IF ENTERED ESTABLISHMENT/EVENT ALREADY EXISTS IN THE CSV FILE

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



