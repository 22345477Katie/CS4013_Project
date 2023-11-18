import java.util.Scanner;
import java.io.IOException;

public class Menu {
    private Scanner in;
    private Program program; 
    public Menu(Program program) {
        in = new Scanner(System.in);
        this.program = program;
    }

    public void run() throws IOException {
        boolean more = true;
        
        while (more) {
            System.out.println("(A) Add student  (B) Browse students  (G) Get QCA  E)xit");
            String command = in.nextLine().toUpperCase();

            if (command.equals("A")) {
                addStudent();
            } else if (command.equals("B")) {
                browseStudents();
            } else if (command.equals("C")) {
                getQCA();
            } else if (command.equals("E")) {
                more = false;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    private void addStudent() {
        System.out.println("Enter Student ID:");
        String studentId = in.nextLine();
        System.out.println("Enter Name:");
        String name = in.nextLine();
        
        Student newStudent = new Student(studentId, name); // we can add more funtions here add if so we will have to add more stuff in the space above.
        program.enrollStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private void browseStudents() {
       System.out.println("Enter Student ID to search:");
       String studentId = in.nextLine();
       Student foundStudent = /*menu*/program.findStudentById(studentId);
       if (foundStudent != null) {
          System.out.println("Student Name: " + foundStudent.getName());
       } else {
          System.out.println("No student found with ID: " + studentId);
       }
    }

    private void getQCA() {
        System.out.println("Enter Student ID:");
        String studentId = in.nextLine();
        Student student = /*menu*/program.findStudentById(studentId);
        if (student != null) {
           Semester currentSemester = getSemester(student);
           if (currentSemester != null) {
              Transcript transcript = student.getTranscript(); // we need a getTranscript class
              double qca = transcript.calcSemesterQCA(student, currentSemester);
              System.out.println("QCA for " + student.getName() + " in semester " + currentSemester.getSemester() + " is: " + qca);
           } else {
              System.out.println("Current semester information not available for student.");
           }
        } else {
           System.out.println("Student not found.");
        }
    }

    /*private Student findStudentById(String studentId) {
       for (Student student : program.getEnrolledStudents()) {
           if (student.getStudentId().equals(studentId)) {
              return student;
           }
       }
       return null;
    }*/
}
