package Controller.Project.ViewProjectController;

import java.util.ArrayList;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.UserBodyInterface;
import Controller.Project.LoadProjectDBController;

public abstract class ViewProjectsController extends LoadProjectDBController implements HeaderInterface, UserBodyInterface, FooterInterface {
    
    public ArrayList<Integer> projects = new ArrayList<>();

    public ViewProjectsController() {
        super();
    }
    
    @Override
    public void footer() {
        if(projects.size()==0){
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF PROJECT LIST  ===========\n");
		}
    }
}
