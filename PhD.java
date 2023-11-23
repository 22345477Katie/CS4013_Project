public class Phd extends Postgrad {
    private String thesis;
    public Phd(String programId, String name, int duration) {
        super(programId, name, duration);
    }

    public void programProgression(Student student) {
        int currentYear = student.getYearOfStudy();
        if (currentYear < getDuration()) {
            System.out.println("PhD progression to the next year.");
            student.setYearOfStudy(currentYear + 1);
        } else {
            System.out.println("Student has completed the PhD program.");
        }
    }

    public String programID() {
        return getProgramId();
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }
}
