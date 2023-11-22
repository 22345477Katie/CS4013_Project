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
    private HashMap<String, String> gradingScale;
    private ArrayList<String> grades = new ArrayList<String>();
    private ArrayList<Integer> scale = new ArrayList<Integer>();

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

   
    public void setGradingScale(String fileName){
        
        Path pathToFile = Paths.get(fileName);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] gradesAndScales = line.split(",");
                String grade = gradesAndScales[0];
                grades.add(grade);
                String scaling = gradesAndScales[1]; 
                int scalingInt = Integer.parseInt(scaling);
                scale.add(scalingInt);
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        
        
    }
    
    
    
    public HashMap<String, String> setStudentGrades(String fileName){
        HashMap<String, String> studentGrades = new HashMap<String, String>();
        Path pathToFile = Paths.get(fileName);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] studentsAndGrade = line.split(",");
                String student = studentsAndGrade[0];
                String grade = studentsAndGrade[1];
                int gradeInt = Integer.parseInt(grade);
                for (int i = scale.size(); i >= 0; i--){
                    if(gradeInt >= scale.get(i)){
                        grade = Integer.toString(scale.get(i));
                    }
                }
                studentGrades.put(student, grade);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return studentGrades;
    }

    
    
}
