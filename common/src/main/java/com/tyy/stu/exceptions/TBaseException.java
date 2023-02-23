package com.tyy.stu.exceptions;

import java.io.Serializable;
import java.util.List;


public class TBaseException extends RuntimeException {

    private final String key;
    private final String message;
    private final List<? extends Serializable> args;

    public TBaseException(String key, String message, List<? extends Serializable> args) {
        this.key = key;
        this.message = message;
        this.args = args;
    }

    public TBaseException(String message, String key, String message1, List<? extends Serializable> args) {
        super(message);
        this.key = key;
        this.message = message1;
        this.args = args;
    }

    public TBaseException(String message, Throwable cause, String key, String message1, List<? extends Serializable> args) {
        super(message, cause);
        this.key = key;
        this.message = message1;
        this.args = args;
    }

    public TBaseException(Throwable cause, String key, String message, List<? extends Serializable> args) {
        super(cause);
        this.key = key;
        this.message = message;
        this.args = args;
    }

    public TBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String key, String message1, List<? extends Serializable> args) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.key = key;
        this.message = message1;
        this.args = args;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public List<? extends Serializable> getArgs() {
        return args;
    }
}
