package Boundaries.Request;

import Exceptions.InvalidInputException;

public interface EnactRequestInterface {
    abstract void enactRequest(int choice) throws InvalidInputException;
}
