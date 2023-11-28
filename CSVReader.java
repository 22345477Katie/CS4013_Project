import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) {
        String fileName = "Modules.csv"; // Replace with the actual file path

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into an array of values using a comma as the delimiter
                String[] values = line.split(",");

                // Process the values as needed
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Move to the next line for the next row
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
