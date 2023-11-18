public class Semester{
    private double factor;
    private int semester;
    
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
}