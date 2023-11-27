import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Program {
    private String programId;
    private String name;
    private int duration;
    private List<Student> enrolledStudents;
    private boolean commonEntry;
    private Transcript transcript;
    private ArrayList<Module> programs;
    
    public Program(String programId, String name, boolean commonEntry, int duration) {
        this.programId = programId;
        this.name = name;
        this.commonEntry = commonEntry;
        this.duration = duration;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public String getProgramId() {
        return programId;
    }
    
    public String getName() {
        return name;
    }

    public boolean getCommonEntry(){
        return commonEntry;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    
    public Map<String, String> viewTranscript() {
            return transcript.viewTranscript();
        }
    
    public Student findStudentById(String studentId) {
        for (Student student : enrolledStudents) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

     public static ArrayList<Module> modulesInProgram(String fileName){
        this.programs = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String Line = br.readLine();
            while (Line != null){
                String[] namesOfModules = firstLine.split(",");
                //need to add module details
                programs.add(namesOfModules);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return programs;

    }

    public ArrayList<Module> getModules(){
        return programs;
    }
}


/*  public void submitResults(Faculty faculty, Module module, List<StudentResult> results) {
        if (faculty.teachesModule(module)) {
            for (StudentResult result : results) {
                Student student = result.getStudent();
                module.addResult(result); 
                student.addResult(result); 
            }
        } else {
            System.out.println("Faculty does not teach this module.");
        }
    }
    
    public void calcProgramProgression(Student student, Transcript currentQCA) {
        if (currentQCA.calcSemesterQCA >= 2.00) {
            System.out.println(student.getName() + " is eligible for program progression.");
        } else {
            System.out.println(student.getName() + " does not meet the minimum academic standards for progression.");
        }
    }*/
