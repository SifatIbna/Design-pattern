public class ExamHandler {
    public static void main(String[] args) {
        ExamMediator examMediator = new ExamController();

        Examiner examiner = new Examiner();

        Students students1 = new StudentImp(examMediator);
        students1.setID(1);

        Students students2 = new StudentImp(examMediator);
        students2.setID(2);

        Students students3 = new StudentImp(examMediator);
        students3.setID(3);

        Students students4 = new StudentImp(examMediator);
        students4.setID(4);

        Students students5 = new StudentImp(examMediator);
        students5.setID(5);

        examiner.addStudents(students1);
        examiner.addStudentMarks(65);
        examiner.addStudents(students2);
        examiner.addStudentMarks(70);
        examiner.addStudents(students3);
        examiner.addStudentMarks(63);
        examiner.addStudents(students4);
        examiner.addStudentMarks(60);
        examiner.addStudents(students5);
        examiner.addStudentMarks(55);

        examMediator.setExaminer(examiner);
        examMediator.sendReports();

    }
}
