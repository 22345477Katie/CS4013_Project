import java.util.*;
public class Semester{
    private double factor;
    private int semester;
    private ArrayList<Module> modules = new ArrayList<Module>();
    
    public Semester(double factor, int semester){
        this.factor = factor;
        this.semester = semester;
    }
    
    public int getSemester(){
        return semester;
    }
    
    public double getFactor(){
        return factor;
    }

    public void addModules(Module m){
        modules.add(m);
    }

    public int getYear(){
        if(semester%2==1){
            year = semester/2+1;
        }else{
            year = semester/2;
        }
        return year;
    }
}
