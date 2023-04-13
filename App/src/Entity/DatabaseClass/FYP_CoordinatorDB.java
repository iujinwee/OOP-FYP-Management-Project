package Entity.DatabaseClass;

import Entity.UserClass.FYP_Coordinator;

public class FYP_CoordinatorDB extends Database{

    public FYP_CoordinatorDB(){
        super("FYP_coordinator.xlsx", new FYP_Coordinator());
    }

    /**
     * Find instance of FYP_Coordinator object in FYP_CoordinatorDB, matched by the User ID, not case sensitive.
     * @param id Input User ID to be found.
     * @return FYP_Coordinator object.
     */
    public FYP_Coordinator findInstance(String id) {
        for(Object s : super.objectDB){
            FYP_Coordinator temp = (FYP_Coordinator) s;
            String correctID = temp.getUserID().toLowerCase();
            if(correctID.compareTo(id.toLowerCase())==0){
                return temp;
            }
        }
        return new FYP_Coordinator();
    }

    public void viewDB() {
        for (Object obj : objectDB){
            FYP_Coordinator currentCoord = (FYP_Coordinator) obj;
            System.out.printf("ID: %s", currentCoord.getUserID());
            System.out.printf("Name: %s", currentCoord.getName());
            System.out.printf("Email: %s", currentCoord.getEmail());
        }
    }

    public FYP_Coordinator findInstance() {
        for (Object s: super.objectDB){
            FYP_Coordinator currentCoordinator = (FYP_Coordinator) s;
            return currentCoordinator;
        }
        return new FYP_Coordinator();
    }
}
