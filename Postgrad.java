public class Postgrad extends Program {
    private int year;
    public Postgrad(String programId, String name, int duration) {
        super(programId, name, "Postgraduate", duration);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void programProgression(Student student) {
        int currentYear = student.getYearOfStudy();
        if (currentYear < getDuration()) {
            student.setYearOfStudy(currentYear + 1);
        } else {
            System.out.println("Student has completed the postgraduate program.");
        }
    }

    public String programID() {
        return super.getProgramId();
    }
}
