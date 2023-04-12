package Projects.ViewProjectsPackage;

import Users.UserDetails.User;

public interface ProjectInterface {
    abstract void header();
    abstract void body(User user);
    abstract void footer();
}
