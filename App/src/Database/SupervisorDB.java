package Database;

import Users.Supervisor;

public class SupervisorDB extends Database{

    public SupervisorDB(){
        super("faculty_list.xlsx", new Supervisor());
    }

    public Supervisor findInstance(String id) {
        for (Object s: super.objectDB){
            Supervisor currentSupervisor = (Supervisor) s;
            if(currentSupervisor.getUserID().compareTo(id)==0){
                return currentSupervisor;
            }
        }
        return new Supervisor();
    }

    public void view(){
        for (Object s: super.objectDB){
            System.out.println(((Supervisor)s).getName());
        }
    }
}
