package Boundaries.Project;

import Entity.ProjectClass.Project;

public interface ViewProjectInterface {

    /** 
	 * Abstract method to get Basic Project Information - Project Status, Project ID, Project Title.
     * @param proj Project Object
	 * @return int
	 */
    abstract public int viewBasicProjectInfo(Project proj);

    /** 
	 * Abstract method to get Full Project Information.
	 * @param proj Project Object
	 */
    abstract public void viewFullProjectInfo(Project proj);
}
