package Database;

import Users.Student;

public class StudentDB extends Database{

    public StudentDB(){
        super("student_list.xlsx", new Student());
    }

    public Student findInstance(String id) {
        for (Object s: super.objectDB){
            Student temp = (Student) s;
            if(temp.getUserID().compareTo(id)==0){
                return temp;
            }
        }
        return null;
    }

    public void showStudentDB(){
        for (Object s: super.objectDB){
            Student temp = (Student) s;
            System.out.println(temp.getUserID() + ", " + temp.getName() + ", " + temp.getEmail());
        }
    }
}
