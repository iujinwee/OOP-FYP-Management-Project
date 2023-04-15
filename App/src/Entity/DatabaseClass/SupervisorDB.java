package Entity.DatabaseClass;

import Entity.UserClass.Supervisor;

public class SupervisorDB extends Database{

    public SupervisorDB(){
        super("faculty_list.xlsx", new Supervisor());
    }

    /**
     * Find instance of Supervisor object in SupervisorDB, matched by the User ID, not case sensitive.
     * @param id Input User ID to be found.
     * @return Supervisor object.
     */
    public Supervisor findInstance(String id) {
        for (Object s: super.objectDB){
            if(((Supervisor) s).getUserID().toLowerCase().compareTo(id.toLowerCase())==0){
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