import java.util.Scanner;
import java.io.IOException;

private Scanner in;
public class Menu {
        in = new Scanner(System.in);
    }

    public void run() throws IOException {
        boolean more = true;
        
        while (more) {
            System.out.println("Please choose user type: (F)aculty    (S)tudent    (D)epartment    (Q)uit)");
            String command = in.nextLine().toUpperCase();
            if (command.equals("F")){
                System.out.println("(V)iew Student Transcript    (S)ubmit module results    (Q)uit");
                if (command.equals("V")){
                    System.out.println("Please provide relevant student ID number");
                    String studentID = in.nextLine();
                    if 
                    //look up transcripts, submit module results, 
                }else if (command.equals("S")){
                    
                }else if (command.equals("Q")){
                    more = false;
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if(command.equals("S)){
                System.out.println("Please enter your student number"){
                    String indivStudentID = in.nextLine();
                    if 
                System.out.println("(V)iew Transcript    (Q)uit");
                if (command.equals("V")){
                    
                }else if (command.equals("V")){
                }else{
                    System.out.println("Invalid command");
                //review own transcript, 
            }
            else if (command.equals("D")){
                System.out.println((H)old review board    (Q)uit);
                
            }
            else if (command.equals("Q")){
                more = false;
            }
            else {
                System.out.println("Invalid command");
            }
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
       Student foundStudent = program.findStudentById(studentId);
       if (foundStudent != null) {
          System.out.println("Student Name: " + foundStudent.getName());
       } else {
          System.out.println("No student found with ID: " + studentId);
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
