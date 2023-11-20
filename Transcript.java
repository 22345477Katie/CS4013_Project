import java.time.*;
public class Transcript{
    private double semesterQCA; //QCA for one semester
    private double sessionQCA; //QCA to date (may/may not include first year)
    private String transcriptOutputIntro; //student info
    private String transcriptOutputBody; //QCA info
    private Student s; //student object the transcript applies to
    private Semester[] sems; //array of all completed semesters by the student 
    
    //Katie
    //Passes in student object
    public Transcript(Student student){
        s = student;
    }
    
    //Katie
    //Calculates QCA based on a single semester
    public double calcSemesterQCA(Semester sem){
        ArrayList<Module> module = sem.getModules();
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double QCA;
        for (int i=0; i<modules.length; i++){
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
        ArrayList<Module> module = sem.getModules();
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double[] details = new double[3];
        for (int i=0; i<modules.length; i++){
            sumQCS = sumQCS + (module.get(i).getQPV()*module.get(i).getCredits()*sem.getFactor());
            sumAttHrs = sumAttHrs + (module.get(i).getCredits()*sem.getFactor());
            sumNonQHrs = sumNonQHrs + module.get(i).getNonQHrs();
        }
        details[0] = sumQCS;
        details[1] = sumAttHrs;
        details[2] = sumNonQHrs;
        return details;
    }
    
    //Katie
    //Calculates session QCA (ie. total QCA up until this point), taking into account the fact that common entry courses do not count first year's QCA in the session count after 1st year
    public double calcCumulativeQCA(Semester[] sems){
        double sumQCS = 0;
        double sumAttHrs = 0;
        double sumNonQHrs = 0;
        double[] details = new double[3];
        double QCA;
        //need to make sure the student is not still in first year
        if(s.getProgram().getType()==true){ //&& s.getYear>1){ //common entry or not
            for(int j = 0; j<2; j++){
                details = getQCADetails(s, sems[i]);
                sumQCS = sumQCS + details[0];
                sumAttHrs = sumHrs + details[1];
                sumNonQHrs = sumNonQHrs + details[2];
            }
        }
        for(int i = 2; i<sems.length(); i++){
             details = getQCADetails(s, sems[i]);
             sumQCS = sumQCS + details[0];
             sumAttHrs = sumHrs + details[1];
             sumNonQHrs = sumNonQHrs + details[2];
        }
        QCA = sumQCS/(sumAttHrs-sumNonQHrs);
        return QCA;
    }
    
    public String outputTranscript(){
        LocalDate date = LocalDate.now();
        transcriptOutputIntro = String.format("UNIVERSITY OF LIMERICK\n%t\n%dSTUDENT TRANSCRIPT\n%tNAME: %s %s\nADDRESS: %s\nTELEPHONE: %d\nSTATUS: %s\nPROGRAMME: %s - %s ", 
            date, student.getStudentNumber(), student.getTitle(), student.getName(), student.getAddress(), student.getPhone(), student.getStatus(), student.getProgramme(), student.getProgrammeCode()); 
        transcriptOutputBody = String.format("", );
        return transcriptOutputIntro+transcriptOutputBody;
    }
}
