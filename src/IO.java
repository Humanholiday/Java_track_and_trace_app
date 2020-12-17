import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;


public class IO
{
    public static void main(String[] args) throws FileNotFoundException
    {


        try
        {
            String csvFile = "data/establishments.csv"; //moved the csv to this location within the project

            FileReader fileReader = new FileReader(csvFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());

            System.out.println(e.getStackTrace());
        }

        Establishment[] establishments = new Establishment[4];

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

                establishments[i] = new establishments(name, firstAddressLine, postcode, occupancy);
            }
        }
    }
}
