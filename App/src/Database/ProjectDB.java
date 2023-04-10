package Database;

import Projects.Project;
import Projects.ProjectStatus;
import Users.*;
import Users.UserDetails.User;

public class ProjectDB extends Database{

	private int projectLimit = 2;

    public ProjectDB(){
        super("rollover_project.xlsx", new Project());
    }

    public Project findInstance(int id) {
        for (Object s: super.objectDB){
            Project currenProject = (Project) s;
            if(currenProject.getProjectID() == id){
                return currenProject;
            }
        }
        return new Project();
    }

    public void createProject(Supervisor supervisor) {
		//ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1
		if (hasVacancy(supervisor)) {
			int newID = ++super.size; 
			Project newProject = new Project(newID); // Default 
			newProject.setSupervisor(supervisor); 
			setNewTitle(newID); // Ask for input 

            // Add and export new project
            super.objectDB.add(newProject);
            super.exportDB();
		}
		else {
			System.out.println("Error! You are unable to create anymore projects!");
		}
	}

    
	/**
	 * 
	 * @param newTitle
	 */
	public void setNewTitle(int projectID) {

		System.out.println("Input your project title");
		String title = super.sc.nextLine();

		(findInstance(projectID)).setProjectTitle(title); // rmb to close scanner
        super.exportDB();
	}

	public void changeSupervisor(int projectID, Supervisor supervisor) {
        
		(findInstance(projectID)).setSupervisor(supervisor);
        
        super.exportDB();
	}

	public void setProjectStatus(int projectID, ProjectStatus updatedStatus) {
		// if approved, then run countproject
		(findInstance(projectID)).setProjectStatus(updatedStatus);

        super.exportDB();
	}

	public void deregisterProject(int projectID, String studentID) { 
		
		(findInstance(projectID)).addRejected(studentID);

        super.exportDB();
	}

	public boolean allocateStudent(int projectID, Student student){
		
		// Check if student has been rejected previously
		if((findInstance(projectID)).getRejected().contains(student.getUserID())){
			System.out.println("Student has been rejected previously.");
			return false;
		}

		// Allocate student
		(findInstance(projectID)).setStudent(student);
        super.exportDB();
		return true;
	}

	/**
	 * 
	 * @param userType
	 */
	public void viewProjects(User user) {
		System.out.println("\n========    Project List    ========");

		for (Object obj: super.objectDB){
			Project curProj = (Project) obj;

            switch(user.getUserType()){
                // Supervisor can access his/ her own projects
                case SUPERVISOR: 
                    if(curProj.getSupervisorID().compareTo(user.getUserID())==0){
                        System.out.printf("[%d] %s\n", curProj.getProjectID(), curProj.getProjectTitle());
                    }
                    break;

                // Student can only access available projects 
                case STUDENT: 
                    if(curProj.getProjectStatus()==ProjectStatus.AVAILABLE){
                        System.out.printf("[%d] %s\n", curProj.getProjectID(), curProj.getProjectTitle());
                    }
                    break;

                // FYP Coordinator can access all projects
                case FYPCOORDINATOR: 
                    System.out.printf("[%d] %s\n", curProj.getProjectID(), curProj.getProjectTitle());
                    break;

                default:
                    System.out.println("No Projects Found!");
                    break;
            }
		}
	}

	public boolean hasVacancy(Supervisor supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
		if (supervisor.getNumAssignedProjects() >= projectLimit) {
			for (Object obj : super.objectDB) {
				Project curProject = (Project) obj;
				if (supervisor.getUserID().compareTo(curProject.getSupervisorID())==0) {
					setProjectStatus(curProject.getProjectID(), ProjectStatus.UNAVAILABLE);
				}
				return false;
			}
		}
		return true;
	}

}
