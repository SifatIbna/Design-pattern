import java.util.Scanner;

public class StudentImp extends Students{

    public StudentImp(ExamMediator examHandler){
        super(examHandler);
    }

    @Override
    public int getID() {
        return this.studentId;
    }

    public double getStudentMark(){
        return this.studentMark;
    }

    @Override
    public void setID(int id) {
        this.studentId = id;
    }

    @Override
    public void setStudentMark(double studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public void requestRecheck() {
        examHandler.addRecheckStudent(studentId);
    }

    @Override
    public void receiveMark() {
        System.out.println("Student"+studentId+" prompt : Result published.Got marks "+studentMark);
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to apply for re-examine?\n"+"1.yes\n2.no");
        int choice = input.nextInt();
        if (choice == 1) {
            requestRecheck();
        }

        else {
            return;
        }
    }

    @Override
    public void receiveCorrectedMarks(double correctedMarks) {
        if(correctedMarks==0){
            System.out.println("Student id "+studentId+" prompt:Marks unchanged");
        }

        else {
            System.out.println("Student id "+studentId+" prompt: Marks were previously "+studentMark+".Now the corrected marks are "+correctedMarks+".");
            setStudentMark(correctedMarks);
        }
    }
}
