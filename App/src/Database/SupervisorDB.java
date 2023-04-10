package Database;

import Users.Supervisor;

public class SupervisorDB extends Database{

    public SupervisorDB(){
        super("faculty_list.xlsx", new Supervisor());
    }

    @Override
    public Supervisor findInstance(String id) {
        for (Object s: super.objectDB){
            Supervisor temp = (Supervisor) s;
            if(temp.getUserID().compareTo(id)==0){
                return temp;
            }
        }
        return null;
    }

    public void showSupervisorDB(){
        for (Object s: super.objectDB){
            Supervisor temp = (Supervisor) s;
            System.out.println(temp.getUserID() + ", " + temp.getName() + ", " + temp.getEmail());
        }
    }
}
