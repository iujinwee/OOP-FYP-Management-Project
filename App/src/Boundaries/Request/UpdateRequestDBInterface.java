package Boundaries.Request;

import Entity.RequestClass.RequestType;

public interface UpdateRequestDBInterface {
    abstract void updateDB(RequestType type);
}
