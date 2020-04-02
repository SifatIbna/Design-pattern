import java.util.ArrayList;
import java.util.Random;

public class ExamController implements ExamMediator {
    private ArrayList<Students> students;
    private ArrayList<Double> studentMark;

    private ArrayList<Integer> recheckIdList;

    private Examiner examiner;
    private Random random;

    public ExamController(){
        this.students = new ArrayList<>();
        this.studentMark = new ArrayList<>();
        this.recheckIdList = new ArrayList<>();
        this.random = new Random();

    }

    public void setExaminer(Examiner examiner){
        this.examiner = examiner;

        addStudents();
        addMarks();
        Scrutinization();
    }

    @Override
    public void addRecheckStudent(int id) {
        this.recheckIdList.add(id);
    }

    @Override
    public void addStudents() {
        this.students = examiner.addStudents();

    }

    @Override
    public void addMarks() {
        this.studentMark = examiner.sendReports();
        System.out.println("\n\nExam Controller prompt: Scripts and marks of student id 1,2,3,4,5 have been received.");
        for (int i=0;i<studentMark.size();i++){
            System.out.println("student id: "+students.get(i).getID()+" ,marks: "+studentMark.get(i));
        }
    }

    @Override
    public void Scrutinization() {

        int randomId = random.nextInt(4)+1;
        for(int i=0;i<students.size();i++){
            if(students.get(i).studentId == randomId){
                System.out.println("\n\nScrutinizing has been done.Marks of student id "+randomId+" were incorrect.");
                System.out.println("Previous marks : "+studentMark.get(i)+", corrected marks: "+(studentMark.get(i)+12));
                studentMark.set(i,(studentMark.get(i)+12));
                //System.out.println(studentMark.get(i));
                return;
            }
        }
    }

    @Override
    public void sendReports() {

        System.out.println("Result has been published to the students");
        for (int i=0;i<studentMark.size();i++){
            students.get(i).setStudentMark(studentMark.get(i));
            students.get(i).receiveMark();
        }
        if(recheckIdList.size()==0) return;
        System.out.println("Re-examine request sent");

//        for (int d:recheckIdList
//             ) {
//            System.out.println("Corrected Reports :"+d);
//        }
        sendCorrectedReports();

    }

    @Override
    public void sendCorrectedReports() {
        int temp = 0;
        if(recheckIdList.size()==1) temp = 1;

        System.out.print("Exam controller prompt: Re-examine request got from student id ");
        for (int id: recheckIdList){
            System.out.print(id+" ");
        }
        System.out.println("\n");
        System.out.print("Exam script of student id ");
        for (int id: recheckIdList){
            System.out.print(id+" ");
        }
        System.out.println("sent to the examiner");
        recheckIdList=examiner.checkResult(recheckIdList);
       // System.out.println(studentMark.get(0));

        System.out.print("Exam controller prompt : ");
        System.out.print("Marks of student id ");
        for (int i=0;i<recheckIdList.size();i++){
            if(studentMark.get(recheckIdList.get(i)-1) == students.get(recheckIdList.get(i)-1).getStudentMark()){
                System.out.print(recheckIdList.get(i)+" ");
            }
        }
        System.out.println("unchanged");
        if(temp!=1) {
            System.out.print("Marks of student id ");
            for (int i = 0; i < recheckIdList.size(); i++) {
                if (students.get(recheckIdList.get(i)-1).getStudentMark() != studentMark.get(recheckIdList.get(i)-1)) {
                    System.out.print(recheckIdList.get(i)+" updated from " + students.get(recheckIdList.get(i)-1).getStudentMark() + " to " + studentMark.get(recheckIdList.get(i)-1));
                }
            }
        }
        System.out.println("\n");
        System.out.print("student id ");
        for (int i=0;i<recheckIdList.size();i++){
            if(studentMark.get(recheckIdList.get(i)-1) == students.get(recheckIdList.get(i)-1).getStudentMark()){
                System.out.print(recheckIdList.get(i)+" ");
            }
        }
        System.out.println("has been informed about no changed in marks");
        if(temp!=1) {
            System.out.print("Updated marks have been sent to student id ");
            for (int i = 0; i < recheckIdList.size(); i++) {
                if (students.get(recheckIdList.get(i)-1).getStudentMark() != studentMark.get(recheckIdList.get(i)-1)) {
                    System.out.println(recheckIdList.get(i) + " ");

                }
            }
        }

      //  System.out.println(recheckIdList.get(0));

        for (int i=0;i<recheckIdList.size();i++){
            if(students.get(recheckIdList.get(i)-1).getStudentMark() == studentMark.get(recheckIdList.get(i)-1)) {
                students.get(recheckIdList.get(i)-1).receiveCorrectedMarks(0);
            }

            else {
                students.get(recheckIdList.get(i)-1).receiveCorrectedMarks(studentMark.get(recheckIdList.get(i)-1));
            }
        }
    }
}
