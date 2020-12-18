import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Controller
{

    //Attributes

    //constructor


    //methods

    //add new establishemnts to csv

    public static void addEstablishment(Establishment establishment)
    {

        try {
            FileWriter csvWriter = new FileWriter("data/Establishments.csv");
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

        } catch (Exception e)         // Catch ANY Exception
        {
            System.out.println(e.getMessage());     // Print the Exception message
            System.out.println(e.getStackTrace());  // Print the Stack Trace
            System.exit(1);                         // (Optionally) Exit (with code 1 to indicate an error has occurred)
        }
    }

    //add new events to csv

    //retrieve the establishments from the csv as eastablishment object




    public Establishment[] getEstablishments ()
    {

    try
        {
            String csvFile = "data/establishments.csv"; //moved the csv to this location within the project

            FileReader fileReader = new FileReader(csvFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

            System.out.println(e.getStackTrace());
        }

            Establishment[] establishments = new Establishment[];

            for (int i = 0; i < establishments.length; i++)
            {
                nextLine = bufferedReader.readLine();

                if (nextLine != null)
                {
                    String[] strings = nextLine.split(",");

                    String name = strings[0];
                    String firstAddressLine = strings[1];
                    String postcode = strings[2];
                    String occupancy = strings[3];

                    //need to convert occupancy to an Integer before addding as parameter below

                    establishments[i] = new Establishment(name, firstAddressLine, postcode, occupancy);
                }
            }
        return establishments;
        }


    //retrieve the events from the csv
    public Event[] getEvent ()
    {

        try
        {
            String csvFile = "data/event.csv"; //moved the csv to this location within the project

            FileReader fileReader = new FileReader(csvFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

            System.out.println(e.getStackTrace());
        }

        Event[] event = new Event[];

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
}

