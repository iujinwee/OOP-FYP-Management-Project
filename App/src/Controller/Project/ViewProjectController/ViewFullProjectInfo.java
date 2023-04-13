package Controller.Project.ViewProjectController;

import Entity.ProjectClass.Project;
import Entity.UserClass.UserDetails.User;

public class ViewFullProjectInfo extends ViewProjectsController{
    private Project proj;
    
    public ViewFullProjectInfo(Project proj){
        this.proj = proj;
        header();
        body(proj.getStudent());
    }

    @Override
    public void header() {
        System.out.println("\n****************************************************************");
        System.out.println("****************         Project Details        ****************");
        System.out.println("****************************************************************\n");
    }

    @Override
    public void body(User user) {
        viewFullProjectInfo(proj);
    }
}
