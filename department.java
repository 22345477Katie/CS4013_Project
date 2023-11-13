public class Department {
    String departmentName ;
    String studentsResults ;
    int departmentId ;
    boolean progression ; 
    //ArrayList<Faculty> staffInDepartment ? ;
    
    //creating a department with a name and an id
    public Department (String departmentName, int departmentId){
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }
    
    public int getDepartmentId(){
        return this.departmentId;
    }
    
    //method to return whether a student is progressing or not, I think 
    //this should be attached to program/course maybe, department can access
    //this info but should it be part of department??
    public boolean reviewProgression(double qca){
        if(qca >= 2.0){
            progression = true;
        } else {
            progression = false;
        }
        
        return progression;
    }
    
    
}