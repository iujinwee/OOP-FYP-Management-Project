package Entity.DatabaseClass;

import Entity.UserClass.Supervisor;

public class SupervisorDB extends Database{

    public SupervisorDB(){
        super("faculty_list.xlsx", new Supervisor());
    }

    public Supervisor findInstance(String id) {
        for (Object s: super.objectDB){
            if(((Supervisor) s).getUserID().compareTo(id)==0){
                return ((Supervisor) s);
            }
        }
        return new Supervisor();
    }

    public void view(){
        System.out.println("\n================================");
        System.out.println("======   SUPERVISOR LIST  ======");
        System.out.println("================================\n");
        
        for (Object s: super.objectDB){
            System.out.println(((Supervisor)s).getName() + " (" + ((Supervisor)s).getUserID() + ")");
        }
    }
}