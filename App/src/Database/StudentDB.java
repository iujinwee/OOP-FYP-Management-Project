package Database;

import Users.Student;

public class StudentDB extends Database{

    public StudentDB(){
        super("student_list.xlsx", new Student());
    }

    @Override
    public Student findInstance(String id) {
        for (Object s: super.objectDB){
            Student currentStudent = (Student) s;
            if(currentStudent.getUserID().compareTo(id)==0){
                return currentStudent;
            }
        }
        return new Student();
    }
}
