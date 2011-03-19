package com.apress.springbatch.statement.exception;

public class InvalidItemException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidItemException() {
    }

    public InvalidItemException(String arg0) {
        super(arg0);
    }

    public InvalidItemException(Throwable arg0) {
        super(arg0);
    }

    public InvalidItemException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
