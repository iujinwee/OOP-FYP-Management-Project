package Boundaries.Request;

import Entity.UserClass.UserDetails.User;

public interface ViewRequestListInterface {
    abstract void header();
    abstract void body(User user);
    abstract void footer();
}
