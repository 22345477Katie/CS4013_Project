public class Module {
    int moduleId ;
    double percentage;
    String grade;
    int semester;
    int credits;
    int duration;
    String moduleName;
    
    public Module(String moduleName,int moduleId, int credits, int duration){
        this.moduleId = moduleId;
        this.credits = credits;
        this.duration = duration;
        this.moduleName = moduleName;
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
    
    public String grade(Double percentage){
        this.percentage = percentage;
        if(percentage >= 75.0){
            grade = "A1";
        } else if(percentage >= 70.0){
            grade = "A2";
        } else if(percentage >= 65.0){
            grade = "B1";
        } else if(percentage >= 60.0){
            grade = "B2";
        } else if(percentage >= 55.0){
            grade = "B3";
        } else if(percentage >= 50.0){
            grade = "C1";
        } else if(percentage >= 45.0){
            grade = "C2";
        } else if(percentage >= 40.0){
            grade = "C3";
        } else if(percentage >= 35.5){
            grade = "D1";
        } else if(percentage >= 30.0){
            grade = "D2";
        } else {
            grade = "F";
        }
        
        return grade;
    }
}
