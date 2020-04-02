import java.util.ArrayList;

public interface ExamMediator {
    public void addStudents();
    public void addMarks();
    public void setExaminer(Examiner examiner);
    public void Scrutinization();
    public void sendReports();
    public void sendCorrectedReports();
    public void addRecheckStudent(int id);

}
