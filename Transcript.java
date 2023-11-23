import java.time.*;
import java.util.*;
public class Transcript{
    private double semesterQCA; //QCA for one semester
    private double sessionQCA; //QCA to date (may/may not include first year)
    private String transcriptOutputIntro; //student info
    private String transcriptOutputBody;//QCA info
    private Student s; //student object the transcript applies to
    private Semester[] sems = new Semester[10]; //an array of the semesters the student has completed;
    
    //Katie
    //Passes in student object
    public Transcript(Student student){
        s = student;
        sems = s.getSemesters();
    }
    
    //Katie
    //Calculates QCA based on a single semester
    public double calcSemesterQCA(Semester sem){
        ArrayList<Module> module = sem.getModules(s.getID);
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double QCA;
        for (int i=0; i<module.size(); i++){
            sumQCS = sumQCS + (module.get(i).getQPV()*module.get(i).getCredits()*sem.getFactor());
            sumAttHrs = sumAttHrs + (module.get(i).getCredits()*sem.getFactor());
            sumNonQHrs = sumNonQHrs + module.get(i).getNonQHrs();
        }
        
        QCA = sumQCS/(sumAttHrs-sumNonQHrs);
        return QCA;
    }
    
    //Katie
    //Retrieves details for each individual semester to be used in calculating session QCA
    public double[] getQCADetails(Semester sem){
        ArrayList<Module> module = sem.getModules(s.getID);
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double[] details = new double[3];
        for (int i=0; i<module.size(); i++){
            Module m= module.get(i);
            sumQCS = sumQCS + (m.getQPV()*m.getCredits()*sem.getFactor());
            sumAttHrs = sumAttHrs + (m.getCredits()*sem.getFactor());
            sumNonQHrs = sumNonQHrs + m.getNonQHrs();
        }
        details[0] = sumQCS;
        details[1] = sumAttHrs;
        details[2] = sumNonQHrs;
        return details;
    }
    
    public double[] getCumulativeQCADetails(){
        double[] details = new double[3];
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        for (int i = 0; i<sems.length; i++){
            sumQCS = sumQCS + getQCADetails(sems[i])[0];
            sumAttHrs = sumAttHrs + getQCADetails(sems[i])[1];
            sumNonQHrs = sumNonQHrs + getQCADetails(sems[i])[2];
        }
        details[0] = sumQCS;
        details[1] = sumAttHrs;
        details[2] = sumNonQHrs;
        return details;
    }
    //Katie
    //Calculates cumulative QCA (ie. total QCA up until this point), taking into account the fact that common entry courses do not count first year's QCA in the session count after 1st year
    public double calcCumulativeQCA(){
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double[] details = new double[3];
        double QCA;
        //need to make sure the student is not still in first year
        if(s.getProgram().getType()==true){ //&& s.getYear>1){ //common entry or not
            for(int j = 0; j<2; j++){
                details = getQCADetails(sems[j]);
                sumQCS = sumQCS + details[0];
                sumAttHrs = sumAttHrs + details[1];
                sumNonQHrs = sumNonQHrs + details[2];
            }
        }
        for(int i = 2; i<sems.length; i++){
             details = getQCADetails(s, sems[i]);
             sumQCS = sumQCS + details[0];
             sumAttHrs = sumAttHrs + details[1];
             sumNonQHrs = sumNonQHrs + details[2];
        }
        QCA = sumQCS/(sumAttHrs-sumNonQHrs);
        return QCA;
    }
    
    public String outputTranscript(){
        LocalDate date = LocalDate.now();
        transcriptOutputIntro = String.format("UNIVERSITY OF LIMERICK\n%t\n%dSTUDENT TRANSCRIPT\n%tNAME: %s %s\nADDRESS: %s\nTELEPHONE: %d\nSTATUS: %s\nPROGRAMME: %s - %s ", 
            date, s.getStudentNumber(), s.getTitle(), s.getName(), s.getAddress(), s.getPhone(), s.getStatus(), s.getProgramme(), s.getProgrammeCode()); 
        transcriptOutputBody = String.format("%-11s%-50s\n%-11s%-50s", "Program", s.getProgram(), "Program ID", s.getProgram().getProgramId());
        for (int i = 0; i<s.getSemesters().length(); i++){
            Semester sem = s.getSemester(i);
            
            transcriptOutputBody = transcriptOutputBody + String.format("%7s%13s%50s|%12s%-8%7\n", sem.getYear(), "SEM"+sem.getSemester(), "", "", "Session", "To-Date")+
                                    String.format("%80s|\n", "")+
                                    String.format("%-13s%-50s%-8s%-9s|%-12s%-8.3f\n", "Module", "Title", "Grade", "Credits", "Factor")+
                                    String.format("%80s|%-12s%-8.2f%-7.2\n", "", "Att Hrs", getQCADetails(sem)[1], getCumulativeQCADetails()[1]);
            for (int j = 0; j<s.getSemester(i).getModules(); j++){
                Module module = s.getSemester(i).getModule(i);
                transcriptOutputBody = transcriptOutputBody + String.format("%-13d%-50s%-8s%-9d|", module.getId(), module.getModuleName(), module.getGrade(s.getStudentId), module.getCredits());
                if (j==0){
                    transcriptOutputBody = transcriptOutputBody + String.format("%-12s%-8.2f%-7.2f\n", "Non-Q Hours", module.getNonQHrs(), getCumulativeQCADetails()[2]);
                }else if (j==1){
                    transcriptOutputBody = transcriptOutputBody + String.format("%-12s%-8.2f%-7.2f\n", "QCS", getQCADetails(sem)[0], getCumulativeQCADetails()[0]);
                }else if (j==2){
                    transcriptOutputBody = transcriptOutputBody + String.format("%-12s%-8.2f%-7.2f\n", "QCA", calcSemesterQCA(sem), calcCumulativeQCA());
                }
            }
        }
        return transcriptOutputIntro+transcriptOutputBody;
    }
}
