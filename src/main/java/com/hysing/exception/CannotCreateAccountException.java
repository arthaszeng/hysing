package com.hysing.exception;

public class CannotCreateAccountException extends Throwable {
    public CannotCreateAccountException() {
        super("Can not create a new account.");
    }
}
