package Projects.ProjectClasses;

import Projects.ModifyProjectDB;

public class ChangeProjectTitle extends ModifyProjectDB{

    private int projID;
    private String newTitle;
    
    public ChangeProjectTitle(int projID, String newTitle){
        this.projID = projID;
        this.newTitle = newTitle;
        initializeFiles();
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {
		projDB.findInstance(projID).setProjectTitle(newTitle);
	}

}
