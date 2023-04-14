package Boundaries.Project;

import Entity.UserClass.UserDetails.User;

public interface ViewProjectListInterface {
    abstract void header();
    abstract void body(User user);
    abstract void footer();
}
