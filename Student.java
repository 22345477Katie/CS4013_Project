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
    private final String programmeOfStudy;
    private String department;
    private int currentSemester;
    private Transcript transcript;
    private int yearOfStudy;
    private Program program;
    public final List<Module> chosenModules;
    public final List<Module> currentModules;


    // Constructor to initialize a Student object
    public Student(String name, String studentId, String dateOfBirth,
                   String address, int yearOfStudy, Program program, int currentSemester,
                   String programmeOfStudy, String department) {
        this.name = name;
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.program = new Program();
        this.transcript = new Transcript();
        this.currentModules = new ArrayList<>();
        this.yearOfStudy = yearOfStudy;
        this.program = program;
        this.programmeOfStudy = programmeOfStudy;
        this.department = department;
        this.currentSemester = currentSemester;
        this.chosenModules = new ArrayList<>();
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

    // Method to view student choices
   /* public void viewStudentChoices() {
        System.out.println("Student Choices for " + getName() + " (Student ID: " + getStudentId() + "):");

        // Display enrolled classes or program details
        if (enrolledClasses.isEmpty()) {
            System.out.println("No enrolled classes.");
        } else {
            System.out.println("Enrolled Classes:");
            for (String enrolledClass : enrolledClasses) {
                System.out.println("- " + enrolledClass);
            }
        }
        // Display program details or additional choices
        // might need to modify based on specific data structure.
        Program program = getProgram();
        if (program != null) {
            System.out.println("Program: " + program.getProgramId() );
            System.out.println("Program Modules:");
            for (Module: program.getModules()) System.out.println("- " + module.getModuleId());
        } else {

            System.out.println("No program information available.");
        }
    }*/
    public List<Student> getStudentChoices(List<Module> availableModules) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Modules:");

        int count = 1;
        for (Module module : availableModules) {
            System.out.println(count + ". " + module.getName());
            count++;
        }

        System.out.println("Choose modules (enter module IDs, separated by commas):");
        String moduleChoicesInput = scanner.nextLine();

        String[] moduleIds = moduleChoicesInput.split(",");
        for (String moduleId : moduleIds) {
            int choice = Integer.parseInt(moduleId.trim()) - 1; // Adjust for 0-based indexing
            if (choice >= 0 && choice < availableModules.size()) {
                Module chosenModule = availableModules.get(choice);
                chosenModules.add(chosenModule);
                System.out.println("Chosen Module: " + chosenModule.getName());
            } else {
                System.out.println("Invalid module choice: " + moduleId);
            }
        }

        /*/ Method for handling repeat requests
        public void repeatRequests() {
            // Implementation for repeat requests
        }*/
        // Method for submitting results by a faculty member
        public void submitResults(Faculty faculty, List < ModuleResult > results){
            faculty.gradeSubmission(this, results);
        }

        // Method to calculate QCA
        public double calculateQCA () {
            return transcript.calculateQCA();
        }
        public void addModuleGrade (Module module, String grade){
            transcript.addModuleGrade(module, grade);
        }

        /*/ Method to check if the student meets the minimum academic standards for progression
        public boolean checkProgression () {
            // Implementation for checking progression
            return true;  // Placeholder value
        }*/

        // Method to read students from a CSV file
        public List<Student> readStudentsFromCSV (String fileName, Program program)List<Student> students;
        {
            students = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    Student student = new Student(data[0], Integer.parseInt(data[1]), data[2], data[3], Integer.parseInt(data[4]), program);
                    students.add(student);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
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


}
