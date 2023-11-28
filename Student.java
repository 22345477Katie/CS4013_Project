import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    // Basic student attributes
    private final String name;
    private final String studentId;
    private final String dateOfBirth;
    private String address;
    //private final String programmeOfStudy;
    //private String department;
    private int currentSemester;
    private Transcript transcript;
    private int yearOfStudy;
    private String programID;
    private Program program;
    private Semester[] semesters;


    // Constructor to initialize a Student object
    public Student(String name, String studentId, String dateOfBirth,
                   String address, int yearOfStudy, String programID, int currentSemester,
                   //String programmeOfStudy, String department
                  ) {
        this.name = name;
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.transcript = new Transcript();
        this.yearOfStudy = yearOfStudy;
        this.programID = programID;
        this.programmeOfStudy = programmeOfStudy;
        this.department = department;
        this.currentSemester = currentSemester;
    }

    // Getters for basic student information
    String getStudent(){
        return Student;}

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getDOB() {
        return dateOfBirth;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getCurrentModules() {
        return chosenModules;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public Program getProgram() {
        return program;
    }

    // Setter method for updating the student's address
    public void setAddress(String address) {
        this.address = address;
    }

    // Setter method for updating the student's year of study
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    // Method to view the student's transcript
    public void viewTranscript() {
        transcript.outputTranscript();
    }

  

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public Semester[] getSemesters(){
        return semesters;
    }

    public Semester getSemester(int i){
        return semesters[i+1];    
    }
        

}
