public class Masters extends PostgradProgram {
    public Masters(String programId, String name, int duration) {
        super(programId, name, duration);
    }

    public void programProgression(Student student) {
        int currentYear = student.getYearOfStudy();
        if (currentYear < getDuration()) {
            student.setYearOfStudy(currentYear + 1);
        } else {
            System.out.println("Student has completed the master's program.");
        }
    }

    public String programID() {
        return getProgramId();
    }
}
