public abstract class Students {

    protected double studentMark;
    protected int studentId;

    protected ExamMediator examHandler;

    public Students(ExamMediator examHandler) {
        this.examHandler = examHandler;
    }

    public abstract void setID(int id);
    public abstract int getID();
    public abstract double getStudentMark();
    public abstract void setStudentMark(double studentMark);
    public abstract void requestRecheck();
    public abstract void receiveMark();
    public abstract void receiveCorrectedMarks(double correctedMarks);
}
