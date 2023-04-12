package Requests.ViewRequestsPackage;

import Requests.Request;

public interface ViewRequestInterface {
    abstract void initializeFiles();
    abstract int viewRequest(Request req);
}
