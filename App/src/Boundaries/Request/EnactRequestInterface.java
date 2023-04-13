package Boundaries.Request;

import Exceptions.InvalidInputException;

public interface EnactRequestInterface {
    void enactRequest(int choice) throws InvalidInputException;
}
