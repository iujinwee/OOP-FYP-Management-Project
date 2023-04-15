package Boundaries.Project;

import java.util.ArrayList;

import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Boundaries.Menu.Interfaces.UserBodyInterface;
import Controller.Project.LoadProjectDB;

public abstract class ViewProjects extends LoadProjectDB implements HeaderInterface, FooterInterface, UserBodyInterface {
    
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
