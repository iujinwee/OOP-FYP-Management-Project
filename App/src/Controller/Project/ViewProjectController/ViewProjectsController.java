package Controller.Project.ViewProjectController;

import java.util.ArrayList;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Controller.Project.LoadProjectDBController;

public abstract class ViewProjectsController extends LoadProjectDBController implements HeaderInterface, FooterInterface {
    
    public ArrayList<Integer> projects = new ArrayList<>();

    public ViewProjectsController() {
        super();
    }
    
    @Override
    public void footer() {
        if(projects.size()==0) {
			System.out.println("\n=========     NO PROJECTS FOUND!     =========\n");
		} else {
			System.out.println("\n=========   END OF PROJECT LIST  ===========\n");
		}
    }
}
