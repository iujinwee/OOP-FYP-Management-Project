package Database;

import Users.Student;

public class RequestDB extends Database{

    public RequestDB(){
        super("student_list.xlsx", new Student());
    }

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
