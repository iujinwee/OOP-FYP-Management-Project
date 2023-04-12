package Projects.ProjectClasses;

import Projects.ModifyProjectDB;

public class ChangeProjectTitle extends ModifyProjectDB{

    private int projID;
    
    public ChangeProjectTitle(int projID){
        this.projID = projID;
        initializeFiles();
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {

		System.out.println("Input the new project title:");
		String title = projDB.sc.next();

		projDB.findInstance(projID).setProjectTitle(title);
	}

}
