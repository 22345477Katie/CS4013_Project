import java.util.Scanner;
import java.io.IOException;

public class Menu {
    private Scanner in;
    private RecordSystem recordSystem; // Assuming RecordSystem is a class you have
    private Program program; // Assuming Program is a class you have

    public Menu() {
        in = new Scanner(System.in);
        recordSystem = new RecordSystem(); // Initialize RecordSystem
        program = new Program(); // Initialize Program
    }

    public void run() throws IOException {
        boolean more = true;

        while (more) {
            System.out.println("Please choose user type: (F)aculty (S)tudent (D)epartment (Q)uit)");
            String command = in.nextLine().toUpperCase();

            if (command.equals("F")) {
                // Faculty
                System.out.println("(V)iew Student Transcript (P)rovide module results (Q)uit");
                command = in.nextLine().toUpperCase();
                if (command.equals("V")) {
                    // View Student Transcript
                } else if (command.equals("P")) {
                    // Provide Module Results
                } else if (command.equals("Q")) {
                    more = false;
                } else {
                    System.out.println("Invalid command");
                }
            } else if (command.equals("S")) {
                // Student
                System.out.println("Please enter your student number");
                String indivStudentID = in.nextLine();
                if (recordSystem.getStudents().hasKey(indivStudentID)) {
                    Student s = recordSystem.getStudents().get(indivStudentID);
                    System.out.println("(T)ranscript (Q)uit");
                    command = in.nextLine().toUpperCase();
                    if (command.equals("T")) {
                        s.getTranscript().initialise(s);
                        s.getTranscript().outputTranscript();
                    } else if (command.equals("Q")) {
                        more = false;
                    } else {
                        System.out.println("Invalid command");
                    }
                } else {
                    System.out.println("Invalid student ID number provided");
                }
            } else if (command.equals("D")) {
                // Department
                System.out.println("(H)old review board (Q)uit");
                command = in.nextLine().toUpperCase();
                if (command.equals("H")) {
                    // Hold Review Board
                } else if (command.equals("Q")) {
                    more = false;
                } else {
                    System.out.println("Invalid command");
                }
            } else if (command.equals("Q")) {
                more = false;
            } else {
                System.out.println("Invalid command");
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
       Student foundStudent = program.findStudentById(studentId);
       if (foundStudent != null) {
          System.out.println("Student Name: " + foundStudent.getName());
       } else {
          System.out.println("No student found with ID: " + studentId);
        }
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.run();
    }
}


















                
 /*   private void getQCA() {
        System.out.println("Enter Student ID:");
        String studentId = in.nextLine();
        Student student = program.findStudentById(studentId);
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
    }*/

    /*private Student findStudentById(String studentId) {
       for (Student student : program.getEnrolledStudents()) {
           if (student.getStudentId().equals(studentId)) {
              return student;
           }
       }
       return null;
    }*/
}
