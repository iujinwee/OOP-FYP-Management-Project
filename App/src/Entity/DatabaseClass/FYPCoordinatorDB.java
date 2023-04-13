package Entity.DatabaseClass;

import Entity.UserClass.FYP_Coordinator;

public class FYPCoordinatorDB extends Database{

    public FYPCoordinatorDB(){
        super("FYP_coordinator.xlsx", new FYP_Coordinator());
    }

    public FYP_Coordinator findInstance(String id) {
        for (Object s: super.objectDB){
            FYP_Coordinator currentCoordinator = (FYP_Coordinator) s;
            if(currentCoordinator.getUserID().compareTo(id)==0){
                return currentCoordinator;
            }
        }
        return new FYP_Coordinator();
    }

    public void viewDB(){
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
