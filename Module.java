import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;

public class Module {
    private String moduleId ;
    private String grade;
    private String semester;
    private int credits;
    private String duration;
    private String moduleName;
    private int[] gradeMarks;
    private String[] gradeTitles;
    private double nonQHrs;
    private double QPV;
    private HashMap<String, String> gradingScale;
    private ArrayList<String> grades = new ArrayList<String>();
    private ArrayList<Integer> scale = new ArrayList<Integer>();
    private HashMap<String, Integer> studentsGrades;

    //Sophie
    //assumption that csv file will be formatted as:
    //moduleName, moduleId, moduleCreditsWorth, moduleDurationInYears, nonQHrsOfModule, QPVForModule
    public Module(String moduleName, String moduleId, int credits, String duration, double nonQHrs, double QPV, HashMap<Integer, String> gradingScale){
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.credits = credits;
        this.duration = duration; 
        this.nonQHrs = nonQHrs;
        this.QPV = QPV;
        this.gradingScale = gradingScale;
    }
    
    //Sophie
    public String getModuleName(){
        return this.moduleName;
    }

    //Sophie
    public String getModuleId(){
        return this.moduleId;
    }

    //Sophie
    public String getDuration(){
        return this.duration;
    }

    //Sophie
    public int getCredits(){
        return this.credits;
    }

    //Katie
    public double getNonQHrs(){
        return nonQHrs;
    }

    //Katie
    public double getQPV(){
        return QPV;
    }
    
    public HashMap<Integer, String> getGradingScale(){
        return gradingScale;
    }

    public void setStudentMarks(HashMap<String, Integer> marks){
        studentMarks = marks;
    }

    public HashMap<String, Integer> getStudentMarks(){
        return studentMarks;
    }

    public String getStudentGrade(String studentID){
        int mark = studentMarks.get(studentID);
        String grade;
        for (Map.Entry<String, String> entry : map.entrySet()) {
             int threshold = entry.getKey();
             if (mark>=threshold){
                grade = entry.getValue();
                 return grade;
             }    
        }
    }
}

    
    
