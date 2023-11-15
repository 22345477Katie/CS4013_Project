import java.util.*;
public class Program {
    private String programId;
    private String name;
    private String level;
    private int duration;
    private List<Student> enrolledStudents;
    
    public Program(String programId, String name, String level, int duration) {
        this.programId = programId;
        this.name = name;
        this.level = level;
        this.duration = duration;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public String getProgramId() {
        return programId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLevel() {
        return level;
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
    
    public void submitResults(Faculty faculty, Module module, List<StudentResult> results) {
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
    }
    
    public Map<String, String> viewTranscript() {
            return transcript.viewTranscript();
        }
}
