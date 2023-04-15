package Boundaries.Menu;

import Entity.UserClass.UserDetails.User;

public interface UserBodyInterface {

    /**
	 * Abstract method used to display main body output.
     * @param user User Object
	 */
    abstract void body(User user);
}
