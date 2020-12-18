import java.io.FileWriter;

public class Controller
{
    public static void main(String[] args)
    {
                // sample of Establishments to save in out CSV File
                Establishment[] Establishments = new Establishment[][3];
                Establishment[0] = new Establishment("Some Coffee House", "1 King Street", "FA1 3KE,", "5");
                Establishment[1] = new Establishment("Some Restaurant Place", "1 Queen Street", "FA2 3KE", "15");
                Establishment[2] = new Establishment("Some Book Place", "1 Regal Street", "FA4 3KE", "20");


                try
                {
                    FileWriter csvWriter = new FileWriter("data/Establishments.csv");

                    // create "header" row first
                    csvWriter.append("name");
                    csvWriter.append(",");               // comma separators
                    csvWriter.append("firstAddressLine");
                    csvWriter.append(",");
                    csvWriter.append("postcode");
                    csvWriter.append(",");
                    csvWriter.append("occupancy");
                    csvWriter.append("\n");             // new line character

                    // create a new line in the file for each Establishment

                    for (int i = 0; i < Establishments.length; i++)
                    {
                        Establishment Establishments = Establishment[i];

                        csvWriter.append(Establishments.getName());
                        csvWriter.append(",");
                        csvWriter.append(Establishments.getfirstLineAddress()); // UNSURE HOW TO PULL FIRST LINE
                        csvWriter.append(",");
                        csvWriter.append(Establishments.getpostCode()); // UNSURE HOW TO PULL POSTCODE
                        csvWriter.append(",");
                        csvWriter.append(Establishments.getMaxOccupancy());
                        csvWriter.append("\n");
                    }

                    csvWriter.flush();
                    csvWriter.close();

                }
                catch (Exception e)         // Catch ANY Exception
                {
                    System.out.println(e.getMessage());     // Print the Exception message
                    System.out.println(e.getStackTrace());  // Print the Stack Trace
                    System.exit(1);                         // (Optionally) Exit (with code 1 to indicate an error has occurred)
                }
            }
        }

    }
}
