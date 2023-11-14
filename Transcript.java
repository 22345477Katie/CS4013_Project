import java.time.*;
public class Transcript{
    private double semesterQCA;
    private double sessionQCA;
    private String transcriptOutputIntro;
    private String transcriptOutputBody;
    private Student student;
    
    public Transcript(Student student){
        this.student = student;
    }
    
    public double calcSemesterQCA(Student s, Semester sem){
        Module[] modules = sem.getModules();
        double sumQCS=0;
        double sumAttHrs=0;
        double sumNonQHrs=0;
        double QCA;
        for (int i=0; i<modules.length; i++){
            sumQCS = sumQCS + modules[i].getQCS;
            sumAttHrs = sumAttHrs + modules[i].getAttHrs;
            sumNonQHrs = sumNonQHrs + modules[i].getNonQHrs;
        }
        
        QCA = sumQCS/(sumAttHrs-sumNonQHrs);
    }
    
    public double calcCumulativeQCA(){
        
    }
    
    public String outputTranscript(){
        LocalDate date = LocalDate.now();
        transcriptOutputIntro = String.format("UNIVERSITY OF LIMERICK\n%t\n%dSTUDENT TRANSCRIPT\n%tNAME: %s %s\nADDRESS: %s\nTELEPHONE: %d\nSTATUS: %s\nPROGRAMME: %s - %s ", 
            date, student.getStudentNumber(), student.getTitle(), student.getName(), student.getAddress(), student.getPhone(), student.getStatus(), student.getProgramme(), student.getProgrammeCode()); 
        transcriptOutputBody = String.format("", );
        return transcriptOutputIntro+transcriptOutputBody;
    }
}
