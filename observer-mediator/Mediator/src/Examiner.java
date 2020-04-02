import java.util.ArrayList;
import java.util.Random;

public class Examiner {
    private ArrayList<Students> students;
    private ArrayList<Double> studentMarks;


    public Examiner(){
        this.studentMarks = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addStudents(Students students){
        this.students.add(students);
    }

    public void addStudentMarks(double mark){
        this.studentMarks.add(mark);
    }

    public ArrayList sendReports() {
        System.out.println("Examiner prompt: Scripts and marks of student id 1,2,3,4,5 have been sent to exam controller office.");
        return this.studentMarks;
    }

    public ArrayList addStudents() {
        return this.students;
    }

    public ArrayList checkResult(ArrayList list){
        ArrayList<Integer> temp = list;
        System.out.print("\n\nExaminer prompt:Exam script of student id ");
        for (int id:temp
             ) {
            System.out.print(id+" ");
        }

        System.out.println("received for re-examine.");

        if(temp.size()==1) {
            System.out.println("Marks of student id "+temp.get(0)+"unchanged");
            return temp;
        }

        Random random = new Random();
        double marks = 0;
        int tempId = (random.nextInt(temp.size()-1)+1) ;

        for(int i=0;i<temp.size();i++){
            if((temp.get(i)) != temp.get(tempId)){
                System.out.println("Marks of student id"+temp.get(i)+" unchanged");
               // temp.remove(students.get(i).getID());
            }

            else  {
                marks = students.get(temp.get(i)-1).getStudentMark();
                System.out.print("Marks of student id "+temp.get(i)+" changed.");
                System.out.println("Previous marks were "+marks+",now the corrected marks are "+(marks+20));
                studentMarks.set(temp.get(i)-1,studentMarks.get(temp.get(i)-1)+20);
            }

        }

//        System.out.println("Marks of student id "+temp.get(0)+"changed");
//        System.out.println("Previous marks were "+marks+" ,now the corrected marks are "+(marks+10));

        return temp;
    }
}
