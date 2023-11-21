public class Module {
    private int moduleId ;
    private String grade;
    private int semester;
    private int credits;
    private int duration;
    private String moduleName;
    private int[] gradeMarks;
    private String[] gradeTitles;
    private double nonQHrs;
    private double QPV;
    private ArrayList<Grade> grades;
    private HashMap<Student, ArrayList<Grade>> resultsOfAssignments;

    //Sophie
    public Module(String moduleName,int moduleId, int credits, int duration, int[] gradeMarks, String[] gradeTitles, double nonQHrs, double QPV){
        this.moduleId = moduleId;
        this.credits = credits;
        this.duration = duration;
        this.moduleName = moduleName;
        this.gradeMarks = gradeMarks;
        this.gradeTitles = gradeTitles;
        this.nonQHrs = nonQHrs;
        this.QPV = QPV;
        
    }

    //Sophie
    public String getModuleName(){
        return this.moduleName;
    }

    //Sophie
    public int getModuleId(){
        return this.moduleId;
    }

    //Sophie
    public int getDuration(){
        return this.duration;
    }

    //Sophie
    public int getCredits(){
        return this.credits;
    }

    //Katie
    public double getQPV(){
        return QPV;
    }

    private static ArrayList<Program> gradesForAssignment(String fileName){
        ArrayList<Grade> grades = new ArrayList<Grade>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String firstLine = br.readLine();
            while (firstLine != null){
                String[] gradeScores = firstLine.split(",");
                grades.add(gradeScores);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return grades;

    }

    public HashMap<Student, ArrayList<Grade>> addAssignmentGrades (Student s){
         private HashMap<Student, ArrayList<Grade>> resultsOfAssignments = new HashMap<Student, ArrayList<Grade>>();
        resultsOfAssignments.add(s, grades);
        return resultsOfAssignments;
    }
    
}
