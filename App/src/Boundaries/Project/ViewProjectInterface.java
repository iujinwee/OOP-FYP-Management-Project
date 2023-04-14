package Boundaries.Project;

import Entity.ProjectClass.Project;

public interface ViewProjectInterface {
    abstract public int viewBasicProjectInfo(Project proj);
    abstract public void viewFullProjectInfo(Project proj);
}
