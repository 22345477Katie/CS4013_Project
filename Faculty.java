import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Faculty {
    // Basic faculty attributes
    private String title;
    private String name;
    private double salary;
    private String office;

    // Constructor to initialise a Faculty object
    public Faculty(String title, String name, double salary, String office) {
        this.title = title;
        this.name = name;
        this.salary = salary;
        this.office = office;
    }


    // Getters and setters for basic faculty information
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudentResults(String fileName, String moduleID){
        if (RecordSystem.getModules().hasKey(moduleID){
            Module module = RecordSystem.getModules().get(moduleID);
            module.setGrades(RecordSystem.setGrades(fileName));
        }else{
            System.out.println("Module with this ID does not exist");
        }
    }
}
