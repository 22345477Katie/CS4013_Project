public class Module {
    int moduleId ;
    double percentage;
    String grade;
    int semester;
    int credits;
    int duration;
    String moduleName;
    int[] gradeMarks;
    String[] gradeTitles;
    
    public Module(String moduleName,int moduleId, int credits, int duration, int[] gradeMarks, String[] gradeTitles){
        this.moduleId = moduleId;
        this.credits = credits;
        this.duration = duration;
        this.moduleName = moduleName;
        this.gradeMarks = gradeMarks;
        this.gradeTitles = gradeTitles;
    }
    
    public String getModuleName(){
        return this.moduleName;
    }
    
    public int getModuleId(){
        return this.moduleId;
    }
    
    public int getDuration(int moduleId){
        return this.duration;
    }
    
    public int getCredits(){
        return this.credits;
    }
    
    
}
