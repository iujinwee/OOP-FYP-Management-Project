package Entity.DatabaseClass;

import Entity.UserClass.Student;

public class StudentDB extends Database{

    public StudentDB(){
        super("student_list.xlsx", new Student());
    }

    /**
     * Find instance of Student object in StudentDB, matched by the User ID, not case sensitive.
     * @param id Input User ID to be found.
     * @return Student object.
     */
    public Student findInstance(String id) {
        for(Object s : super.objectDB){
            Student temp = (Student) s;
            String correctID = temp.getUserID().toLowerCase();
            if(correctID.compareTo(id.toLowerCase())==0){
                return temp;
            }
        }
        return new Student();
    }
}