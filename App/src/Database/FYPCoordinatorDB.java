package Database;

import Users.FYP_Coordinator;

public class FYPCoordinatorDB extends Database{

    public FYPCoordinatorDB(){
        super("FYP coordinator.xlsx", new FYP_Coordinator());
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
}
