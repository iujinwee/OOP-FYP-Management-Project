package Users.UserRole;
import java.util.*;

import Projects.ProjectDetails.Project;
import Requests.RequestDetails.Request;

public class Supervisor extends Administrator  {

	Collection<Request> sends;
	Collection<Project> create;
	private String supervisorID;
	private int numAssignedProjects;
	private int projectLimit = 2;

	/**
	 * 
	 * @param userID
	 * @param name
	 */
	public Supervisor(String userID, String name) {
		super(userID, name, name);
	}

	public void showMenu(){
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Create New Project");
		System.out.println("[2] View Projects created by me");
		System.out.println("[3] Change Title of Project");
		System.out.println("[4] Change Supervisor of Project");
		System.out.println("[5] Manage Incoming Requests ");
		System.out.println("[6] View Incoming Requests ");
		System.out.println("[0] Exit Program.");
	}
	

	public static void main(String args[]){
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			option=sc.nextInt();
			switch (option){
				case 0:
					super.createProject();
				case 1: 
			}
			
		}while (option<6);
	}

}