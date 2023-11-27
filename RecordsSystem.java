import java.io.IOException;
import java.util.*;
public class RecordsSystem{
    private HashMap<String, Students> students;
    public static void main(String args[])
    throws IOException
    {
      Menu menu = new Menu();
      menu.run();
    }

    public static HashMap<String, Student> setStudents(String fileName){
        this.students = new HashMap<String, Student>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String Line = br.readLine();
            while (Line != null){
                String[] studentsArray = firstLine.split(",");
                String studentID = studentsArray[1];
                String studentDetails = studentsArray[2].split("/")
//must put a / separating every student detail in the csv file
                Student student = new Student (studentDetails[0], studentDetails[1], studentDetails[2], Integer.parseInt(studentDetails[3]),  studentDetails[4], Integer.parseInt(studentDetails[5])); 
                //studentDetails[4] is a program object, will we need to put all details of the program into it?
                students.put(studentsArray[1], student);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return students;
    }

    public HashMap<String, Student> getStudents(){
        return students;
    }
}
