import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileLoader {

    /*
     *  A method to load a CSV file and return an array of Strings to be processed later - JH
     */
    public static ArrayList<String> loadCSVFile(String filename)
    {
        try
        {
            // CREATE FILE LOADING OBJECTS
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //IGNORE FIRST LINE - GET FIRST LINE SO WHEN IT IS CALLED AGAIN THIS LINE IS SKIPPED
            String nextLine = bufferedReader.readLine();

            //CREATE ARRAYLIST OBJECT TO STORE RESULTS
            ArrayList<String> results = new ArrayList<>();

            //WHILE EACH LINE IS NOT NULL
            while (nextLine != null)
            {
                //ADD THE LINE TO THE RESULTS ARRAYLIST
                nextLine = bufferedReader.readLine();
                results.add(nextLine);
            }
            //WHEN ALL ADDED RETURN THE RESULTS
            return results;

        }
        // CATCH EXCEPTIONS IF THEY ARE THROWN
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
