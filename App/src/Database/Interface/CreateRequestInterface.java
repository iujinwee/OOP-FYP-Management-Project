package Database.Interface;

import Requests.RequestType;
import Users.UserDetails.User;

public interface CreateRequestInterface {
	abstract public void createRequest(RequestType type, User fromUser, User toUser, int projID);
}
