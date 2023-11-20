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
    private int departmentId ;
    private boolean progression ; 
    private ArrayList<Program> programs ;
    
    //creating a department with a name and an id
    public Department (String departmentName, int departmentId){
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }

    //return id of department
    public int getDepartmentId(){
        return this.departmentId;
    }
    
    //return whether a student is progressing to the next year or not
    public boolean reviewProgression(double qca){
        if(qca >= 2.0){
            progression = true;
        } else {
            progression = false;
        }
        
        return progression;
    }
    
    //return whether a student is graduating or not
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
