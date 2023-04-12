package Requests.ViewRequestsPackage;

import Users.UserDetails.User;

public interface RequestInterface {
    abstract void header();
    abstract void body(User user);
    abstract void footer();
}
