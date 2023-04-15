package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;

public class ChangeProjectTitle extends ModifyProjectController{

    private int projID;
    private String newTitle;
    
    public ChangeProjectTitle(int projID, String newTitle){
        super();
        this.projID = projID;
        this.newTitle = newTitle;
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {
		projDB.findInstance(projID).setProjectTitle(newTitle);
	}

}
