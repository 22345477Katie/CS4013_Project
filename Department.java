public class Department {
    String departmentName ;
    String studentsResults ;
    int departmentId ;
    boolean progression ; 
    
    
    //creating a department with a name and an id
    public Department (String departmentName, int departmentId){
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }

    //return id of department
    public int getDepartmentId(){
        return this.departmentId;
    }
    
    //return whether a student is progressing to the next year or not
    public boolean reviewProgression(double qca){
        if(qca >= 2.0){
            progression = true;
        } else {
            progression = false;
        }
        
        return progression;
    }
    
    
}
