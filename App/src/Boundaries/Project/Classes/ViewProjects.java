package Boundaries.Project.Classes;

import java.util.ArrayList;

import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Controller.Project.LoadProjectDBController;

public abstract class ViewProjects extends LoadProjectDBController implements HeaderInterface, FooterInterface {
    
    public ArrayList<Integer> projects = new ArrayList<>();

    public ViewProjects() {
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
