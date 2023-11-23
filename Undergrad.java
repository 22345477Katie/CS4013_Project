public class Undergrad extends Program {
    private int year;
    private String course;

    public Undergrad(String programId, String name, int duration) {
        super(programId, name, "Undergraduate", duration);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void programProgression(Student student) {
        int currentYear = student.getYearOfStudy();
        if (currentYear < getDuration()) {
            System.out.println("Undergraduate progression to the next year.");
            student.setYearOfStudy(currentYear + 1);
        } else {
            System.out.println("Student has completed the undergraduate program.");
        }
    }

    public String programID() {
        return getProgramId();
    }
}
