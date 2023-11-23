import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName ;
    private String studentsResults ;
    private boolean progression ; 
    private ArrayList<Program> programs ;
    
    //creating a department with a name 
    public Department (String fileName){
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] departmentName = line.split(",");
                this.departmentName = departmentName[0];
                line = br.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //return id of department
    public int getDepartmentId(){
        return this.departmentId;
    }
    
    //return whether a student is progressing to the next year or not
    public boolean reviewProgression(String studentId){
        //get qca via if studentId 
        //records system class will have a hash map <StudentID, StudentObject>
        //check if String studentId is on HashMap
        //if it is, get the value associated with that student key (the student object)
        //then use that to get the qca :)
        if(qca >= 2.0){
            progression = true;
        } else {
            progression = false;
        }
        
        return progression;
    }
    
     //list of programs in department

    private static ArrayList<Program> programsInDepartment(String fileName){
        ArrayList<Program> programs = new ArrayList<Program>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String firstLine = br.readLine();
            while (firstLine != null){
                String[] namesOfPrograms = firstLine.split(",");
                programs.add(namesOfPrograms);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return programs;

    }
}
