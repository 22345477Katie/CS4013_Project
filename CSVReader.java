import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    private HashMap<String, Student> students;
    private HashMap<String, Module> modules;
    private HashMap<Integer, String> gradeScale;
    private HashMap<String, Integer> studentGrades;
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
    //each csv file line should be in the format: student number (String), name (String)/date of birth (String)/address (String)/year of study (int)/program id (String)/current semester (int)
        students = new HashMap<String, Student>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] studentsArray = firstLine.split(",");
                String studentID = studentsArray[0];
                String studentParameters = studentsArray[1].split("/");
                Student student = new Student (studentParameters[0], studentsArray[0], studentParameters[1],  studentParameters[2], Integer.parseInt(studentParameters[3]), studentParameters[4], Integer.parseInt(studentParameters[5]));
                students.put(studentsArray[1], student);
               }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
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
    //each csv file line should be in the format: moduleID (String), module name (String)/module credits (int)/module duration (in years) (int)/non Q Hours (int)/QPV (int),
       // (ctd.)(a list of descending marks and grades listed in pairs, mark first, with each corresponding mark and grade separated by a / and each mark-grade pair separated by a *) (eg. 90/A1*80/A2*75/A3...)
        modules = new HashMap<String, Module>();
        gradeScale = new HashMap<Integer, String>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                String moduleID = values[0];
                String[] moduleParameters = values[1].split("/");
                String[] markGradePairs = values[2].split("*");
                for (int i = 0; i<markGradePairs.length; i++){
                    String[] marksAndGrades = markGradePairs[i].split("/");
                    gradeScale.put(Integers.parseInt(marksAndGrades[0]), marksAndGrades[1]);
                }
                Module module = new Module(moduleParameters[0], values[0], Integer.parseInt(moduleParameters[1]), Integer.parseInt(moduleParameters[2]), Integer.parseInt(moduleParameters[3]), Integer.parseInt(moduleParameters[4]), gradeScale)
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }   
        return modules
    }

    public HashMap<String, Integer> setGrades(String fileName){
    //each csv file line should be in the format: student id (String), mark (int)
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                studentGrades = new HashMap<String, Integer>;
                studentGrades.put(values[0], Integer.parseInt(values[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return studentGrades;
    }
        
    public HashMap<String, Department> setDepartments(String fileName){
    //each csv file line should be in the format:
        
    }

    public HashMap<String, Faculty> setFaculty(String fileName){
        
    }
        
}
