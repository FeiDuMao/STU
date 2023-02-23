package com.tyy.configuration;

import com.tyy.stu.exceptions.TBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TBaseException.class)
    public ResponseEntity<ErrorResp> handleTException(TBaseException exception) {
        log.error("TException happened !,key = {} ,message = {} , args ={}",
                exception.getKey(), exception.getMessage(), exception.getArgs()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(buildErrorResp(exception));
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        log.error("RunTime exception happened! msg = {}", exception.getMessage());
        log.error("stack trace = {}", Arrays.stream(exception.getStackTrace()).map(Object::toString).toList());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }


    private ErrorResp buildErrorResp(TBaseException exception) {
        return new ErrorResp(exception.getKey(), exception.getMessage(), exception.getArgs());
    }

    record ErrorResp(String key, String message, List<? extends Serializable> args) {
    }

}
