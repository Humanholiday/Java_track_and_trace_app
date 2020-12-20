import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileLoader {

    public static ArrayList<String> loadCSVFile(String filename)
    {
        try
        {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String nextLine = bufferedReader.readLine();

            ArrayList<String> results = new ArrayList<>();

            while (nextLine != null)
            {
                nextLine = bufferedReader.readLine();
                results.add(nextLine);
            }
            return results;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
