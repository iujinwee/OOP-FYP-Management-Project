package Requests.ViewRequestsPackage;

import Users.UserDetails.User;

public abstract class ViewRequestsHistory extends ViewRequests {

    public ViewRequestsHistory(User user){
        initializeFiles();
        header();
        body(user);
        footer();
    }
}
