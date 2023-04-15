package Boundaries.Request;

public interface ManageRequestInterface {

    /**
	 * Abstract method used to approve request.
	 */
    abstract public void approve();

    /**
	 * Abstract method used to reject request.
	 */
    abstract public void reject();
}
