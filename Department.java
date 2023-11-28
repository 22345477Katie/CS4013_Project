import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Department {
    private String departmentName ;
    private String studentsResults ;
    private boolean progression ; 
    private ArrayList<Program> programs ;
    
    //creating a department with a name 
    public Department (String departmentName, //program list?){
        this.departmentName = departmentName;
    }

    //SOPHIE THIS IS THE NEW METHOD FOR ADDING PROGRAMS - THE ARRAYLIST WAS ALREADY IN HERE SO IM PRESUMING YOU DIDNT GET RID OF IT
    public void addProgram(Program program){
        programs.add(program);
    }
    
    //return whether a student is progressing to the next year or not
    public boolean reviewProgression(String studentId){
        //get qca via if studentId 
        //records system class will have a hash map <StudentID, StudentObject>
        //check if String studentId is on HashMap
        //if it is, get the value associated with that student key (the student object)
        //then use that to get the qca :)
        double qca;
        
        HashMap<String, Student> students = RecordsSystem.getStudents();
        
        if(students.containsKey(studentId) == true){
            qca = (students.get(studentId).getQCA());
        } else {
            System.out.println("Error: student not found. Please input a valid student ID");
        }
        
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
            String line = br.readLine();
            while (line != null){
                String[] namesOfPrograms = line.split(",");
                programs.add(namesOfPrograms);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return programs;

    }
}
