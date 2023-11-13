import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
    // Attributes
    private String name;
    private String address;
    private String currentModules;
    private int dateOfBirth;
    private int yearOfStudy;
    private String programmeOfStudy;
    private String studentId;
    private String program;
    private String department;
    private int currentSemester;
    private Transcript transcript;

    // Constructor
    public Student(String studentId, String name, String address, String currentModules,
                   int dateOfBirth, int yearOfStudy, String programmeOfStudy,
                   String program, String department, int currentSemester) {
        // Initialise instance variables with values from the constructor
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.currentModules = currentModules;
        this.dateOfBirth = dateOfBirth;
        this.yearOfStudy = yearOfStudy;
        this.programmeOfStudy = programmeOfStudy;
        this.program = program;
        this.department = department;
        this.currentSemester = currentSemester;
        this.transcript = new Transcript();  // Initialize the transcript object
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getProgrammeOfStudy() {
        return programmeOfStudy;
    }

    public void setProgrammeOfStudy(String programmeOfStudy) {
        this.programmeOfStudy = programmeOfStudy;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
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

    // toString method for string representation of the object
    @Override
    public String toString() {
        return "Name: " + name +
                "\nAddress: " + address +
                "\nCurrent Modules: " + currentModules +
                "\nDate of Birth: " + dateOfBirth +
                "\nYear of Study: " + yearOfStudy +
                "\nProgramme of Study: " + programmeOfStudy +
                "\nStudent ID: " + studentId +    // Include additional attributes in the toString method
                "\nProgram: " + program +
                "\nDepartment: " + department +
                "\nCurrent Semester: " + currentSemester;

        // Additional methods
        public void addModuleGrade(Module module, String grade) {
            transcript.addModuleGrade(module, grade);
        }

        public double calculateQCA() {
            return transcript.calculateQCA();
        }

        public Map<String, String> viewTranscript() {
            return transcript.viewTranscript();
        }

        // Method to read module grades from a CSV file
        public void readModuleGradesFromCSV(String csvFilePath) {
            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                String[] headers = reader.readNext(); // Skip header line

                // Read each line of the CSV file and add module grades
                String[] gradeData;
                while ((gradeData = reader.readNext()) != null) {
                    String moduleId = gradeData[0];
                    String grade = gradeData[1];

                    Module module = new Module(moduleId, "Module Name", 3, 1); // *Replace with actual module details*

                    // Add module grade to the transcript
                    addModuleGrade(module, grade);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Static method to create a list of students from a CSV file
        public static List<Student> createStudentsFromCSV(String csvFilePath) {
            // Create an empty list to store Student objects
            List<Student> students = new ArrayList<>();

            // Using try-with to handle file reading
            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                String[] headers = reader.readNext(); // Skip header line

                // Read each line of the CSV file and create Student objects
                String[] studentData;
                while ((studentData = reader.readNext()) != null) {
                    // Extract data from the CSV line
                    String studentId = studentData[0];
                    String name = studentData[1];
                    String address = studentData[2];
                    String currentModules = studentData[3];
                    int dateOfBirth = Integer.parseInt(studentData[4]);
                    int yearOfStudy = Integer.parseInt(studentData[5]);
                    String programmeOfStudy = studentData[6];
                    String program = studentData[7];
                    String department = studentData[8];
                    int currentSemester = Integer.parseInt(studentData[9]);

                    // Create a new Student object and add it to the list
                    students.add(new Student(studentId, name, address, currentModules,
                            dateOfBirth, yearOfStudy, programmeOfStudy,
                            program, department, currentSemester));
                }
            } catch (IOException | NumberFormatException e) {
                // Handle potential exceptions
                e.printStackTrace();
            }

            // Return the list of created Student objects
            return students;
        }