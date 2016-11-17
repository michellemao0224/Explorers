package com.michelle.explorer;

public class ExplorerOutOfBoundsException extends RuntimeException {

    public ExplorerOutOfBoundsException() {
        super("The input is out of bounds");
    }
}
