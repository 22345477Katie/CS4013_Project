import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    private HashMap<String, Student> students;
    private HashMap<String, Module> modules;
    public static void main(String[] args) {

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

    /*try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Move to the next line for the next row
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

    public HashMap<String, Student> setStudents(String fileName){
    //csv file should be in the format: student number,name/student id/date of birth/address/year of study (int)/program id/current semester (int)
        students = new HashMap<String, Student>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] studentsArray = firstLine.split(",");
                String studentID = studentsArray[1];
                String studentParameters = studentsArray[2].split("/");
                Student student = new Student (studentParameters[0], studentParameters[1], studentParameters[2],  studentParameters[3], Integer.parseInt(studentParameters[4]), studentParameters[5], Integer.parseInt(studentParameters[6]));
                students.put(studentsArray[1], student);
               }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Program> setPrograms(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Module> setModules(String fileName){
    //csv file should be in the format: moduleID, module name/
        modules = new HashMap<String, Module>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                String moduleID = values[0];
                String[] moduleParameters = values[1].split("/");
                Module module = new Module(
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }   
    }

    public HashMap<String, Integer> setGrades(
        
    
        
}
