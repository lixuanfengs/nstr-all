package com.nstr.common.core.exception;

/**
 * @author MrBird
 */
public class NstrException extends RuntimeException {

    private static final long serialVersionUID = -6916154462432027437L;

    public NstrException(String message) {
        super(message);
    }
}