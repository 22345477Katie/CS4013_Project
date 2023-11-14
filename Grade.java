public class Grade{
    private double mark;
    private double[] marks;
    private String assignmentGrade;
    private double weighting;
    private int[] gradeMarks;
    private String[] gradeTitles;
    private double totalWeighting = 0;
    //mark: percentage grade for the assessment
    //assignmentGrade: the corresponding letter grade to the mark
    //weighting: how much of the total module grade the assessment is worth
    //gradeMarks: an array of the percentage ranges for the grades, decided by the lecturer, listed in ascending order (ie. lowest grade range listed first)
    //gradeTitles: an array of the corresponding letter grades to gradeMarks, also in ascending order (ie. lowest grade listed first)
    //totalWeighting: addition of all weighting 

    //Katie 
    public Grade(double mark, double weighting, int[]gradeMarks, String[] gradeTitles){
        this.mark = mark;
        this.weighting = weighting;
        this.gradeMarks = gradeMarks;
        this.gradeTitles = gradeTitles;
        totalWeighting = totalWeighting + weighting;
        for (int i = gradeMarks.length;  i>=0; i--){
            if (mark>=gradeMarks[i]){
                this.assignmentGrade=gradeTitles[i];
            }
        }
        
        
    }
    
    //totalMark: final grade for the module
    //Katie - gets the total grade for the module and returns an error message if the sum of the weighting for each individual grade doesn't add up to 100
    public double getTotalGrade(double[] marks){
        double totalMark = 0;
        String totalGrade;
        if (totalWeighting!=100){
            System.out.println("Insufficient information provided: grades provided do not account for full module weighting");
            return 0;
            //might need error handling
        }
        for(int j=0; j<marks.length; j++){
            totalMark = totalMark + marks[j];
        }
        
        for (int i = gradeMarks.length;  i>=0; i--){
            if (totalMark>=gradeMarks[i]){
                totalGrade = gradeTitles[i];
            }
        }
    }
}
