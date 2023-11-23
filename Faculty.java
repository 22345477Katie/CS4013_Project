import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Faculty {
    // Basic faculty attributes
    private String title;
    private double salary;
    private String office;
    private final List<Student> students;
    private final List<String> facultyChoices;
    private List<String[]> gradeScaleArray;
    private List<String[]> resultsArray;  // Array to store results

    // Constructor to initialise a Faculty object
    public Faculty(String title, double salary, String office) {
        this.title = title;
        this.salary = salary;
        this.office = office;
        this.students = new ArrayList<>();
        this.facultyChoices = new ArrayList<>();
        this.resultsArray = new ArrayList<>();
        this.gradeScaleArray = new ArrayList<>();
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

    public List<String> getFacultyChoices() {
        return facultyChoices;
    }

    // Constructor to initialize Faculty with a GradeScale
    // Logic for submitting module results for a student from a CSV file
    public void readResultsFromCSV(String resultsCsvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(resultsCsvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the CSV line into an array
                String[] data = line.split(",");
                String studentId = data[0];
                String moduleId = data[1];
                String grade = data[2];

                // Store the result in the array
                String[] result = {studentId, moduleId, grade};
                resultsArray.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*/ Logic for passing grade scale through the command line interface
    public void readGradeScaleFromCommandLine(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Faculty <resultsCsvFilePath> <gradeScaleCsvFilePath>");
            System.exit(1);
        }

        String gradeScaleCsvFilePath = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(gradeScaleCsvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the CSV line into an array
                String[] grade = line.split(",");
                gradeScaleArray.add(grade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }/*
    }
