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
    private String credits;
    private String duration;
    private String moduleName;
    private int[] gradeMarks;
    private String[] gradeTitles;
    private String nonQHrs;
    private String QPV;
    private HashMap<String, String> gradingScale;
    private ArrayList<String> grades = new ArrayList<String>();
    private ArrayList<Integer> scale = new ArrayList<Integer>();
    private HashMap<Student, String> studentsGrades;

    //Sophie
    //assumption that csv file will be formatted as:
    //moduleName, moduleId, moduleCreditsWorth, moduleDurationInYears, nonQHrsOfModule, QPVForModule
    public Module(String moduleName, String moduleId, String credits, String duration, HashMap<String, String> gradindScale, HashMap<Student, String> studentsGrades){
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.credits = credits;
        this.duration = duration; 
        this.gradingScale = gradingScale;
        this.studentsGrades = studentsGrades;
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
    public String getCredits(){
        return this.credits;
    }

    //Katie
    public String getNonQHrs(){
        return nonQHrs;
    }

    //Katie
    public String getQPV(){
        return QPV;
    }
    
    public HashMap<Student, String> getStudentGrades(){
        return studentsGrades;
    }
    
    public HashMap<String, String> getGradingScale(){
        return gradingScale;
    }
}

    
    
