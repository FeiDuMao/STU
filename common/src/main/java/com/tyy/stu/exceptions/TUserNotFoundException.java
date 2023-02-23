package com.tyy.stu.exceptions;

import java.util.List;

public class TUserNotFoundException extends TBaseException {

    public TUserNotFoundException(String message) {
        super("not_found_key", message, List.of());
    }
}
